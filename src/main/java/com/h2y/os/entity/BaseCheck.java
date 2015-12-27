package com.h2y.os.entity;



/**
 * 项目名称：h2yorsos  
 * 类名称：BaseCheck  
 * 类描述：  基础验证模型
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:29:15  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:29:15  
 * 修改备注：  
 * @version
 */
public class BaseCheck{
	
	private int resultFlag;//结果标识（0：失败、1：成功）
	private String resultMsg; //结果信息
	private String resultData;
	
	public BaseCheck(){
		super();
	}

	public int getResultFlag() {
		return resultFlag;
	}



	public void setResultFlag(int resultFlag) {
		this.resultFlag = resultFlag;
	}



	public String getResultMsg() {
		return resultMsg;
	}



	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getResultData() {
		return resultData;
	}

	public void setResultData(String resultData) {
		this.resultData = resultData;
	}

	public String toString(){
		return "resultFlag:"+resultFlag+"\t"+"resultMsg:"+resultMsg+"\t"+"resultData:"+resultData;
    }
}