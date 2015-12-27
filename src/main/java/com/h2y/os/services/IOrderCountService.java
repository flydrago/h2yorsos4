package com.h2y.os.services;

import java.util.Date;
import java.util.Map;


/**
 * 项目名称：h2yorsos  
 * 类名称：IOrderCountService  
 * 类描述：订单统计业务操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年8月6日 下午2:04:27  
 * 修改人：侯飞龙
 * 修改时间：2015年8月6日 下午2:04:27  
 * 修改备注：  
 * @version
 */
public interface IOrderCountService{
	
	
	/**
	 * 根据日期，统计当前日期的订单
	 * @param reqMap
	 * paraData={
	 * date:制定日期,
	 * unitId:单位id（可为null）,
	 * zoneCode:区域编码（可为null）
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,
	 * resultMsg:提示消息,
	 * resultData:
	 * {dealCountRows:处理统计订单数量,
	 * maxCountRows:最大统计订单数量,
	 * oneCountRows:单次获取统计订单数量}
	 * }
	 */
	public Map<String,Object> orderCountByDate(Map<String,Object> reqMap);
	
	
	/**
	 * 根据日期，统计当前日期的订单
	 * @param reqMap
	 * paraData={unitId:单位id（可为null）,
	 * zoneCode:区域编码（可为null）}
	 * @param date
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,
	 * resultMsg:提示消息,
	 * resultData:
	 * {dealCountRows:处理统计订单数量,
	 * maxCountRows:最大统计订单数量,
	 * oneCountRows:单次获取统计订单数量}
	 * }
	 */
	public Map<String,Object> orderCountByDate(Map<String,Object> reqMap,Date date);
	
	
	/**
	 * 根据日期段，统计订单
	 * @param reqMap
	 * paraData={
	 * startDate:开始时间,
	 * endDate:截止时间,
	 * unitId:单位id（可为null）,
	 * zoneCode:区域编码（可为null）
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,
	 * resultMsg:提示消息,
	 * resultData:
	 * {dealCountRows:处理统计订单数量,
	 * maxCountRows:最大统计订单数量,
	 * oneCountRows:单次获取统计订单数量}
	 * }
	 */
	public Map<String,Object> orderCountByDatePeriod(Map<String,Object> reqMap);
}
