package com.h2y.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;


/**
 * 项目名称：h2yorsos  
 * 类名称：OrderUtil  
 * 类描述：  订单工具类
 * 创建人：侯飞龙  
 * 创建时间：2015年5月19日 上午10:22:37  
 * 修改人：侯飞龙
 * 修改时间：2015年5月19日 上午10:22:37  
 * 修改备注：  
 * @version
 */
public class LogUtil {
	
	private static final Logger logger = Logger.getLogger(LogUtil.class);
	
	/**
	 * 添加日志详细
	 * @param reqMap 访问参数
	 * @param opFlag 操作标识
	 * @param opDesc 操作描述
	 * @param resultFlag 结果标识
	 * @param resultMsg 结果信息
	 * @param memo 备注
	 * @param datas 业务数据
	 * @return
	 */
   	public static Map<String,Object> getLogInfo(OsLogOp osLogOp,String resultFlag,String resultMsg,String memo,Object ... datas){
   		
   		Map<String,Object> postData = new HashMap<String, Object>();
   		postData.put("opFlag", osLogOp.opFlag);
   		postData.put("opDesc", osLogOp.opDesc);
   		postData.put("resultFlag", resultFlag);
   		postData.put("resultMsg", resultMsg);
   		postData.put("createDate", DateUtil.getSystemTime());
   		postData.put("memo", memo);
   		if (null!=datas && datas.length>0) {
   			
   			int i = 1;
   			for (Object data : datas) {
   				if (i>12) {//最多12个参数
					break;
				}
   				postData.put("data"+i, data);
   				i++;
			}
		}
   		return postData;
   	}
   	
	/**
	 * 添加日志详细
	 * @param reqMap 访问参数
	 * @param opFlag 操作标识
	 * @param opDesc 操作描述
	 * @param resultFlag 结果标识
	 * @param resultMsg 结果信息
	 * @param memo 备注
	 * @param datas 业务数据
	 * @return
	 */
   	public static Map<String,Object> addLogInfo(Map<String,Object> reqMap,OsLogOp osLogOp,String resultFlag,String resultMsg,String memo,Object ... datas){
   		
   		Map<String,Object> result = new HashMap<String, Object>();
   		try {
			
   			Map<String,Object> postData = getLogInfo(osLogOp, resultFlag, resultMsg, memo, datas);
   			result = DataRequestUtil.getRequestData("log/addOsLogInfo.htm", postData,reqMap.get(SInvokeKeys.postMark.value())+"");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
   		return result;
   	}
   	
   	
	/**
	 * 添加日志详细
	 * @param reqMap 访问参数
	 * @param dataList 日志信息列表
	 * @return
	 */
   	public static Map<String,Object> addBatchLogInfo(Map<String,Object> reqMap,List<Map<String,Object>> dataList){
   		
   		Map<String,Object> result = new HashMap<String, Object>();
   		try {
   			
   			if (null==dataList || dataList.isEmpty()) {
   				result.put(SInvokeKeys.resultFlag.value(), 0);
   				result.put(SInvokeKeys.resultFlag.value(), "日志列表为空！");
				return result;
			}
			
   			Map<String,Object> postData = new HashMap<String, Object>();
   			postData.put("dataList", dataList);
   			result = DataRequestUtil.getRequestData("log/addBatchOsLogInfo.htm", postData,reqMap.get(SInvokeKeys.postMark.value())+"");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
   		return result;
   	}
   	
   	
   	/**
	 * 类描述：日志操作标识
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum OsLogOp{
		
		/**
		 * 订单验证
		 */
		orderCheck("orderCheck","订单验证"),
		
		/**
		 * 订单提交
		 */
		orderSumit("orderSumit","订单提交"),
		
		/**
		 * 订单结算
		 */
		orderSettlement("orderSettlement","订单结算"),
		
		
		/**
		 * 订单会员处理验证
		 */
		orderMemberDealCheck("orderMemberDealCheck","订单会员处理验证"),
		
		/**
		 * 订单会员处理
		 */
		orderMemberDeal("orderMemberDeal","订单会员处理"),
		
		/**
		 * 订单配送端处理验证
		 */
		orderDeliveryerDealCheck("orderDeliveryerDealCheck","订单配送端处理验证"),
		
		/**
		 * 订单配送端处理
		 */
		orderDeliveryerDeal("orderDeliveryerDeal","订单配送端处理"),
		
		/**
		 * 消息推送
		 */
		pushMsg("pushMsg","消息推送"),
		
		
		/**
		 * 提交订单酒库同步
		 */
		submitOrderSpiritSyn("submitOrderSpiritSyn","提交订单酒库同步"),
		
		
		/**
		 * 提交订单酒库同步
		 */
		cancelOrderSpiritSyn("cancelOrderSpiritSyn","取消订单酒库同步"),
		
		/**
		 * 积分更新
		 */
		gradeUpdate("gradeUpdate","积分更新"),
		
		/**
		 * 订单支付信息
		 */
		orderPayInfo("orderPayInfo","订单支付信息");
		
		public final String opFlag;
		public final String opDesc;
		private OsLogOp(String opFlag,String opDesc){
			this.opFlag = opFlag;
			this.opDesc = opDesc;
		}
	}
   	
   
}
