package com.h2y.os.dao.write;

import java.util.List;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.OrderFlow;

/**
 * 项目名称：h2yorsos  
 * 类名称：IOrderFlowDao  
 * 类描述：订单流向数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:33:26  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:33:26  
 * 修改备注：  
 * @version
 */
@Component
public interface IOrderFlowDaoW{

	/**
	 * add
	 */
	public int add(OrderFlow orderFlow);
	
	/**
	 * update
	 */
	public int update(OrderFlow orderFlow);
	
	/**
	 * delete
	 */
	public void deleteById(long id);

	/**
	 * 批量添加订单流程历史
	 * @param list
	 */
	public void addHisBatch(List<OrderFlow> list);
	
	/**
	 * 根据订单编码，删除订单流程数据
	 * @param orderNo 订单编码
	 */
	public void deleteByOrderNo(String orderNo);
}