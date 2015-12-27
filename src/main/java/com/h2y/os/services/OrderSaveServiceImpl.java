package com.h2y.os.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IGoodsDao;
import com.h2y.os.dao.IOrderDao;
import com.h2y.os.dao.IOrderFlowDao;
import com.h2y.os.dao.IOrderGoodsRtDao;
import com.h2y.os.entity.DeliveryerDealCheck;
import com.h2y.os.entity.GoodsPrice;
import com.h2y.os.entity.MemberDealCheck;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.Order;
import com.h2y.os.entity.OrderFlow;
import com.h2y.os.entity.OrderGoodsParams;
import com.h2y.os.entity.OrderGoodsRt;
import com.h2y.os.entity.OrderParams;
import com.h2y.os.entity.OrderSubmitInfo;
import com.h2y.os.entity.ReceiveAddress;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.util.OrderUtil;
import com.h2y.os.util.SysBaseUtil.MemberStatusKey;
import com.h2y.os.util.SysBaseUtil.OrderOperatorType;
import com.h2y.util.Arith;
import com.h2y.util.DateUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：OrderServiceImpl  
 * 类描述：  订单业务保存操作接口  实现类
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午11:38:57  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午11:38:57  
 * 修改备注：  
 * @version
 */
@Service("orderSaveService")
public class OrderSaveServiceImpl implements IOrderSaveService {

	@Autowired
	protected IOrderDao orderDao;

	@Autowired
	protected IOrderFlowDao orderFlowDao;

	@Autowired
	protected IOrderGoodsRtDao orderGoodsRtDao;

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IGoodsDao goodsDao;
	
	public void deliveryerDealSave(DeliveryerDealCheck deliveryerDealCheck) {

		Order order = deliveryerDealCheck.getOrder();
		int orderStatus = deliveryerDealCheck.getOrderStatus();
		OrderFlow orderFlow = OrderUtil.getOrderFlow(order.getOrderNo(), order.getId(), "", "配送员", 1, deliveryerDealCheck.getOrderStatus(),deliveryerDealCheck.getStatusName());
		orderFlowDao.add(orderFlow);
		
		order.setOrderStatus(orderStatus);
		order.setDeliveryerStatus(orderStatus);
		orderDao.update(order);
	}

	public void memberDealSave(MemberDealCheck memberDealCheck) {

		MemberUser memberUser = memberDealCheck.getMemberUser();
		Order order = memberDealCheck.getOrder();
		int orderStatus = memberDealCheck.getOrderStatus();

		//添加订单流程
		String memberName = memberUser.getAccount();
		if (null!=memberUser.getRealName() && !"".equals(memberUser.getRealName())) {
			memberName+= "("+memberUser.getRealName()+")";
		}
		OrderFlow orderFlow = OrderUtil.getOrderFlow(order.getOrderNo(), order.getId(), memberUser.getId(), memberName, 2, orderStatus,memberDealCheck.getStatusName());
		orderFlowDao.add(orderFlow);

		order.setOrderStatus(orderStatus);
		order.setReceiverStatus(orderStatus);
		orderDao.update(order);
	}

	/**
	 * 获取单位订单参数
	 * @param orderUnique 订单唯一标识
	 * @param unitGoodsParams 单位商品参数
	 * @param isUseVipCoin 是否使用达人币（0：不使用、1：使用）
	 * @param vipCoin 使用的达人币数量
	 * @param vipCoinRatio 达人币换算比例
	 * @return
	 */
	public OrderParams getUnitOrderParams(OrderSubmitInfo orderSubmitInfo){

		//单位提交的商品列表[{goodsPriceId:定价id，goodsCount:商品数量}]
		List<OrderGoodsParams> orderGoodsParamsList = orderSubmitInfo.getGoodsParamsList();
		//购物车id列表
		List<Long> shopingCartIds = new ArrayList<Long>();
		String orderNo = OrderUtil.getOrderNo();
		SysUnits sysUnits = orderSubmitInfo.getSysUnits();
		
		long unitId = sysUnits.getId();
		Double goodsAmount = 0d;//商品总价格
		Double goodsTransportAmount = 0d;//商品运费
		Double giveBean = 0d;//促销活动，赠送达人豆数量
		Double giveCoin = 0d;//促销活动，赠送达人币数量
		Double goodsGiveCoin = 0d;//商品，赠送达人币数量
		int goodsCount = 0;//商品数量（包括商品和赠品数量）
		int giftCount = 0;//赠品数量

		OrderParams orderParams = new OrderParams();

		List<OrderGoodsRt> orderGoodsRtList = new ArrayList<OrderGoodsRt>();
		for (OrderGoodsParams orderGoodsParams : orderGoodsParamsList) {

			GoodsPrice goodsPrice = orderGoodsParams.getGoodsPrice();
			int gcount = orderGoodsParams.getGoodsCount();
			int buyType = orderGoodsParams.getBuyType();//暂时只考虑购买的情况
			int isGift = orderGoodsParams.getIsGift();//是否为赠品 0：否 1：是
			long dataId = orderGoodsParams.getGiftMainGoodsId();//赠品关联的主商品

			//添加购物车列表
			if (null!=orderGoodsParams.getShopingCartId()) {
				shopingCartIds.add(orderGoodsParams.getShopingCartId());
			}

			Double singlePrice = goodsPrice.getIsActivity()==1?goodsPrice.getActivityPrice():goodsPrice.getMemberPrice();//商品单价
			if (isGift==0) {//购买的商品进行定价
				goodsAmount = Arith.add(goodsAmount, Arith.mul(Double.valueOf(gcount), singlePrice));//计算订单中商品总金额(购买的商品)
			}else {
				giftCount += gcount;
			}
			
			goodsCount += gcount;//计算订单中商品总数量（包括购买商品、赠品、酒库商品）
			OrderGoodsRt orderGoodsRt = new OrderGoodsRt();
			orderGoodsRt.setOrderNo(orderNo);
			orderGoodsRt.setBuyType(buyType);//0：购买、1：酒库
			orderGoodsRt.setCreateDate(DateUtil.getSystemTime());
			orderGoodsRt.setDataId(dataId);
			orderGoodsRt.setGoodsAmount(gcount*singlePrice);
			orderGoodsRt.setGoodsCount(gcount);
			orderGoodsRt.setGoodsNickName(goodsPrice.getGoodsNickName());
			orderGoodsRt.setGoodsNumber(goodsPrice.getGoodsNumber());
			orderGoodsRt.setGoodsPriceId(goodsPrice.getId());
			orderGoodsRt.setIsGift(isGift);//是否赠品，0：否、1：是
			orderGoodsRt.setSinglePrice(singlePrice);
			orderGoodsRt.setIsActivity(goodsPrice.getIsActivity());//是否参加活动
			orderGoodsRt.setActivityGoodsId(goodsPrice.getActivityGoodsId());//活动商品id
			orderGoodsRtList.add(orderGoodsRt);
		}

		orderParams.setOrderNo(orderNo);
		orderParams.setGoodsAmount(goodsAmount);
		orderParams.setGoodsTransportAmount(goodsTransportAmount);
		orderParams.setGiveBean(giveBean);
		orderParams.setGiveCoin(giveCoin);
		orderParams.setGoodsGiveCoin(goodsGiveCoin);
		orderParams.setGoodsCount(goodsCount);
		orderParams.setGiftCount(giftCount);
		orderParams.setOrderGoodsRts(orderGoodsRtList);
		orderParams.setShopingCartIds(shopingCartIds);
		orderParams.setUnitId(unitId);
		orderParams.setGoodsRealAmount(goodsAmount);
		orderParams.setCreateDate(DateUtil.getSystemTime());
		return orderParams;
	}

	/**
	 * 保存订单
	 * @return
	 */
	public OrderParams saveOrder(OrderSubmitInfo orderSubmitInfo){

		OrderParams orderParams = new OrderParams();

		Order order = new Order();
		
		SysUnits sysUnits = orderSubmitInfo.getSysUnits();
		MemberUser memberUser = orderSubmitInfo.getMemberUser();
		ReceiveAddress receiveAddress = orderSubmitInfo.getReceiveAddress();

		//获取订单参数（订单编码，商品总额，商品运费、商品数量、订单对应商品列表、）
		orderParams = getUnitOrderParams(orderSubmitInfo);

		order.setCreateDate(DateUtil.getSystemTime());
		order.setMemberId(memberUser.getId());
		order.setOrderCategory(0);//0:正常下单、1：个人酒库领取、2：非会员用户领取礼包
		order.setOrderNo(orderParams.getOrderNo());
		order.setOrderStatus(1);//订单状态（0：提交、1：受理、2：出库、3：签单配送中、4：客户收货、5：完成、-1：取消订单、-2：客户拒收）
		order.setOrderUnique(order.getOrderNo());

		//订单收货地址信息
		order.setReceiverAddress(receiveAddress.getZoneName()+receiveAddress.getZoneDetail());
		order.setReceiverAddressId(receiveAddress.getId());
		order.setReceiverLatitude(receiveAddress.getLatitude());
		order.setReceiverLongitude(receiveAddress.getLongitude());
		order.setReceiverMobile(receiveAddress.getReceiverMobile());
		order.setReceiverName(receiveAddress.getReceiverName());

		//订单单位信息
		order.setUnitId(sysUnits.getId());
		order.setUnitName(sysUnits.getUnitName());
		order.setUnitShortName(sysUnits.getShortName());
		order.setUnitType(sysUnits.getUnitType());
		order.setZoneCode(sysUnits.getZoneCode());
		order.setIsComment(0);

		//订单金额信息
		order.setGoodsAmount(orderParams.getGoodsAmount());
		order.setGoodsCount(orderParams.getGoodsCount());
		order.setGoodsTransportAmount(orderParams.getGoodsTransportAmount());
		order.setVipCoin(orderParams.getUseVipCoin());//达人币使用的
		order.setRealAmount(orderParams.getGoodsRealAmount());//实际支付的金额
		order.setCoinAmount(orderParams.getCoinAmount());//达人币换算的人民币

		order.setOrderStatus(MemberStatusKey.submitOrder.status); //系统管理员已受理
		order.setDeliveryerStatus(MemberStatusKey.submitOrder.status);//配送状态  待抢单 
		order.setReceiverStatus(MemberStatusKey.submitOrder.status);//收货状态  提交订单
		
		orderDao.add(order);//添加订单
		
		//会员提交
		String memberName = memberUser.getAccount();
		if (null!=memberUser.getRealName() && !"".equals(memberUser.getRealName())) {
			memberName+= "("+memberUser.getRealName()+")";
		}
		//会员 提交订单
		OrderFlow orderFlow1 = OrderUtil.getOrderFlow(orderParams.getOrderNo(), order.getId(), memberUser.getId(), memberName, OrderOperatorType.memberUser.value, MemberStatusKey.submitOrder.status,OrderUtil.getNameByOrderStatus(MemberStatusKey.submitOrder.status));
		orderFlowDao.add(orderFlow1);
		
		//订单商品添加
		orderGoodsRtDao.addBatch(orderParams.getOrderGoodsRts());

		//购物车移除商品
		Map<String,Object> shopingCartParams = new HashMap<String, Object>();
		shopingCartParams.put("ids", orderParams.getShopingCartIds());
		shopingCartParams.put("status", 1);
		orderDao.updateShoppingCartStatusByIds(shopingCartParams);
		
		orderParams.setOrder(order);
		orderParams.setResultFlag(1);
		orderParams.setResultMsg("订单保存成功！");
		return orderParams;
	}

}
