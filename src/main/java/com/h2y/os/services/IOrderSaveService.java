package com.h2y.os.services;

import org.springframework.transaction.annotation.Transactional;

import com.h2y.os.entity.DeliveryerDealCheck;
import com.h2y.os.entity.MemberDealCheck;
import com.h2y.os.entity.OrderParams;
import com.h2y.os.entity.OrderSubmitInfo;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IReceiveAddressService  
 * 类描述：订单业务保存操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:24:10  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:24:10  
 * 修改备注：  
 * @version
 */
public interface IOrderSaveService{
	
	/**
	 * 保存订单
	 * @return
	 */
	public OrderParams saveOrder(OrderSubmitInfo orderSubmitInfo);
	
	/**
	 * 获取单位订单参数
	 * @return
	 */
	public OrderParams getUnitOrderParams(OrderSubmitInfo orderSubmitInfo);
	
	
	/**
	 * 配送员订单处理保存
	 * @param deliveryerDealCheck
	 */
	@Transactional(rollbackFor={Exception.class,RuntimeException.class})
	public void deliveryerDealSave(DeliveryerDealCheck deliveryerDealCheck);
	
	/**
	 * 订单会员处理保存操作
	 * @param memberDealCheck
	 */
	@Transactional(rollbackFor=Exception.class)
	public void memberDealSave(MemberDealCheck memberDealCheck);
}
