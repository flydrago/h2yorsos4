package com.h2y.os.dao.write;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.OrderCount;

/**
 * 项目名称：h2yorsos  
 * 类名称：IOrderCountDao  
 * 类描述：订单统计数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年8月6日 上午10:36:48  
 * 修改人：侯飞龙
 * 修改时间：2015年8月6日 上午10:36:48  
 * 修改备注：  
 * @version
 */
@Component
public interface IOrderCountDaoW{

	/**
	 * add
	 */
	public void add(OrderCount orderCount);
	
	/**
	 * update
	 */
	public void update(OrderCount orderCount);
}