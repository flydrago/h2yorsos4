package com.h2y.os.entity;

import java.util.List;
public class OrderSubmitInfo {
	private int resultFlag;//结果标识（0：失败、1：成功）
	private String resultMsg; //结果信息
	private Object resultData;
	//商品信息
	private List<OrderGoodsParams> goodsParamsList;
	//收货地址
	private ReceiveAddress receiveAddress;
	//会员
	private MemberUser memberUser;
	//单位信息
	private SysUnits sysUnits;
	//订单号
	private String orderNo;
	
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
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	public List<OrderGoodsParams> getGoodsParamsList() {
		return goodsParamsList;
	}
	public void setGoodsParamsList(List<OrderGoodsParams> goodsParamsList) {
		this.goodsParamsList = goodsParamsList;
	}
	public ReceiveAddress getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(ReceiveAddress receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public MemberUser getMemberUser() {
		return memberUser;
	}
	public void setMemberUser(MemberUser memberUser) {
		this.memberUser = memberUser;
	}
	public SysUnits getSysUnits() {
		return sysUnits;
	}
	public void setSysUnits(SysUnits sysUnits) {
		this.sysUnits = sysUnits;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
	
}
