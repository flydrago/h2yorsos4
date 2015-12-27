package com.h2y.os.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IGoodsDao;
import com.h2y.os.dao.IOrderDao;
import com.h2y.os.dao.IOrderFlowDao;
import com.h2y.os.entity.CommonActivityGoodsRt;
import com.h2y.os.entity.DataGoodsInfo;
import com.h2y.os.entity.DeliveryerDealCheck;
import com.h2y.os.entity.GoodsPrice;
import com.h2y.os.entity.MemberDealCheck;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.Order;
import com.h2y.os.entity.OrderGoodsParams;
import com.h2y.os.entity.OrderSubmitInfo;
import com.h2y.os.entity.ReceiveAddress;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.util.OrderUtil;
import com.h2y.os.util.SysBaseUtil.DeliveryStatusKey;
import com.h2y.os.util.SysBaseUtil.MemberStatusKey;
import com.h2y.os.util.SysBaseUtil.OrderGoodsKey;
import com.h2y.util.DateUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：OrderServiceImpl  
 * 类描述：  订单业务验证操作接口实现类
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午11:38:57  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午11:38:57  
 * 修改备注：  
 * @version
 */
@Service("orderCheckService")
public class OrderCheckServiceImpl implements IOrderCheckService {

	@Autowired
	protected IGoodsDao goodsDao;

	@Autowired
	protected IOrderDao orderDao;

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IOrderFlowDao orderFlowDao;

	/**
	 * 订单验证
	 * @param reqMap 请求参数
	 * @param checkType 验证类型（ 0:获取参数，1：订单提交）
	 * @return
	 */
	public OrderSubmitInfo orderCheck(Map<String,Object> reqMap,int checkType){

		
		OrderSubmitInfo orderSubmitInfo = new OrderSubmitInfo();
		orderSubmitInfo.setResultFlag(0);
		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
		String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";//区域编码
		String memberId = paraMap.get(JydKeys.memberId.value())+"";//会员id
		String receiverLongitude = paraMap.get("receiverLongitude")+"";//收货地址经度
		String receiverLatitude = paraMap.get("receiverLatitude")+"";//收货地址纬度
		String receiverAddressId = paraMap.get("receiverAddressId")+"";//收货地址id
		String receiverAddress = paraMap.get("receiverAddress")+"";//收货地址
		String receiverName = paraMap.get("receiverName")+"";//收货人名称
		String receiverMobile = paraMap.get("receiverMobile")+"";//收货人手机号码

		ReceiveAddress receiveAddress = new ReceiveAddress();
		
		SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
		orderSubmitInfo.setSysUnits(sysUnits);
		if (null==sysUnits) {
			orderSubmitInfo.setResultMsg("当前商家不合法！");
			return orderSubmitInfo;
		}

		//获取提交购物车列表
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> shoppingCartList = (List<Map<String, Object>>) paraMap.get("shoppingCartList");
		if (null==shoppingCartList || shoppingCartList.isEmpty()) {
			orderSubmitInfo.setResultMsg("提交购物车列表不能为空！");
			return orderSubmitInfo;
		}

		//会员验证
		MemberUser memberUser = new MemberUser(memberId);//会员信息
		orderSubmitInfo.setMemberUser(memberUser);
		
		//获取购物车商品列表
		Map<String,Object> shopingCartParams = new HashMap<String, Object>();
		shopingCartParams.put("memberId", memberUser.getId());
		shopingCartParams.put("shoppingCartList", shoppingCartList);
		List<Map<String,Object>> goodsList = (List<Map<String, Object>>) orderDao.getShoppingCartList(shopingCartParams);
		if (null==goodsList || goodsList.isEmpty()) {
			orderSubmitInfo.setResultMsg("当前购物车商品已经提交成功，请查看订单列表！");
			return orderSubmitInfo;
		}
		
		List<OrderGoodsParams> goodsParamsList = new ArrayList<OrderGoodsParams>();

		//区分区域代理和旗舰店商品，进行分别提交
		for (Map<String, Object> goodsData : goodsList) {
			long shopingCartId = Long.valueOf(goodsData.get("id")+"");//购物车id
			long goodsPriceId = Long.valueOf(goodsData.get(OrderGoodsKey.goodsPriceId.value)+"");//商品定价id
			GoodsPrice goodsPrice = goodsDao.get(goodsPriceId);//商品定价对象
			int gcount = Integer.parseInt(goodsData.get(OrderGoodsKey.goodsCount.value)+"");//商品数量
			CommonActivityGoodsRt commonActivityGoodsRt = null;

			if (goodsPrice.getStatus()!=0) {

				orderSubmitInfo.setResultMsg("商品“"+goodsPrice.getGoodsNickName()+"”已下架，请在购物中移除此商品！");
				orderSubmitInfo.setResultData(goodsPrice.getGoodsNickName());
				return orderSubmitInfo;
			}

			//判断商品的活动是否到期或达到上限
			if (1==goodsPrice.getIsActivity()) {

				commonActivityGoodsRt = goodsDao.getCommonActivityGoodsRt(goodsPrice.getActivityGoodsId());

				if (null==commonActivityGoodsRt) {

					orderSubmitInfo.setResultMsg("非常抱歉！活动商品“"+goodsPrice.getGoodsNickName()+"”促销未启用，请在购物中移除此商品！");
					orderSubmitInfo.setResultData(goodsPrice.getId()+"");
					return orderSubmitInfo;
				}

				if (0!=commonActivityGoodsRt.getStatus()) {//-1：删除、0：正常、1：不启用

					orderSubmitInfo.setResultMsg("活动商品“"+goodsPrice.getGoodsNickName()+"”促销活动暂未启用，请在购物中移除此商品！");
					orderSubmitInfo.setResultData(goodsPrice.getId()+"");
					return orderSubmitInfo;
				}

				if (commonActivityGoodsRt.getStartDate().after(DateUtil.getSystemTime()) || commonActivityGoodsRt.getEndDate().before(DateUtil.getSystemTime())) {//活动时间未开始

					orderSubmitInfo.setResultMsg("活动商品“"+goodsPrice.getGoodsNickName()+"”活动未开始，请在购物中移除此商品！");
					orderSubmitInfo.setResultData(goodsPrice.getId()+"");
					return orderSubmitInfo;
				}
			}
			//添加商品信息对象
			OrderGoodsParams orderGoodsParams = getGoodsData(shopingCartId,goodsPrice, gcount, 0, 0,commonActivityGoodsRt);
			goodsParamsList.add(orderGoodsParams);
			
			//订单提交
			if (checkType==1) {
				
				//添加商品的赠品
				Map<String,Object> giftParams = new HashMap<String, Object>();
				giftParams.put("goodsPriceId", goodsPriceId);
				giftParams.put("dataType", 1);
				List<DataGoodsInfo> dataGoodsInfoList = goodsDao.getDataGoodsInfoList(giftParams);
				if (null!=dataGoodsInfoList && !dataGoodsInfoList.isEmpty()) {
					for (DataGoodsInfo dataGoodsInfo : dataGoodsInfoList) {
						//添加赠品
						GoodsPrice giftGoodsPrice = goodsDao.get(dataGoodsInfo.getDataGoodsId());
						if (giftGoodsPrice.getStatus()==0) {//赠品状态
							OrderGoodsParams giftOrderGoodsParams = getGoodsData(null,giftGoodsPrice, dataGoodsInfo.getDataGoodsCount()*gcount, 1, goodsPrice.getId(),null);
							goodsParamsList.add(giftOrderGoodsParams);
						}
					}
				}
			}
		}
		
		if (checkType==1) {
			
			if (receiverName.equalsIgnoreCase("null")) {
				orderSubmitInfo.setResultMsg("收货人不能为空！");
				orderSubmitInfo.setResultData(receiverName);
				return orderSubmitInfo;
			}

			if (!MatcherUtil.isMobileNO(receiverMobile)) {
				orderSubmitInfo.setResultMsg("收货人手机号码格式不合法！");
				orderSubmitInfo.setResultData(receiverMobile);
				return orderSubmitInfo;
			}

			if (MatcherUtil.checkNumber(receiverAddressId)) {
				receiveAddress = commonDao.getReceiveAddress(Long.valueOf(receiverAddressId));
			}

			if (!MatcherUtil.checkNumber(receiverAddressId) || null==receiveAddress) {

				receiveAddress = new ReceiveAddress();
				receiveAddress.setZoneName("");
				receiveAddress.setZoneDetail(receiverAddress);
				receiveAddress.setReceiverName(receiverName);
				receiveAddress.setReceiverMobile(receiverMobile);
				receiveAddress.setLongitude(MatcherUtil.checkFloat(receiverLongitude)?new BigDecimal(receiverLongitude):null);
				receiveAddress.setLatitude(MatcherUtil.checkFloat(receiverLatitude)?new BigDecimal(receiverLatitude):null);
			}
			orderSubmitInfo.setReceiveAddress(receiveAddress);
		}

		orderSubmitInfo.setResultFlag(1);
		orderSubmitInfo.setGoodsParamsList(goodsParamsList);
		orderSubmitInfo.setResultMsg("订单验证通过！");
		orderSubmitInfo.setOrderNo(OrderUtil.getOrderNo());
		orderSubmitInfo.setReceiveAddress(receiveAddress);
		return orderSubmitInfo;
	}


	/**
	 * 得到商品数据
	 * @param shopingCartId 购物车id
	 * @param goodsPrice 定价商品对象
	 * @param gcount 商品数量
	 * @param isGift 是否为赠品（0：否，1：是）
	 * @param giftMainGoodsId 赠品对应的主商品id 不是赠品时，为0
	 * @return
	 */
	private OrderGoodsParams getGoodsData(Long shopingCartId,GoodsPrice goodsPrice,int gcount,int isGift,long giftMainGoodsId,CommonActivityGoodsRt commonActivityGoodsRt){

		OrderGoodsParams orderGoodsParams = new OrderGoodsParams();
		orderGoodsParams.setGoodsPrice(goodsPrice);
		orderGoodsParams.setCommonActivityGoodsRt(commonActivityGoodsRt);
		orderGoodsParams.setGiftMainGoodsId(giftMainGoodsId);
		orderGoodsParams.setGoodsCount(gcount);
		orderGoodsParams.setIsGift(isGift);
		orderGoodsParams.setShopingCartId(shopingCartId);
		return orderGoodsParams;
	}

	public DeliveryerDealCheck deliveryerDealCheck(Map<String,Object> reqMap,DeliveryerDealCheck deliveryerDealCheck) {

		deliveryerDealCheck.setResultFlag(0);
		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
		String orderNo = paraMap.get("orderNo")+"";//订单编号

		if (!MatcherUtil.checkNumber(paraMap.get("orderStatus")+"")) {
			deliveryerDealCheck.setResultMsg("订单状态不合法！");
			return deliveryerDealCheck;
		}
		
		int orderStatus = Integer.parseInt(paraMap.get("orderStatus")+"");//订单状态

		DeliveryStatusKey deliveryStatusKey = OrderUtil.getDeliveryStatusByStatus(orderStatus);
		if (null==deliveryStatusKey) {
			deliveryerDealCheck.setResultMsg("订单处理失败，无效处理标识！");
			return deliveryerDealCheck;
		}

		//判断配送员是否已经处理过
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orderNo", orderNo);
		params.put("orderStatus", orderStatus);
		if (orderFlowDao.getRowsByStatus(params)>0) {
			
			deliveryerDealCheck.setResultMsg("当前订单，当前状态已经处理过！");
			return deliveryerDealCheck;
		}

		//判断订单是否存在
		Order order = orderDao.getByOrderNo(orderNo);
		if (null == order) {

			deliveryerDealCheck.setResultMsg("当前订单不存在！");
			return deliveryerDealCheck;
		}

		deliveryerDealCheck.setResultFlag(1);
		deliveryerDealCheck.setResultMsg("配送员订单处理验证通过！");
		deliveryerDealCheck.setOrderStatus(orderStatus);
		deliveryerDealCheck.setOrder(order);
		deliveryerDealCheck.setStatusName(deliveryStatusKey.name);
		return deliveryerDealCheck;
	}


	public MemberDealCheck memberDealCheck(Map<String, Object> reqMap) {

		MemberDealCheck memberDealCheck = new MemberDealCheck();
		memberDealCheck.setResultFlag(0);

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
		String orderNo = paraMap.get("orderNo")+"";//订单编号
		int orderStatus = Integer.parseInt(paraMap.get("orderStatus")+"");//订单状态
		String memberId = paraMap.get(JydKeys.memberId.value())+"";

		Order order = orderDao.getByOrderNo(orderNo);
		if (null==order) {
			memberDealCheck.setResultMsg("当前订单不存在！");
			memberDealCheck.setResultData(orderNo);
			return memberDealCheck;
		}

		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orderNo", orderNo);
		params.put("orderStatus", orderStatus);
		if (orderFlowDao.getRowsByStatus(params)>0) {
			memberDealCheck.setResultMsg("当前状态，当前订单已经处理过！");
			memberDealCheck.setResultData(orderNo+":"+orderStatus);
			return memberDealCheck;
		}

		MemberUser memberUser = new MemberUser(memberId);
		MemberStatusKey memberStatusKey = OrderUtil.getMemberStatusByStatus(orderStatus);
		if (null==memberStatusKey) {
			memberDealCheck.setResultMsg("订单处理失败，无效处理标识！");
			memberDealCheck.setResultData(orderStatus+"");
			return memberDealCheck;
		}

		memberDealCheck.setResultFlag(1);
		memberDealCheck.setResultMsg("会员验证通过！");
		memberDealCheck.setMemberUser(memberUser);
		memberDealCheck.setOrder(order);
		memberDealCheck.setOrderStatus(orderStatus);
		memberDealCheck.setStatusName(memberStatusKey.name);
		return memberDealCheck;
	}
}
