package com.h2y.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 项目名称：h2yorsos  
 * 类名称：ExceptionUtil  
 * 类描述：异常工具类  
 * 创建人：侯飞龙  
 * 创建时间：2015年7月14日 上午11:22:12  
 * 修改人：侯飞龙
 * 修改时间：2015年7月14日 上午11:22:12  
 * 修改备注：  
 * @version
 */
public class ExceptionUtil {

	public static String getExceptionDetail(Throwable e){   
        StringWriter sw = new StringWriter();   
        PrintWriter pw = new PrintWriter(sw, true);   
        e.printStackTrace(pw);   
        pw.flush();   
        sw.flush();   
        return sw.toString();   
	} 
}