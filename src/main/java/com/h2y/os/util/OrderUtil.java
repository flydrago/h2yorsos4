package com.h2y.os.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.h2y.os.entity.OrderFlow;
import com.h2y.os.util.SysBaseUtil.DeliveryStatusKey;
import com.h2y.os.util.SysBaseUtil.MemberStatusKey;
import com.h2y.os.util.SysBaseUtil.PayType;
import com.h2y.util.DateUtil;
import com.h2y.util.MatcherUtil;


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
public class OrderUtil {
	
	public final static int orderPushMaxNum = 10;
	
	
	/**
	 * 生成订单编号
	 * @return
	 */
	public static String getOrderNo(){
		String orderNo="";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Random random = new Random();
		String randomCode = "";
		orderNo=df.format(new Date());
		for ( int i = 0; i < 6; i++ ){
			randomCode += Integer.toString(random.nextInt(9));
		}
		orderNo+=randomCode;
		return orderNo;
	}
	
	
	
	/**
	 * 生成退款批次
	 * @return
	 */
	public static String getRefundBatchNo(){
		String orderNo="";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Random random = new Random();
		String randomCode = "";
		orderNo=df.format(new Date());
		for ( int i = 0; i < 7; i++ ){
			randomCode += Integer.toString(random.nextInt(9));
		}
		orderNo+=randomCode;
		return orderNo;
	}
	
	
	/**
	 * 根据订单状态，得到对应的状态值
	 * @param orderStatus 订单状态（20：提交、0：受理、1：待抢单、10：商品出库中、11：商品配送中、12：配送完成、21：签收订单、-21：取消订单、-22：拒绝签收、-11:客户拒收）
	 * @return
	 */
	public static String getNameByOrderStatus(int orderStatus){

		String Name = "";
		
		for(DeliveryStatusKey e : DeliveryStatusKey.values()){
			if (orderStatus == e.status) {
				return e.name;
			}
	    }
		
		for(MemberStatusKey e : MemberStatusKey.values()){
			if (orderStatus == e.status) {
				return e.name;
			}
	    }
		return Name;
	}
	
	
	/**
	 * 得到会员枚举状态
	 * @return
	 */
	public static MemberStatusKey getMemberStatusByStatus(int orderStatus){

		for(MemberStatusKey e : MemberStatusKey.values()){
			if (orderStatus == e.status) {
				return e;
			}
	    }
		return null;
	}
	
	
	/**
	 * 根据订单状态，得到对应的状态值
	 * @return
	 */
	public static DeliveryStatusKey getDeliveryStatusByStatus(int orderStatus){
		
		for(DeliveryStatusKey e : DeliveryStatusKey.values()){
			if (orderStatus == e.status) {
				return e;
			}
	    }
		return null;
	}
	
	
	/**
	 * 添加状态名称到集合中
	 * @param dataList 数据集合
	 * @param statusKey 状态值的key
	 * @param statusNameKey 状态名称存储的键
	 */
	public static void addStatusNameToList(List<Map<String,Object>> dataList,String statusKey,String statusNameKey){
		
		for (Map<String, Object> map : dataList) {
			addStatusNameToMap(map, statusKey, statusNameKey);
		}
	}
	
	/**
	 * 添加状态名称到集合中
	 * @param data 订单数据
	 * @param statusKey 状态值的key
	 * @param statusNameKey 状态名称存储的键
	 */
	public static void addStatusNameToMap(Map<String,Object> data,String statusKey,String statusNameKey){
		
		if (MatcherUtil.checkNumber(data.get(statusKey)+"")) {
			data.put(statusNameKey, OrderUtil.getNameByOrderStatus(Integer.parseInt(data.get(statusKey)+"")));
		}else {
			data.put(statusNameKey,"");
		}
	}
	
	
	/**
	 * 处理订单跟踪
	 * @param orderNo 订单编码
	 * @param orderId 订单id
	 * @param operatorId 操作人员id
	 * @param operatorName 操作人员名称
	 * @param operatorType（0：系统人员、1：配送人员、2：会员）
	 * @param orderStatus（20：提交、0：受理、10：待抢单、11：已抢单出库中、12：商品配送中、13：配送完成、21：签收订单、-21：取消订单、-22：拒绝签收、-11:客户拒收）
	 * @param memo
	 */
	public static OrderFlow getOrderFlow(String orderNo,long orderId,
			String operatorId,String operatorName,int operatorType,int orderStatus,String memo) {

		//添加订单流向表
		OrderFlow orderFlow = new OrderFlow();
		orderFlow.setCreateDate(DateUtil.getSystemTime());
		orderFlow.setOperatorId(operatorId);
		orderFlow.setOperatorName(operatorName);
		orderFlow.setOperatorType(operatorType);//操作人员类型（0：系统人员、1：配送人员、2：会员）
		orderFlow.setOrderId(orderId);
		orderFlow.setOrderNo(orderNo);
		orderFlow.setOrderStatus(orderStatus);//订单状态（20：提交、0：受理、10：待抢单、11：已抢单出库中、12：商品配送中、13：配送完成、21：签收订单、-21：取消订单、-22：拒绝签收、-11:客户拒收）
		orderFlow.setMemo(memo);
		return orderFlow;
	}
	
	
	/**
	 * 根据标识得到支付类型
	 * @return
	 */
	public static PayType getPayTypeByFlag(int flag){
		
		if (flag==PayType.payOnDelivery.flag) {
			return PayType.payOnDelivery;
		}else if (flag==PayType.alipay.flag) {
			return PayType.alipay;
		}
		return null;
	}
	
	
	/**
	 * 根据标识得到支付类型
	 * @return
	 */
	public static PayType getPayTypeByValue(String value){
		
		if (value.equals(PayType.alipay.value)) {
			return PayType.alipay;
		}else if (value.equals(PayType.weixin.value)) {
			return PayType.weixin;
		}
		return null;
	}
	
	
	/**
	 * 订单状态，更新标识
	 */
	public enum UpdateFlag{

		/**
		 * 支付
		 */
		pay("pay"),

		/**
		 * 退款
		 */
		refund("refund");

		public String value;
		private UpdateFlag(String value){
			this.value=value;
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(getOrderNo().length());
	}
}
