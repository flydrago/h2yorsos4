package com.h2y.os.entity;



/**
 * 项目名称：h2yorsos  
 * 类名称：Order  
 * 类描述：  订单验证参数
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:29:15  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:29:15  
 * 修改备注：  
 * @version
 */
public class MemberDealCheck extends BaseCheck{
	
	private Order order;
	private MemberUser memberUser;
	private int orderStatus;
	private String statusName;
	
	public MemberDealCheck(){
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MemberUser getMemberUser() {
		return memberUser;
	}

	public void setMemberUser(MemberUser memberUser) {
		this.memberUser = memberUser;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String toString(){
		
		return "resultFlag:"+getResultFlag()+"\t"+"resultMsg:"+getResultMsg()+"\t"+
				"order:"+order+"\t"+"memberUser:"+memberUser+"\t"+"orderStatus:"+
				orderStatus+"\t"+"statusName:"+statusName;
    }
}