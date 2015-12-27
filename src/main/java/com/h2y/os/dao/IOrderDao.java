package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

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
public interface IOrderDao{

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
	 * get
	 * @return
	 */
	public Order get(long id);

	/**
	 * 根据订单编码，得到订单信息
	 * @param orderNo 订单编码
	 * @return
	 */
	public Order getByOrderNo(String orderNo);

	/**
	 * 得到拥有所有商品的库存的门店id集合
	 * @param map
	 * {goodsInfoList:[{goodsPriceId:商品定价id,goodsCount:商品数量}],
	 * listSize:商品信息列表的总数}
	 * @return
	 */
	public List<Long> getHasGoodsShopList(Map<String,Object> map);

	/**
	 * 得到订单消耗的达人币
	 * @param orderNo 订单唯一标识
	 * @return
	 */
	public Map<String,Object> getVipCoinSumByOrderNo(String orderNo);


	/**
	 * 根据id集合，得到对应的购物车信息
	 * @param map
	 * {memberId:会员id,
	 * shoppingCartList:[{id:购车id2},{id:购车id2}]}
	 * @return
	 */
	public List<Map<String,Object>> getShoppingCartList(Map<String,Object> map);


	/**
	 * 根据id集合，更新购物车状态
	 * @param map
	 * {ids:购物车id,
	 * status:-1：已删除、0：正常、1：已提交订单}
	 */
	public void updateShoppingCartStatusByIds(Map<String,Object> map);


	/**
	 * 得到订单列表
	 * @param map
	 * {memberId:订单id,
	 * page:页码,
	 * pagesize:页显示最大记录数,
	 * listFlag:列表标识（dfkList:待付款,dshList:待收货） null时不做判断}
	 * @return
	 */
	public List<Map<String,Object>> getListMap(Map<String,Object> map);
	
	/**
	 * 得到订单列表行数
	 * @param map
	 * {memberId:订单id,
	 * listFlag:列表标识（dfkList:待付款,dshList:待收货） null时不做判断}
	 * @return
	 */
	public long getListRows(Map<String,Object> map);

	/**
	 * 得到订单详细
	 * @param orderNo 订单编号
	 * @return
	 */
	public Map<String,Object> getOrderDetail(String orderNo);

	/**
	 * 得到订单商品列表
	 * @param orderNo 订单编号
	 * @return
	 */
	public List<Map<String,Object>> getOrderGoodsList(String orderNo);


	/**
	 * 得到配送端，订单列表（待抢单、待送货、已完成、已退货）
	 * @param map
	 * {deliveryerStatus:订单状态（1：待抢单、10：已抢单出库中、11：商品配送中、12：配送完成、-11:客户拒收）,
	 * unitIds:配送员负责的门店的单位id列表（可选，deliveryerStatus为1时必须传）,
	 * deliveryerId:配送员id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public List<Map<String,Object>> getDeliveryListMap(Map<String,Object> map);


	/**
	 * 根据订单配送状态，得到订单列表
	 * @param deliveryerStatus 配送状态
	 * @return
	 */
	public List<Order> getOrderListByDeliveryerStatus(int deliveryerStatus);

	/**
	 * 得到完成的订单列表（配送完成或客户拒收，并且用户确认）
	 * @return
	 */
	public List<Order> getFinishOrderList();

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
	 * 得到购物车的商品列表
	 * @param map
	 * {memberId:会员id,
	 * shoppingCartList:[{id:购车id2},{id:购车id2}]}
	 * @return
	 */
	public List<Map<String,Object>> getShopGoodsList(Map<String,Object> map);


	/**
	 * 获取当前用户订单数
	 * @param account
	 * @return
	 */
	public long getCountOrder(String account);
	
	
	/**
	 * 得到未处理的订单列表
	 * @return 
	 * {deliveryerStatus:配送状态,
	 * minMinutes:最小分钟区间,
	 * maxMinutes:最大分钟区间}
	 */
	public List<Order> getUnDealOrderList(Map<String,Object> map);

	
	/**
	 * 根据日期，统计当前日期的订单
	 * @param map
	 * {date:统计日期（null时，不做过滤条件）,
	 * page:页码,
	 * pagesize:页显示最大记录数,
	 * startDate:开始日期（null时，不做过滤条件）,
	 * endDate:截止日期（null时，不做过滤条件）,
	 * unitId:单位id（null时，不做过滤条件）,
	 * zoneCode:区域编码（null时，不做过滤条件）}
	 * @return
	 */
	public List<Order> getCountListByDate(Map<String,Object> map);
	
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
	
	
	/**
	 * 根据订单提交唯一标识，得到订单信息列表
	 * @param orderUnique 订单批量提交批次唯一标识
	 * @return
	 */
	public List<Order> getByOrderUnique(String orderUnique);
}