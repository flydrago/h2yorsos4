package com.h2y.os.dao.write;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

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
@Component
public interface IOrderGoodsRtDaoW{

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
	 * 批量添加订单商品关联
	 * @param list 订单商品关联列表
	 */
	public void addBatch(List<OrderGoodsRt> list);
	
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
}