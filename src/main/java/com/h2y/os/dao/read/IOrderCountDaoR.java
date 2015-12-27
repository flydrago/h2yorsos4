package com.h2y.os.dao.read;

import java.util.Map;

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
public interface IOrderCountDaoR{

	/**
	 * get
	 * @return
	 */
	public OrderCount get(long id);
	
	/**
	 * 根据日期和单位id，得到订单统计的信息
	 * @param map
	 * {date:日期时间,
	 * unitId:单位id}
	 * @return
	 */
	public OrderCount getByUnitIdAndDate(Map<String,Object> map);
}