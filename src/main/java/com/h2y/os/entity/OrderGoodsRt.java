package com.h2y.os.entity;

import java.util.Date;

import com.h2y.object.BaseObject;


/**
 * 项目名称：h2yorsos  
 * 类名称：OrderGoodsRt  
 * 类描述：订单商品关联模型  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:35:17  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:35:17  
 * 修改备注：  
 * @version
 */
public class OrderGoodsRt extends BaseObject{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
	public static final String key = "keyOrderGoodsRt";
	private long id;
	private long orderId;
	private String orderNo;
	private String orderUnique;
	private long storehouseId;
	private String storehouseName;
	private String goodsNickName;
	private String goodsNumber;
	private String goodsShortNumber;
	private int goodsCount;
	private Double goodsAmount;
	private Double singlePrice;
	private Date createDate;
	private long goodsPriceId;
	private int goodsPriceVersion;
	private int isGift;
	private long dataId;
	private int buyType;
	private String s3stcode;
	private String s3gdscode;
	private int isComment;
	private int isActivity;
	private long activityGoodsId;

	public OrderGoodsRt(){
		super();
	}

	public OrderGoodsRt(long id){
		super();
		this.id = id;
	}

	public OrderGoodsRt(long id,long orderId,String orderNo,String orderUnique,long storehouseId,String storehouseName,String goodsNickName,String goodsNumber,String goodsShortNumber,int goodsCount,Double goodsAmount,Double singlePrice,Date createDate,long goodsPriceId,int goodsPriceVersion,int isGift,long dataId,int buyType,String s3stcode,String s3gdscode,int isComment,int isActivity,long activityGoodsId){
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.orderUnique = orderUnique;
		this.storehouseId = storehouseId;
		this.storehouseName = storehouseName;
		this.goodsNickName = goodsNickName;
		this.goodsNumber = goodsNumber;
		this.goodsShortNumber = goodsShortNumber;
		this.goodsCount = goodsCount;
		this.goodsAmount = goodsAmount;
		this.singlePrice = singlePrice;
		this.createDate = createDate;
		this.goodsPriceId = goodsPriceId;
		this.goodsPriceVersion = goodsPriceVersion;
		this.isGift = isGift;
		this.dataId = dataId;
		this.buyType = buyType;
		this.s3stcode = s3stcode;
		this.s3gdscode = s3gdscode;
		this.isComment = isComment;
		this.isActivity = isActivity;
		this.activityGoodsId = activityGoodsId;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getOrderId(){
		return orderId;
	}

	public void setOrderId(long orderId){
		this.orderId = orderId;
	}


	public String getOrderNo(){
		return orderNo;
	}

	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}


	public String getOrderUnique(){
		return orderUnique;
	}

	public void setOrderUnique(String orderUnique){
		this.orderUnique = orderUnique;
	}


	public long getStorehouseId(){
		return storehouseId;
	}

	public void setStorehouseId(long storehouseId){
		this.storehouseId = storehouseId;
	}


	public String getStorehouseName(){
		return storehouseName;
	}

	public void setStorehouseName(String storehouseName){
		this.storehouseName = storehouseName;
	}


	public String getGoodsNickName(){
		return goodsNickName;
	}

	public void setGoodsNickName(String goodsNickName){
		this.goodsNickName = goodsNickName;
	}


	public String getGoodsNumber(){
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber){
		this.goodsNumber = goodsNumber;
	}


	public String getGoodsShortNumber(){
		return goodsShortNumber;
	}

	public void setGoodsShortNumber(String goodsShortNumber){
		this.goodsShortNumber = goodsShortNumber;
	}


	public int getGoodsCount(){
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount){
		this.goodsCount = goodsCount;
	}


	public Double getGoodsAmount(){
		return goodsAmount;
	}

	public void setGoodsAmount(Double goodsAmount){
		this.goodsAmount = goodsAmount;
	}


	public Double getSinglePrice(){
		return singlePrice;
	}

	public void setSinglePrice(Double singlePrice){
		this.singlePrice = singlePrice;
	}


	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}


	public long getGoodsPriceId(){
		return goodsPriceId;
	}

	public void setGoodsPriceId(long goodsPriceId){
		this.goodsPriceId = goodsPriceId;
	}


	public int getGoodsPriceVersion(){
		return goodsPriceVersion;
	}

	public void setGoodsPriceVersion(int goodsPriceVersion){
		this.goodsPriceVersion = goodsPriceVersion;
	}


	public int getIsGift(){
		return isGift;
	}

	public void setIsGift(int isGift){
		this.isGift = isGift;
	}


	public long getDataId(){
		return dataId;
	}

	public void setDataId(long dataId){
		this.dataId = dataId;
	}


	public int getBuyType(){
		return buyType;
	}

	public void setBuyType(int buyType){
		this.buyType = buyType;
	}


	public String getS3stcode(){
		return s3stcode;
	}

	public void setS3stcode(String s3stcode){
		this.s3stcode = s3stcode;
	}


	public String getS3gdscode(){
		return s3gdscode;
	}

	public void setS3gdscode(String s3gdscode){
		this.s3gdscode = s3gdscode;
	}

	public int getIsComment() {
		return isComment;
	}

	public void setIsComment(int isComment) {
		this.isComment = isComment;
	}

	public int getIsActivity() {
		return isActivity;
	}

	public void setIsActivity(int isActivity) {
		this.isActivity = isActivity;
	}


	public long getActivityGoodsId() {
		return activityGoodsId;
	}

	public void setActivityGoodsId(long activityGoodsId) {
		this.activityGoodsId = activityGoodsId;
	}

	public String toString(){
		return "id:"+id+"\t"+"orderId:"+orderId+"\t"+"orderNo:"+orderNo+"\t"+"orderUnique:"+orderUnique+"\t"+"storehouseId:"+storehouseId+"\t"+"storehouseName:"+storehouseName+"\t"+"goodsNickName:"+goodsNickName+"\t"+"goodsNumber:"+goodsNumber+"\t"+"goodsShortNumber:"+goodsShortNumber+"\t"+"goodsCount:"+goodsCount+"\t"+"goodsAmount:"+goodsAmount+"\t"+"singlePrice:"+singlePrice+"\t"+"createDate:"+createDate+"\t"+"goodsPriceId:"+goodsPriceId+"\t"+"goodsPriceVersion:"+goodsPriceVersion+"\t"+"isGift:"+isGift+"\t"+"dataId:"+dataId+"\t"+"buyType:"+buyType+"\t"+"s3stcode:"+s3stcode+"\t"+"s3gdscode:"+s3gdscode+"\t"+"isComment:"+isComment+"\t"+"isActivity:"+isActivity+"\t"+"activityGoodsId:"+activityGoodsId;
	}
}