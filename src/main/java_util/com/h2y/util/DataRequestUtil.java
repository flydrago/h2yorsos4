package com.h2y.util;

import java.util.HashMap;
import java.util.Map;

import com.h2y.entity.BaseResult;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.util.SysBaseUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：DataResponseUtil  
 * 类描述：  服务数据响应数据工具类
 * 创建人：侯飞龙  
 * 创建时间：2015年4月14日 下午2:40:14  
 * 修改人：侯飞龙
 * 修改时间：2015年4月14日 下午2:40:14  
 * 修改备注：  
 * @version
 */
public class DataRequestUtil{
	
	/**
	 * 得到返回的结果数据
	 * @param url 访问url
	 * @param postData 访问的参数
	 * @return
	 */
	public static Map<String,Object> getRequestData(String url,Map<String,Object> postData) {
		
		return getRequestData(url, postData, null);
    } 
	
	/**
	 * 得到通用返回的结果数据
	 * @param url 访问url
	 * @param postData 访问的参数
	 * @return
	 */
	public static BaseResult getCommonRequestData(String url,Map<String,Object> postData) {
		
		Map<String,Object> resultMap = getRequestData(url, postData, null);
		BaseResult baseResult = JSONUtil.getObject(resultMap, BaseResult.class);
		return baseResult;
    } 
	
	/**
	 * 得到返回的结果数据
	 * @param url 访问url
	 * @param postData 访问的参数
	 * @param postMark 访问标识
	 * @return
	 */
	public static Map<String,Object> getRequestData(String url,Map<String,Object> postData,String postMark) {
		
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put(SInvokeKeys.slock.value(),"1");
		resultMap.put(SInvokeKeys.skey.value(),"2");
		resultMap.put(SInvokeKeys.sid.value(),"3");
		resultMap.put(SInvokeKeys.os.value(),"h2yorsos");
		resultMap.put(SInvokeKeys.osv.value(),"1.0");
		resultMap.put(SInvokeKeys.appv.value(),"1.0");
		resultMap.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		resultMap.put(SInvokeKeys.postMark.value(), postMark);
		String resultMsg = HttpTookit.doPost(SysBaseUtil.CMBS_URL+url, resultMap);
		return JSONUtil.getMap(resultMsg);
    } 
}
