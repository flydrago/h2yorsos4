package com.h2y.os.entity;



import java.util.Date;

/**
 * CommonActivitySpikeInfo Model create
 * @author hwttnet
 * version:1.2
 * time:2015-08-06
 * email:info@hwttnet.com
 */

public class CommonActivitySpikeInfo{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
	public static final String key = "keyCommonActivitySpikeInfo";
	private long id;
	private long memberId;
	private long activityId;
	private String memberAccount;
	private String orderNo;
	private long goodsPriceId;
	private long activityGoodsId;
	private Date createDate;
	private int status;
	private int orderStatus;
	private int goodsCount;
	private String memo;
	private int dataType;
	private Date activityStartDate;
	private Date activityEndDate;
	private String str1;
	private String str2;

	public CommonActivitySpikeInfo(){
		super();
	}

	public CommonActivitySpikeInfo(long id){
		super();
		this.id = id;
	}

	public CommonActivitySpikeInfo(long id,long memberId,long activityId,String memberAccount,String orderNo,long goodsPriceId,long activityGoodsId,Date createDate,int status,int orderStatus,int goodsCount,String memo,int dataType,Date activityStartDate,Date activityEndDate,String str1,String str2){
		super();
		this.id = id;
		this.memberId = memberId;
		this.activityId = activityId;
		this.memberAccount = memberAccount;
		this.orderNo = orderNo;
		this.goodsPriceId = goodsPriceId;
		this.activityGoodsId = activityGoodsId;
		this.createDate = createDate;
		this.status = status;
		this.orderStatus = orderStatus;
		this.goodsCount = goodsCount;
		this.memo = memo;
		this.dataType = dataType;
		this.activityStartDate = activityStartDate;
		this.activityEndDate = activityEndDate;
		this.str1 = str1;
		this.str2 = str2;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getMemberId(){
		return memberId;
	}

	public void setMemberId(long memberId){
		this.memberId = memberId;
	}


	public long getActivityId(){
		return activityId;
	}

	public void setActivityId(long activityId){
		this.activityId = activityId;
	}


	public String getMemberAccount(){
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount){
		this.memberAccount = memberAccount;
	}


	public String getOrderNo(){
		return orderNo;
	}

	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}


	public long getGoodsPriceId(){
		return goodsPriceId;
	}

	public void setGoodsPriceId(long goodsPriceId){
		this.goodsPriceId = goodsPriceId;
	}


	public long getActivityGoodsId(){
		return activityGoodsId;
	}

	public void setActivityGoodsId(long activityGoodsId){
		this.activityGoodsId = activityGoodsId;
	}


	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}


	public int getStatus(){
		return status;
	}

	public void setStatus(int status){
		this.status = status;
	}


	public int getOrderStatus(){
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus){
		this.orderStatus = orderStatus;
	}


	public int getGoodsCount(){
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount){
		this.goodsCount = goodsCount;
	}


	public String getMemo(){
		return memo;
	}

	public void setMemo(String memo){
		this.memo = memo;
	}


	public int getDataType(){
		return dataType;
	}

	public void setDataType(int dataType){
		this.dataType = dataType;
	}



	public Date getActivityStartDate() {
		return activityStartDate;
	}

	public void setActivityStartDate(Date activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public Date getActivityEndDate() {
		return activityEndDate;
	}

	public void setActivityEndDate(Date activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	public String getStr1(){
		return str1;
	}

	public void setStr1(String str1){
		this.str1 = str1;
	}


	public String getStr2(){
		return str2;
	}

	public void setStr2(String str2){
		this.str2 = str2;
	}

	public String toString(){
		return "id:"+id+"\t"+"memberId:"+memberId+"\t"+"activityId:"+activityId+"\t"+"memberAccount:"+memberAccount+"\t"+"orderNo:"+orderNo+"\t"+"goodsPriceId:"+goodsPriceId+"\t"+"activityGoodsId:"+activityGoodsId+"\t"+"createDate:"+createDate+"\t"+"status:"+status+"\t"+"orderStatus:"+orderStatus+"\t"+"goodsCount:"+goodsCount+"\t"+"memo:"+memo+"\t"+"dataType:"+dataType+"\t"+"activityStartDate:"+activityStartDate+"\t"+"activityEndDate:"+activityEndDate+"\t"+"str1:"+str1+"\t"+"str2:"+str2;
	}
}