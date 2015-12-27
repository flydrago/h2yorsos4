package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

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
public interface IOrderFlowDaoR{

	/**
	 * get
	 * @return
	 */
	public OrderFlow get(long id);
	
	/**
	 * 根据订单编码，得到订单的跟踪列表
	 * @param orderNo 订单编码
	 * @return
	 */
	public List<Map<String,Object>> getListMap(String orderNo);
	
	/**
	 * 根据状态，得到当前订单当前状态的记录数（用于判断是否重复处理）
	 * @param map
	 * {orderNo:订单编码,
	 * orderStatus:订单状态（20：提交、0：受理、10：待抢单、11：已抢单出库中、12：商品配送中、13：配送完成、21：签收订单、-21：取消订单、-22：拒绝签收、-11:客户拒收）}
	 * @return
	 */
	public long getRowsByStatus(Map<String,Object> map);
	
	/**
	 * 根据订单编码，获取对应的订单流程列表
	 * @param orderNo 订单编码
	 * @return
	 */
	public List<OrderFlow> getListByOrderNo(String orderNo);
}