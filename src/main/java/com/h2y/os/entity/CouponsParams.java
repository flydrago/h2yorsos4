package com.h2y.os.entity;


/**
 * 优惠券相关参数
 * @author sunfj
 *
 */
public class CouponsParams {


	private Coupons coupons;
	private String account;
	private String orderNo;
	private String claimCode;
	private String shortName;
	private String remainDay;
	private boolean isCanUse;//是否可以使用优惠券
	private long claimId;
	private String startDate;
	private String endDate;




	public Coupons getCoupons() {
		return coupons;
	}
	public void setCoupons(Coupons coupons) {
		this.coupons = coupons;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public boolean isCanUse() {
		return isCanUse;
	}
	public void setCanUse(boolean isCanUse) {
		this.isCanUse = isCanUse;
	}
	public long getClaimId() {
		return claimId;
	}
	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getRemainDay() {
		return remainDay;
	}
	public void setRemainDay(String remainDay) {
		this.remainDay = remainDay;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}









}
