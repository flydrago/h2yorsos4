package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import com.h2y.os.entity.OrderGoodsRt;

/**
 * 项目名称：h2yorsos  
 * 类名称：IOrderGoodsRtDao  
 * 类描述：订单商品关联数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:36:10  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:36:10  
 * 修改备注：  
 * @version
 */
public interface IOrderGoodsRtDao{

	/**
	 * add
	 */
	public void add(OrderGoodsRt orderGoodsRt);
	
	/**
	 * update
	 */
	public void update(OrderGoodsRt orderGoodsRt);
	
	/**
	 * delete
	 */
	public void deleteById(long id);
	
	/**
	 * 根据商品id和订单编码，判断订单的商品是否评论过
	 * @param map
	 * {orderNo:订单编码,
	 * goodsPriceId:商品定价id}
	 * @return
	 */
	public void updateComment(Map<String,Object> map);

	/**
	 * 根据商品id和订单编码，判断订单的商品是否评论过
	 * @param map
	 * {orderNo:订单编码,
	 * goodsPriceId:商品定价id}
	 * @return
	 */
	public long getRowsByOrderNoAndGoodsPriceId(Map<String,Object> map);
	
	/**
	 * 批量添加订单商品关联
	 * @param list 订单商品关联列表
	 */
	public void addBatch(List<OrderGoodsRt> list);
	
	
	/**
	 * 根据订单编码，获取订单对应的商品列表
	 * @param orderNo 订单编码
	 * @return
	 */
	public List<OrderGoodsRt> getListByOrderNo(String orderNo);
	
	/**
	 * 批量添加订单商品历史表
	 * @param list
	 */
	public void addHisBatch(List<OrderGoodsRt> list);
	
	/**
	 * 根据订单编码，删除其对应的订单商品列表
	 * @param orderNo 订单编码
	 */
	public void deleteByOrderNo(String orderNo);
	
	
	/**
	 * 根据订单编码，获取订单对应的有效商品列表（非赠品）
	 * @param orderNo 订单编码
	 * @return
	 */
	public List<OrderGoodsRt> getValidListByOrderNo(String orderNo);
	
	/**
	 * 根据buyType，查询订单的商品
	 * @param map
	 * {orderNo:订单编码,
	 * buyType:0:购买、1：酒库}
	 * @return
	 */
	public List<Map<String,Object>> getListByBuyType(Map<String,Object> map);
	
	/**
	 * 根据buyType，查询订单的商品数量
	 * @param map
	 * {orderNo:订单编码,
	 * buyType:0:购买、1：酒库}
	 * @return
	 */
	public long getRowsByBuyType(Map<String,Object> map);
}