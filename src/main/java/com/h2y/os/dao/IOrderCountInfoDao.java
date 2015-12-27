package com.h2y.os.dao;

import java.util.Map;

import com.h2y.os.entity.OrderCountInfo;

/**
 * 项目名称：h2yorsos  
 * 类名称：IOrderCountInfoDao  
 * 类描述：订单统计信息数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年8月6日 上午10:39:21  
 * 修改人：侯飞龙
 * 修改时间：2015年8月6日 上午10:39:21  
 * 修改备注：  
 * @version
 */
public interface IOrderCountInfoDao{

	/**
	 * add
	 */
	public void add(OrderCountInfo orderCountInfo);
	
	/**
	 * update
	 */
	public void update(OrderCountInfo orderCountInfo);
	
	/**
	 * get
	 * @return
	 */
	public OrderCountInfo get(long id);
	
	/**
	 * 根据统计id和统计信息类型，得到统计信息
	 * @param map
	 * {countId:统计id,
	 * infoType:信息类型（汇总方式 0：有效订单、1：在线支付、2：线下支付、3：电话外卖、4：拒收订单）}
	 * @return
	 */
	public OrderCountInfo getByCountIdAndInfoType(Map<String,Object> map);
}