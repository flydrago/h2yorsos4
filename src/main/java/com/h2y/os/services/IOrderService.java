package com.h2y.os.services;

import java.util.Map;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IReceiveAddressService  
 * 类描述：订单业务操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:24:10  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:24:10  
 * 修改备注：  
 * @version
 */
public interface IOrderService{
	
	
	/**
	 * 提交订单
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * receiverAddressId:收货地址,
	 * receiverAddress:收货地址信息,
	 * receiverName:收货人姓名,
	 * receiverMobile:收货人手机号码,
	 * isUseVipCoin:是否使用达人币（0：不使用、1：使用）,
	 * vipCoin:使用达人币额度,
	 * shopingCartList:{{id:购物车id1},{id:购物车id2}]
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> submit(Map<String,Object> reqMap);
	
	
	/**
	 * 获取订单参数
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * shopingCartList:{{id:购物车id1},{id:购物车id2}]
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单参数数据}
	 */
	public Map<String,Object> orderParams(Map<String,Object> reqMap);
	
	/**
	 * 获取订单列表
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * page:页码,
	 * pagesize:页显示最大记录数,
	 * listFlag:列表标识（dfkList:待付款,dshList:待收货,pszList:配送中,ywcList:已完成） null时不做判断}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表数据}
	 */
	public Map<String,Object> getList(Map<String,Object> reqMap);
	
	
	/**
	 * 获取订单详细
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单详细数据}
	 */
	public Map<String,Object> getDetail(Map<String,Object> reqMap);
	
	/**
	 * 得到订单的跟踪信息
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单跟踪信息}
	 */
	public Map<String,Object> getTrackInfo(Map<String,Object> reqMap);
	
	
	/**
	 * 会员处理订单
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号,
	 * orderStatus: 收货状态（21：签收订单、-21：取消订单、-22:拒绝签收）,
	 * memberId:会员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> memberDeal(Map<String,Object> reqMap);
	
	
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
	public Map<String,Object> deliveryerDeal(Map<String,Object> reqMap);
	
	
	/**
	 * 获取配送端订单列表（待抢单列表、待发货列表、已完成列表、已退货列表）
	 * @param reqMap
	 * postData={
	 * deliveryerId:配送员id}
	 * @param deliveryerStatus 配送状态（1：待抢单、10：已抢单出库中、11：商品配送中、12：配送完成、-11:客户拒收）
	 * @return
	 */
	public Map<String, Object> getDeliveryOrderList(Map<String, Object> reqMap,int deliveryerStatus);
	
	/**
	 * 获取配送端订单详细
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:配送端订单详细}
	 */
	public Map<String,Object> getDeliveryDetail(Map<String, Object> reqMap);
	
	/**
	 * 订单评论
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> orderComment(Map<String,Object> reqMap);
	
	
	/**
	 * 订单商品评论
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号,
	 * goodsPriceId:商品定价id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> goodsComment(Map<String,Object> reqMap);
	
	/**
	 * 获取订单列表行数
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * listFlag:列表标识（dfkList:待付款,dshList:待收货） null时不做判断}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表行数}
	 */
	public Map<String,Object> getListRows(Map<String,Object> reqMap);
	
}
