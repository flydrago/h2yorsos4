package com.h2y.os.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.dao.IOrderCountDao;
import com.h2y.os.dao.IOrderCountInfoDao;
import com.h2y.os.dao.IOrderDao;
import com.h2y.os.entity.Order;
import com.h2y.os.entity.OrderCount;
import com.h2y.os.entity.OrderCountInfo;
import com.h2y.os.util.SysBaseUtil.DeliveryStatusKey;
import com.h2y.util.Arith;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.DateUtil;
import com.h2y.util.DictUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;

/**
 * 项目名称：h2yorsos  
 * 类名称：OrderCountServiceImpl  
 * 类描述：订单统计业务接口实现类  
 * 创建人：侯飞龙  
 * 创建时间：2015年8月6日 下午2:08:30  
 * 修改人：侯飞龙
 * 修改时间：2015年8月6日 下午2:08:30  
 * 修改备注：  
 * @version
 */
@Service("orderCountService")
public class OrderCountServiceImpl implements IOrderCountService{
	
	
	private final static Logger logger = Logger.getLogger(OrderCountServiceImpl.class);

	@Autowired
	protected IOrderDao orderDao;
	
	@Autowired
	protected IOrderCountDao orderCountDao;
	
	@Autowired
	protected IOrderCountInfoDao orderCountInfoDao;
	
	
	public Map<String, Object> orderCountByDate(Map<String, Object> reqMap) {
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			
			Map<String,Object> postData = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("date", postData.get("date"));
			params.put("unitId", postData.get("unitId"));
			if (postData.get("zoneCode") instanceof String) {
				params.put("zoneCode", postData.get("zoneCode")+"%");
			}
			
			Map<String,Object> resultData = doCount(params);
			String resultMsg = "成功统计"+resultData.get("dealCountRows")+"条订单，一次最多统计"+resultData.get("maxCountRows")+"条订单！";
			resultMap =  DataResponseUtil.getResultData(reqMap, 1, resultMsg,resultData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap =  DataResponseUtil.getResultData(reqMap, 0, "按指定日期汇总订单，服务器端出现异常！");
		}
		
		return resultMap;
	}
	
	public Map<String, Object> orderCountByDate(Map<String,Object> reqMap,Date date) {
		
		Map<String,Object> resultMap = new HashMap<String, Object>();

		try {
			
			Map<String,Object> postData = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("date", date);
			if (postData instanceof Map) {
				params.put("unitId", postData.get("unitId"));
				if (postData.get("zoneCode") instanceof String) {
					params.put("zoneCode", postData.get("zoneCode")+"%");
				}
			}
			
			Map<String,Object> resultData = doCount(params);
			String resultMsg = "成功统计"+resultData.get("dealCountRows")+"条订单，一次最多统计"+resultData.get("maxCountRows")+"条订单！";
			resultMap =  DataResponseUtil.getResultData(reqMap, 1, resultMsg,resultData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap =  DataResponseUtil.getResultData(reqMap, 0, "按指定日期"+date+"汇总订单，服务器端出现异常！");
		}
		
		return resultMap;
	}
	
	
	public Map<String, Object> orderCountByDatePeriod(Map<String, Object> reqMap) {
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		try {
			
			Map<String,Object> postData = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("startDate", postData.get("startDate"));
			params.put("endDate", postData.get("endDate"));
			if (postData instanceof Map) {
				params.put("unitId", postData.get("unitId"));
				if (postData.get("zoneCode") instanceof String) {
					params.put("zoneCode", postData.get("zoneCode")+"%");
				}
			}
			
			Map<String,Object> resultData = doCount(params);
			String resultMsg = "成功统计"+resultData.get("dealCountRows")+"条订单，一次最多统计"+resultData.get("maxCountRows")+"条订单！";
			resultMap =  DataResponseUtil.getResultData(reqMap, 1, resultMsg,resultData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap =  DataResponseUtil.getResultData(reqMap, 0, "按指定日期段汇总订单，服务器端出现异常！");
		}
		return resultMap;
	}
	
	
	/**
	 * 执行订单汇总
	 * @param params
	 * {startDate:开始时间（可为null）
	 * endDate:截止时间（可为null）,
	 * date:制定日期（可为null）}
	 * @return
	 * {dealCountRows:处理统计订单数量,
	 * maxCountRows:最大统计订单数量,
	 * oneCountRows:单次获取统计订单数量}
	 */
	private Map<String,Object> doCount(Map<String,Object> params){
		
		Map<String,Object> resultData = new HashMap<String, Object>();
		
		int dealCount = 0;
		
		String maxCountRows_str = DictUtil.getDictDetailValue(1, "orderCountParams", "maxCountRows");
		String oneCountRows_str = DictUtil.getDictDetailValue(1, "orderCountParams", "oneCountRows");
		
		int maxCountRows = MatcherUtil.checkNumber(maxCountRows_str)?Integer.parseInt(maxCountRows_str):2000;
		int oneCountRows = MatcherUtil.checkNumber(oneCountRows_str)?Integer.parseInt(oneCountRows_str):100;
		
		params.put("page", 1);
		params.put("pagesize", oneCountRows);
		
		//做最大的汇总控制，一次最大汇总2000个订单，如需再汇总需要再次调用
		if (maxCountRows>2000) {
			maxCountRows = 2000;
		}
		
		while (true) {
			
			List<Order> orderList = orderDao.getCountListByDate(params);
			if (null!=orderList && !orderList.isEmpty()) {
				
				//执行统计
				orderCount(orderList);
				
				dealCount+=orderList.size();
				//待统计订单行数，小于一次统计最大数量   跳出循环
				if (orderList.size()<oneCountRows) {
					break;
				}
			}else {//没有待统计订单时，跳出循环
				break;
			}
			
			//达到订单处理上限时，跳出循环
			if (dealCount>=maxCountRows) {
				break;
			}
			
		}
		
		resultData.put("dealCountRows", dealCount);
		resultData.put("maxCountRows", maxCountRows);
		resultData.put("oneCountRows", oneCountRows);
		
		return resultData;
	}
	
	
	
	/**
	 * 订单统计
	 * @param orderList 订单列表
	 */
	@Transactional(rollbackFor=Exception.class)
	private void orderCount(List<Order> orderList){
		
		List<String> orderNoList = new ArrayList<String>();
		for (Order order : orderList) {
			
			updateOrderCount(order);
			orderNoList.add(order.getOrderNo());
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("orderNos", orderNoList);
		orderDao.updateIsHasCountByOrderNos(map);
	}
	
	/**
	 * 更新订单统计主表
	 * @param order 订单信息
	 */
	private void updateOrderCount(Order order){
		
		//更新主表
		Map<String,Object> countParams = new HashMap<String, Object>();
		countParams.put("date", order.getCreateDate());
		countParams.put("unitId", order.getUnitId());
		OrderCount orderCount = orderCountDao.getByUnitIdAndDate(countParams);
		
		if (null==orderCount) {
			
			orderCount = new OrderCount();
			orderCount.setCoinAmount(doubleFilterNull(order.getCoinAmount()));
			orderCount.setCouponsAmount(doubleFilterNull(order.getCouponsAmount()));
			orderCount.setCreateDate(DateUtil.getSystemTime());
			orderCount.setGoodsAmount(doubleFilterNull(order.getGoodsAmount()));
			orderCount.setGoodsTransportAmount(doubleFilterNull(order.getGoodsTransportAmount()));
			orderCount.setOrderCount(1);
			orderCount.setOrderDay(order.getCreateDate());
			orderCount.setRealAmount(doubleFilterNull(order.getRealAmount()));
			orderCount.setUnitId(order.getUnitId());
			orderCount.setUnitName(order.getUnitName());
			orderCount.setUnitShortName(order.getUnitShortName());
			orderCount.setUnitType(order.getUnitType());
			orderCount.setUpdateDate(DateUtil.getSystemTime());
			orderCount.setZoneCode(order.getZoneCode());
			orderCountDao.add(orderCount);
		}else {
			
			orderCount.setCoinAmount(Arith.add(order.getCoinAmount(), orderCount.getCoinAmount()));
			orderCount.setCouponsAmount(Arith.add(order.getCouponsAmount(), orderCount.getCouponsAmount()));
			orderCount.setGoodsAmount(Arith.add(order.getGoodsAmount(), orderCount.getGoodsAmount()));
			orderCount.setGoodsTransportAmount(Arith.add(order.getGoodsTransportAmount(), orderCount.getGoodsTransportAmount()));
			orderCount.setOrderCount(1+orderCount.getOrderCount());
			orderCount.setRealAmount(Arith.add(order.getRealAmount(), orderCount.getRealAmount()));
			orderCount.setUpdateDate(DateUtil.getSystemTime());
			orderCountDao.update(orderCount);
		}
		
		int infoType = 0;//汇总方式 0：有效订单、1：在线支付、2：线下支付、3：电话外卖、4：拒收订单
		if (order.getDeliveryerStatus() == DeliveryStatusKey.peiSongEnd.status) {//有效订单
			infoType = 0;
		}else if (order.getDeliveryerStatus() == DeliveryStatusKey.juShou.status) {//拒收订单
			infoType = 4;
		}
		
		//更新有效订单和拒收订单汇总信息
		updateOrderCountInfo(order, orderCount, infoType);
		
		if (order.getPayType() == 0) {//线下支付
			infoType = 2;
		}else if (order.getPayType() == 1) {
			infoType = 1;
		}
		
		//更新线下支付和线上支付汇总信息
		updateOrderCountInfo(order, orderCount, infoType);
	}
	
	
	/**
	 * 更新订单统计信息
	 * @param order 订单信息
	 * @param orderCount 订单统计主表
	 * @param infoType 汇总方式
	 */
	private void updateOrderCountInfo(Order order,OrderCount orderCount,int infoType){
		
		//更新统计信息
		Map<String,Object> infoParams = new HashMap<String, Object>();
		infoParams.put("countId", orderCount.getId());
		infoParams.put("infoType", infoType);
		OrderCountInfo orderCountInfo = orderCountInfoDao.getByCountIdAndInfoType(infoParams);
		if (null==orderCountInfo) {
			
			orderCountInfo = new OrderCountInfo();
			orderCountInfo.setCountId(orderCount.getId());
			orderCountInfo.setCoinAmount(doubleFilterNull(order.getCoinAmount()));
			orderCountInfo.setCouponsAmount(doubleFilterNull(order.getCouponsAmount()));
			orderCountInfo.setCreateDate(DateUtil.getSystemTime());
			orderCountInfo.setGoodsAmount(doubleFilterNull(order.getGoodsAmount()));
			orderCountInfo.setGoodsTransportAmount(doubleFilterNull(order.getGoodsTransportAmount()));
			orderCountInfo.setInfoType(infoType);
			orderCountInfo.setOrderCount(1);
			orderCountInfo.setRealAmount(doubleFilterNull(order.getRealAmount()));
			orderCountInfo.setUpdateDate(DateUtil.getSystemTime());
			orderCountInfoDao.add(orderCountInfo);
		}else {
			
			orderCountInfo.setCoinAmount(Arith.add(order.getCoinAmount(), orderCountInfo.getCoinAmount()));
			orderCountInfo.setCouponsAmount(Arith.add(order.getCouponsAmount(), orderCountInfo.getCouponsAmount()));
			orderCountInfo.setGoodsAmount(Arith.add(order.getGoodsAmount(), orderCountInfo.getGoodsAmount()));
			orderCountInfo.setGoodsTransportAmount(Arith.add(order.getGoodsTransportAmount(), orderCountInfo.getGoodsTransportAmount()));
			orderCountInfo.setOrderCount(orderCountInfo.getOrderCount()+1);
			orderCountInfo.setRealAmount(Arith.add(order.getRealAmount(), orderCountInfo.getRealAmount()));
			orderCountInfo.setUpdateDate(DateUtil.getSystemTime());
			orderCountInfoDao.update(orderCountInfo);
		}
	}
	
	
	private Double doubleFilterNull(Double d){
		
		return null==d?0d:d;
	}
}