package com.h2y.os.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IGoodsDao;
import com.h2y.os.dao.IOrderDao;
import com.h2y.os.dao.IOrderFlowDao;
import com.h2y.os.dao.IOrderGoodsRtDao;
import com.h2y.os.entity.DeliveryUser;
import com.h2y.os.entity.DeliveryerDealCheck;
import com.h2y.os.entity.MemberDealCheck;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.Order;
import com.h2y.os.entity.OrderFlow;
import com.h2y.os.entity.OrderGoodsRt;
import com.h2y.os.entity.OrderParams;
import com.h2y.os.entity.OrderSubmitInfo;
import com.h2y.os.util.OrderUtil;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.ExceptionUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.LogUtil;
import com.h2y.util.LogUtil.OsLogOp;
import com.h2y.util.MatcherUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：OrderServiceImpl  
 * 类描述：  订单业务操作接口实现类
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午11:38:57  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午11:38:57  
 * 修改备注：  
 * @version
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	private final static Logger logger = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	protected IGoodsDao goodsDao;

	@Autowired
	protected IOrderDao orderDao;

	@Autowired
	protected IOrderFlowDao orderFlowDao;

	@Autowired
	protected IOrderGoodsRtDao orderGoodsRtDao;

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IOrderCheckService orderCheckService;

	@Autowired
	protected IOrderSaveService orderSaveService;

	public Map<String,Object> submit(Map<String,Object> reqMap){
		try {
			
			//订单验证
			OrderSubmitInfo orderSubmitInfo = orderCheckService.orderCheck(reqMap, 1);
			if (orderSubmitInfo.getResultFlag()==0) {
				return DataResponseUtil.getResultData(reqMap, orderSubmitInfo.getResultFlag(), orderSubmitInfo.getResultMsg());
			}
			
			OrderParams orderParams = orderSaveService.saveOrder(orderSubmitInfo);
			return DataResponseUtil.getResultData(reqMap, 1,"提交订单成功！", orderParams.getOrder());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return DataResponseUtil.getResultData(reqMap, 0, "订单提交失败，服务端出现异常！");
		}
	}

	/**
	 * 获取订单参数
	 * @param reqMap
	 * @return
	 */
	public Map<String,Object> orderParams(Map<String,Object> reqMap){

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			//订单验证
			OrderSubmitInfo orderSubmitInfo = orderCheckService.orderCheck(reqMap, 0);
			if (orderSubmitInfo.getResultFlag()==0) {

				return DataResponseUtil.getResultData(reqMap, 0, orderSubmitInfo.getResultMsg());
			}
			OrderParams orderParams = orderSaveService.getUnitOrderParams(orderSubmitInfo);

			//购买的商品列表
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", orderSubmitInfo.getMemberUser().getId());
			params.put("shoppingCartList", orderParams.getShopingCartIds());
			
			result.put("goodsCount", orderParams.getGoodsCount()-orderParams.getGiftCount());
			result.put("goodsAmount", orderParams.getGoodsAmount());
			result.put("realAmount", orderParams.getGoodsRealAmount());
			result.put("goodsList", orderDao.getShopGoodsList(params));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return DataResponseUtil.getResultData(reqMap, 0, "获取订单参数失败，出现异常！",result);
		}

		return DataResponseUtil.getResultData(reqMap, 1, "获取订单参数成功！",result);
	}


	public Map<String, Object> getList(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			String memberId = paraMap.get(JydKeys.memberId.value())+"";//会员id
			int page = Integer.parseInt(paraMap.get("page")+"");
			int pagesize = Integer.parseInt(paraMap.get("pagesize")+"");

			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", memberId);
			params.put("page", page);
			params.put("pagesize", pagesize);
			params.put("listFlag", paraMap.get("listFlag"));
			List<Map<String,Object>> orderList = orderDao.getListMap(params);
			//添加状态值（状态名称）
			OrderUtil.addStatusNameToList(orderList, "orderStatus", "orderStatusName");

			for (Map<String, Object> map : orderList) {

				String orderNo = map.get("orderNo")+"";
				//订单对应的商品
				List<Map<String,Object>> goodsList = orderDao.getOrderGoodsList(orderNo);
				map.put("goodsList", goodsList);
			}
			result = DataResponseUtil.getResultData(reqMap, 1, "获取订单列表数据成功",orderList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取订单列表数据失败，出现异常！");
		}
		return result;
	}


	public Map<String, Object> getDetail(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			String orderNo = paraMap.get("orderNo")+"";//订单编号

			//订单主信息
			Map<String,Object> orderData = orderDao.getOrderDetail(orderNo);

			//订单对应的商品
			List<Map<String,Object>> goodsList = orderDao.getOrderGoodsList(orderNo);

			//订单对应的商品
			orderData.put("goodsList", goodsList);
			//添加状态
			OrderUtil.addStatusNameToMap(orderData, "orderStatus", "orderStatusName");
			OrderUtil.addStatusNameToMap(orderData, "deliveryerStatus", "deliveryerStatusName");

			result = DataResponseUtil.getResultData(reqMap, 1, "获取订单详细数据成功",orderData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取订单详细数据失败，出现异常！");
		}
		return result;
	}

	public Map<String, Object> getTrackInfo(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			String orderNo = paraMap.get("orderNo")+"";//订单编号
			//订单主信息
			Map<String,Object> orderData = orderDao.getOrderDetail(orderNo);

			//订单跟踪列表
			List<Map<String,Object>> trackList = orderFlowDao.getListMap(orderNo);

			//添加状态值（状态名称）
			OrderUtil.addStatusNameToList(trackList, "orderStatus", "orderStatusName");

			Map<String,Object> orderInfo = new HashMap<String, Object>();
			orderInfo.put("operatorName", "感谢您的光临！");
			orderInfo.put("createDate", orderData.get("createDate"));
			orderInfo.put("orderStatus", 0);
			orderInfo.put("orderStatusName", "");
			trackList.add(0, orderInfo);
			orderData.put("trackList", trackList);

			result = DataResponseUtil.getResultData(reqMap, 1, "获取订单跟踪列表数据成功",orderData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取订单跟踪列表数据失败，出现异常！");
		}
		return result;
	}

	public Map<String, Object> memberDeal(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			//验证
			MemberDealCheck memberDealCheck = orderCheckService.memberDealCheck(reqMap);
			if (memberDealCheck.getResultFlag()==0) {
				return DataResponseUtil.getResultData(reqMap, memberDealCheck.getResultFlag(), memberDealCheck.getResultMsg());
			}
			orderSaveService.memberDealSave(memberDealCheck);
			result = DataResponseUtil.getResultData(reqMap, 1, "订单处理成功，"+memberDealCheck.getStatusName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "订单处理失败，出现异常");
		}
		return result;
	}

	public Map<String, Object> deliveryerDeal(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		DeliveryerDealCheck deliveryerDealCheck = new DeliveryerDealCheck();
		deliveryerDealCheck.setSyn(false);
		List<Map<String,Object>> logInfoList = new ArrayList<Map<String,Object>>();
		try {

			//配送处理验证
			deliveryerDealCheck = orderCheckService.deliveryerDealCheck(reqMap,deliveryerDealCheck);
			if (deliveryerDealCheck.getResultFlag()==0) {

				logInfoList.add(LogUtil.getLogInfo(OsLogOp.orderDeliveryerDealCheck,  deliveryerDealCheck.getResultFlag()+"", deliveryerDealCheck.getResultMsg(),"订单验证失败！",deliveryerDealCheck.getResultData()));
				return DataResponseUtil.getResultData(reqMap, deliveryerDealCheck.getResultFlag(), deliveryerDealCheck.getResultMsg());
			}

			//配送保存
			orderSaveService.deliveryerDealSave(deliveryerDealCheck);
			int orderStatus = deliveryerDealCheck.getOrderStatus();
			String statusName = OrderUtil.getNameByOrderStatus(orderStatus);
			result = DataResponseUtil.getResultData(reqMap, 1, "订单处理成功，"+statusName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			result = DataResponseUtil.getResultData(reqMap, 0, "订单处理失败，出现异常！");
			logInfoList.add(LogUtil.getLogInfo(OsLogOp.orderDeliveryerDeal, "0","订单处理失败，出现异常","会员订单处理",ExceptionUtil.getExceptionDetail(e)));
		}
		return result;
	}


	public Map<String, Object> getDeliveryOrderList(Map<String, Object> reqMap,int deliveryerStatus) {
		Map<String,Object> result = new HashMap<String, Object>();

		String listName = "";
		try {


			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			Long deliveryerId = Long.valueOf(paraMap.get("deliveryerId")+"");//配送员id
			int page = Integer.parseInt(paraMap.get("page")+"");//页码
			int pagesize = Integer.parseInt(paraMap.get("pagesize")+"");//页显示最大记录数
			DeliveryUser deliveryUser = commonDao.getDeliveryer(deliveryerId);
			if (null==deliveryUser) {
				return DataResponseUtil.getResultData(reqMap, 0, "配送员不存在");
			}

			Map<String,Object> params = new HashMap<String, Object>();

			params.put("deliveryerStatus", deliveryerStatus);//配送状态（10：待抢单、11：已抢单出库中、12：商品配送中、13：配送完成、-11:客户拒收）
			params.put("deliveryerId", deliveryUser.getId());


			if (deliveryerStatus==1) {

				List<Long> unitIds = commonDao.getUnitIdsByDeliveryAccount(deliveryUser.getAccount());
				if (null==unitIds || unitIds.isEmpty()) {
					return DataResponseUtil.getResultData(reqMap, 0, "当前配送员未分配配送门店！");
				}
				params.put("unitIds", unitIds);//单位id
			}

			params.put("page", page);
			params.put("pagesize", pagesize);

			List<Map<String,Object>> orderList = orderDao.getDeliveryListMap(params);
			OrderUtil.addStatusNameToList(orderList, "deliveryerStatus", "deliveryerStatusName");

			result = DataResponseUtil.getResultData(reqMap, 1, "配送端获取"+listName+"订单列表成功！",orderList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0,  "配送端获取"+listName+"订单列表失败，出现异常！");
		}
		return result;
	}


	public Map<String, Object> getDeliveryDetail(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			String orderNo = paraMap.get("orderNo")+"";//订单编号
			if(null == orderNo || "null".equals(orderNo) || "".equals(orderNo)){
				return DataResponseUtil.getResultData(reqMap, 0, "订单编号不能为空！");
			}

			//订单主信息
			Map<String,Object> orderData = orderDao.getOrderDetail(orderNo);
			//订单对应的商品
			List<Map<String,Object>> goodsList = orderDao.getOrderGoodsList(orderNo);

			//添加状态
			OrderUtil.addStatusNameToMap(orderData, "deliveryerStatus", "deliveryerStatusName");
			orderData.put("goodsList", goodsList);

			MemberUser memberUser = commonDao.getMemberUser(Long.valueOf(orderData.get("memberId")+""));
			orderData.put("memberRrealName", memberUser.getRealName());

			result = DataResponseUtil.getResultData(reqMap, 1, "获取配送端订单详细数据成功",orderData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取配送端订单详细数据失败，出现异常！");
		}
		return result;
	}

	public Map<String, Object> clearOrder(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			clearOrder();
			result = DataResponseUtil.getResultData(reqMap, 1, "订单清理成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "订单清理失败，出现异常！");
		}
		return result;
	}

	@Transactional(rollbackFor=Exception.class)
	public void clearOrder() {

		//获取完成的的订单列表
		List<Order> orderList = orderDao.getFinishOrderList();
		if (null!=orderList && !orderList.isEmpty()) {
			for (Order order : orderList) {
				clearOrderByOrderNo(order.getOrderNo());
			}
		}
	}

	public Map<String, Object> orderComment(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			String orderNo = paraMap.get("orderNo")+"";//订单编号
			Order order = orderDao.getByOrderNo(orderNo);
			if(null == order){
				return DataResponseUtil.getResultData(reqMap, 0, "当前订单已评论！");
			}

			if (order.getIsComment()==1) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前订单已评论！");
			}

			orderDao.updateComment(orderNo);
			result = DataResponseUtil.getResultData(reqMap, 1, "订单评论成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "订单评论失败，出现异常！");
		}
		return result;
	}


	public Map<String, Object> goodsComment(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			String orderNo = paraMap.get("orderNo")+"";//订单编号
			String goodsPriceId = paraMap.get("goodsPriceId")+"";//商品定价id
			Order order = orderDao.getByOrderNo(orderNo);
			if(null == order){
				return DataResponseUtil.getResultData(reqMap, 0, "当前订单已评论！");
			}

			if (!MatcherUtil.checkNumber(goodsPriceId)) {
				return DataResponseUtil.getResultData(reqMap, 0, "商品定价id不合法！");
			}

			Map<String,Object> params = new HashMap<String, Object>();
			params.put("orderNo", orderNo);
			params.put("goodsPriceId", goodsPriceId);
			long rows = orderGoodsRtDao.getRowsByOrderNoAndGoodsPriceId(params);
			if (rows>0) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商品已评论！");
			}
			//判断订单是否评论过
			if (order.getIsComment()==0) {

				orderDao.updateComment(orderNo);
			}
			//更新评论标识
			orderGoodsRtDao.updateComment(params);
			result = DataResponseUtil.getResultData(reqMap, 1, "订单商品评论成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "订单评论失败，出现异常！");
		}
		return result;
	}



	/**
	 * 根据订单编码清理订单信息
	 * @param orderNo 订单编码
	 */
	private void clearOrderByOrderNo(String orderNo) {

		Order order = orderDao.getByOrderNo(orderNo);
		//订单流程
		List<OrderFlow> flowList = orderFlowDao.getListByOrderNo(orderNo);
		//订单商品列表
		List<OrderGoodsRt> goodsList = orderGoodsRtDao.getListByOrderNo(orderNo);
		//添加历史
		orderDao.addHis(order);
		orderFlowDao.addHisBatch(flowList);
		orderGoodsRtDao.addHisBatch(goodsList);

		//删除订单信息、订单流程、订单商品
		orderDao.deleteByOrderNo(orderNo);
		orderFlowDao.deleteByOrderNo(orderNo);
		orderGoodsRtDao.deleteByOrderNo(orderNo);
	}


	public Map<String, Object> getListRows(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			String memberId = paraMap.get(JydKeys.memberId.value())+"";//会员id
			MemberUser memberUser = commonDao.getMemberUser(Long.valueOf(memberId));//会员信息
			if (null==memberUser) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前会员不存在，获取订单列表失败！",0);
			}

			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", memberId);
			params.put("listFlag", paraMap.get("listFlag"));
			long rows = orderDao.getListRows(params);
			result = DataResponseUtil.getResultData(reqMap, 1, "获取订单列表行数成功！",rows);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取订单列表行数失败，出现异常！",0);
		}
		return result;
	}

}
