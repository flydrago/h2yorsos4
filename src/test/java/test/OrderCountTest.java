package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.util.SysBaseUtil.DeliveryStatusKey;
import com.h2y.util.Arith;
import com.h2y.util.DateUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;

public class OrderCountTest {

	
	public static void main(String[] args) {
		
//		yesterday();
		
//		today();

		
//		for (int i = 0; i < 10; i++) {
			
//			datePeriod();
//		}
		
		
//		day();
		
//		System.out.println(MatcherUtil.checkNumber("0"));
		
		
		int payType = !MatcherUtil.checkNumber("0")?0:1;
		
		System.out.println(payType);
	}
	
	
	/**
	 * 统计昨天订单
	 * @param reqMap
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void yesterday(){
		
		String url = "http://10.10.10.182:80/h2ycmbs2/cmbs/ordercount/yesterday.htm";
		
		Map<String,Object> params = new HashMap<String,Object>();
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	
	/**
	 * 统计昨天订单
	 * @param reqMap
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void today(){
		
		String url = "http://10.10.10.182:80/h2ycmbs2/cmbs/ordercount/today.htm";
		
		Map<String,Object> params = new HashMap<String,Object>();
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	/**
	 * 根据日期段，汇总订单
	 * @param reqMap
	 * paraData={
	 * startDate:开始时间,
	 * endDate:截止时间
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单参数数据}
	 */
	public static void datePeriod(){
		
		String url = "http://10.10.10.182:80/h2ycmbs2/cmbs/ordercount/datePeriod.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("startDate", DateUtil.toDate("2015-06-30",DateUtil.YYYY_MM_DD));
		postData.put("endDate", DateUtil.toDate("2015-08-11",DateUtil.YYYY_MM_DD));
//		postData.put("unitId", 14);
//		postData.put("zoneCode", 41);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 根据日期，汇总订单
	 * @param reqMap
	 * paraData={
	 * date:日期时间
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单参数数据}
	 */
	public static void day(){
		
		String url = "http://10.10.10.182:80/h2ycmbs2/cmbs/ordercount/day.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("date", DateUtil.toDate("2015-01-18",DateUtil.YYYY_MM_DD));
		postData.put("unitId", 14);
//		postData.put("unitId", 14);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
}
