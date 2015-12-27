package com.h2y.os.services;

import java.util.Map;

import com.h2y.os.entity.DeliveryerDealCheck;
import com.h2y.os.entity.MemberDealCheck;
import com.h2y.os.entity.OrderSubmitInfo;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IReceiveAddressService  
 * 类描述：订单业务验证操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:24:10  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:24:10  
 * 修改备注：  
 * @version
 */
public interface IOrderCheckService{
	
	
	/**
	 * 订单验证（提交、初始化）
	 * @param reqMap 请求参数
	 * @param checkType 验证类型（ 0:获取参数，1：订单提交）
	 * @return
	 * 订单验证返回对象
	 */
	public OrderSubmitInfo orderCheck(Map<String,Object> reqMap,int checkType);

	
	/**
	 * 配送员处理订单
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号,
	 * orderStatus: 配送状态（10：已抢单出库中、11：商品配送中、12：配送完成、-11:客户拒收）,
	 * deliveryerId:配送员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public DeliveryerDealCheck deliveryerDealCheck(Map<String,Object> reqMap,DeliveryerDealCheck deliveryerDealCheck);
	
	/**
	 * 
	 * @param reqMap
	 * @return
	 */
	public MemberDealCheck memberDealCheck(Map<String,Object> reqMap);
}
