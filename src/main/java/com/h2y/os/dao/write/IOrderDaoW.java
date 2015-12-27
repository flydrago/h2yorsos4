package com.h2y.os.dao.write;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.Order;

/**
 * 项目名称：h2yorsos  
 * 类名称：IOrderDao  
 * 类描述：订单数据库操作  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:30:02  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:30:02  
 * 修改备注：  
 * @version
 */
@Component
public interface IOrderDaoW{

	/**
	 * add
	 */
	public int add(Order order);

	/**
	 * update
	 */
	public int update(Order order);

	/**
	 * 更新订单评论标识
	 * @param orderNo 订单编号
	 */
	public void updateComment(String orderNo);

	/**
	 * delete
	 */
	public void deleteById(long id);

	/**
	 * 根据id集合，更新购物车状态
	 * @param map
	 * {ids:购物车id,
	 * status:-1：已删除、0：正常、1：已提交订单}
	 */
	public void updateShoppingCartStatusByIds(Map<String,Object> map);


	/**
	 * 添加订单历史
	 * @param order
	 */
	public void addHis(Order order);

	/**
	 * 根据订单编码，删除订单信息
	 * @param orderNo 订单编码
	 */
	public void deleteByOrderNo(String orderNo);

	/**
	 * 根据订单编码列表，更新是否已统计标识
	 * @param map
	 * {orderNos:订单编码列表}
	 */
	public void updateIsHasCountByOrderNos(Map<String,Object> map);
	
	/**
	 * 根据交易号和退款批次号，更新退款信息
	 * @param map
	 * {tradeNo:交易号,
	 * refundAmount:退款金额,
	 * refundBatchNo:退款批次号}
	 */
	public void updateRefundInfoByTradeNo(Map<String,Object> map);
	
	
	/**
	 * 根据订单编码，更新交易信息
	 * @param map
	 * {orderNo:订单编码,
	 * tradeNo:交易号  货到付款时为null,
	 * tradeData1:扩展信息1 可为null,
	 * tradeData2:扩展信息2 可为null,
	 * tradeData3:扩展信息3 可为null}
	 */
	public void updateTradeInfoByOrderNo(Map<String,Object> map);
	
	/**
	 * 根据订单编码，更新退款批次号
	 * @param map 
	 * {orderNo:订单编码,
	 * refundBatchNo:退款批次号}
	 */
	public void updateRefundBatchNoByOrderNo(Map<String,Object> map);
}