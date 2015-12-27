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
public class DeliveryerDealCheck extends BaseCheck{
	
	private Order order;
	private DeliveryUser deliveryUser;
	private int orderStatus;
	private String statusName;
	private boolean isQiangDan;
	private boolean isSyn;//是否同步，用于抢单同步 true时，标识已经进入方法，里面
	
	public DeliveryerDealCheck(){
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public DeliveryUser getDeliveryUser() {
		return deliveryUser;
	}

	public void setDeliveryUser(DeliveryUser deliveryUser) {
		this.deliveryUser = deliveryUser;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public boolean isQiangDan() {
		return isQiangDan;
	}

	public void setQiangDan(boolean isQiangDan) {
		this.isQiangDan = isQiangDan;
	}

	public boolean isSyn() {
		return isSyn;
	}

	public void setSyn(boolean isSyn) {
		this.isSyn = isSyn;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String toString(){
		
		return "resultFlag:"+getResultFlag()+"\t"+"resultMsg:"+getResultMsg()+"\t"+
				"order:"+order+"\t"+"deliveryUser:"+deliveryUser+"\t"+"orderStatus:"+
				orderStatus+"\t"+"isQiangDan:"+isQiangDan+"\t"+"isSyn:"+isSyn;
    }
}