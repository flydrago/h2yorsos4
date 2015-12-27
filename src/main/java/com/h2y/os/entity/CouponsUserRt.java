package com.h2y.os.entity;


import java.util.Date;

/**
 * CouponsUserRt Model create
 * @author hwttnet
 * version:1.2
 * time:2015-07-03
 * email:info@hwttnet.com
 */

public class CouponsUserRt{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
	public static final String key = "keyCouponsUserRt";
	private long id;
	private String claimCode;
	private long couponsId;
	private String couponsCode;
	private String account;
	private int status;
	private Date createDate;
	private Date useDate;
	private String memo;
	private String sourceCode;
	private String orderNo;
	private String str1;
	private String str2;
	private String str3;
	private Date date1;
	private Date date2;
	private int int1;
	private int int2;
	private Double double1;
	private Double double2;

	public CouponsUserRt(){
		super();
	}

	public CouponsUserRt(long id){
		super();
		this.id = id;
	}

	public CouponsUserRt(long id,String claimCode,long couponsId,String couponsCode,String account,int status,Date createDate,Date useDate,String memo,String sourceCode,String orderNo,String str1,String str2,String str3,Date date1,Date date2,int int1,int int2,Double double1,Double double2){
		super();
		this.id = id;
		this.claimCode = claimCode;
		this.couponsId = couponsId;
		this.couponsCode = couponsCode;
		this.account = account;
		this.status = status;
		this.createDate = createDate;
		this.useDate = useDate;
		this.memo = memo;
		this.sourceCode = sourceCode;
		this.orderNo = orderNo;
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.date1 = date1;
		this.date2 = date2;
		this.int1 = int1;
		this.int2 = int2;
		this.double1 = double1;
		this.double2 = double2;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getClaimCode(){
		return claimCode;
	}

	public void setClaimCode(String claimCode){
		this.claimCode = claimCode;
	}


	public long getCouponsId(){
		return couponsId;
	}

	public void setCouponsId(long couponsId){
		this.couponsId = couponsId;
	}


	public String getCouponsCode(){
		return couponsCode;
	}

	public void setCouponsCode(String couponsCode){
		this.couponsCode = couponsCode;
	}


	public String getAccount(){
		return account;
	}

	public void setAccount(String account){
		this.account = account;
	}


	public int getStatus(){
		return status;
	}

	public void setStatus(int status){
		this.status = status;
	}


	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}


	public Date getUseDate(){
		return useDate;
	}

	public void setUseDate(Date useDate){
		this.useDate = useDate;
	}


	public String getMemo(){
		return memo;
	}

	public void setMemo(String memo){
		this.memo = memo;
	}


	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}


	public String getOrderNo(){
		return orderNo;
	}

	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
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


	public String getStr3(){
		return str3;
	}

	public void setStr3(String str3){
		this.str3 = str3;
	}


	public Date getDate1(){
		return date1;
	}

	public void setDate1(Date date1){
		this.date1 = date1;
	}


	public Date getDate2(){
		return date2;
	}

	public void setDate2(Date date2){
		this.date2 = date2;
	}


	public int getInt1(){
		return int1;
	}

	public void setInt1(int int1){
		this.int1 = int1;
	}


	public int getInt2(){
		return int2;
	}

	public void setInt2(int int2){
		this.int2 = int2;
	}


	public Double getDouble1(){
		return double1;
	}

	public void setDouble1(Double double1){
		this.double1 = double1;
	}


	public Double getDouble2(){
		return double2;
	}

	public void setDouble2(Double double2){
		this.double2 = double2;
	}

	public String toString(){
		return "id:"+id+"\t"+"claimCode:"+claimCode+"\t"+"couponsId:"+couponsId+"\t"+"couponsCode:"+couponsCode+"\t"+"account:"+account+"\t"+"status:"+status+"\t"+"createDate:"+createDate+"\t"+"useDate:"+useDate+"\t"+"memo:"+memo+"\t"+"sourceCode:"+sourceCode+"\t"+"orderNo:"+orderNo+"\t"+"str1:"+str1+"\t"+"str2:"+str2+"\t"+"str3:"+str3+"\t"+"date1:"+date1+"\t"+"date2:"+date2+"\t"+"int1:"+int1+"\t"+"int2:"+int2+"\t"+"double1:"+double1+"\t"+"double2:"+double2;
	}
}