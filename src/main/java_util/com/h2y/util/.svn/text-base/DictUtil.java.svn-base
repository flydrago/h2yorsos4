package com.h2y.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;


/**
 * 项目名称：h2yorsos  
 * 类名称：OrderUtil  
 * 类描述：  字典工具类
 * 创建人：侯飞龙  
 * 创建时间：2015年5月19日 上午10:22:37  
 * 修改人：侯飞龙
 * 修改时间：2015年5月19日 上午10:22:37  
 * 修改备注：  
 * @version
 */
public class DictUtil {
	
	private final static Logger logger = Logger.getLogger(DictUtil.class);
	
	/**
	 * 得到字典主表数据
	 * @param unitId 单位id
	 * @param mainCode 字典主表编码
	 * @param code 字典详细编码
	 * @return
	 */
	public static String getDictMainValue(long unitId,String mainCode){
		
		String value = null;
		Map<String,Object> dictParams = new HashMap<String, Object>();
		dictParams.put("unitId", unitId);
		dictParams.put("mainCode", mainCode);
		Map<String,Object> result = DataRequestUtil.getRequestData("dict/getMain.htm", dictParams);
		if ("1".equals(result.get(SInvokeKeys.resultFlag.value())+"")) {
			@SuppressWarnings("unchecked")
			Map<String,Object> resultData = (Map<String, Object>) result.get(SInvokeKeys.resultData.value());
			if (null!=resultData && null!=resultData.get("dictValue")) {
				value = resultData.get("dictValue")+"";
			}
		}else {
			logger.warn("获取字典参数失败，unitId:"+unitId+",mainCode:"+mainCode+" 返回信息："+result.get(SInvokeKeys.resultMsg.value()));
		}
		return value;
	}
	
	
	/**
	 * 得到字典详细数据
	 * @param unitId 单位id
	 * @param mainCode 字典主表编码
	 * @param code 字典详细编码
	 * @return
	 */
	public static String getDictDetailValue(long unitId,String mainCode,String code){
		
		String value = null;
		
		Map<String,Object> dictParams = new HashMap<String, Object>();
		dictParams.put("unitId", unitId);
		dictParams.put("mainCode", mainCode);
		dictParams.put("code", code);
		Map<String,Object> result = DataRequestUtil.getRequestData("dict/getDetail.htm", dictParams);
		if ("1".equals(result.get(SInvokeKeys.resultFlag.value())+"")) {
			
			@SuppressWarnings("unchecked")
			Map<String,Object> resultData = (Map<String, Object>) result.get(SInvokeKeys.resultData.value());
			if (null!=resultData && null!=resultData.get("value")) {
				value = resultData.get("value")+"";
			}
		}else {
			logger.warn("获取字典参数失败，unitId:"+unitId+",mainCode:"+mainCode+",code:"+code+" 返回信息："+result.get(SInvokeKeys.resultMsg.value()));
		}
		return value;
	}
	
	
	/**
	 * 得到字典详细列表数据
	 * @param unitId 单位id
	 * @param mainCode 字典主表编码
	 * @param code 字典详细编码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String,Object>> getDictDetailList(long unitId,String mainCode){
		
		List<Map<String,Object>> detailList = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> dictParams = new HashMap<String, Object>();
		dictParams.put("unitId", unitId);
		dictParams.put("mainCode", mainCode);
		Map<String,Object> result = DataRequestUtil.getRequestData("dict/getDetailList.htm", dictParams);
		if ("1".equals(result.get(SInvokeKeys.resultFlag.value())+"")) {
			detailList = (List<Map<String,Object>>) result.get(SInvokeKeys.resultData.value());
		}else {
			logger.warn("获取字典参数失败，unitId:"+unitId+",mainCode:"+mainCode+" 返回信息："+result.get(SInvokeKeys.resultMsg.value()));
		}
		return detailList;
	}
	
}
