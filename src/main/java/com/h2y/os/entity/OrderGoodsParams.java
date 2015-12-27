package com.h2y.os.entity;


/**
 * 项目名称：h2yorsos  
 * 类名称：OrderGoodsParams  
 * 类描述：  订单商品参数（包括商品信息、活动信息、数量、是否为赠品等）
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:29:15  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:29:15  
 * 修改备注：  
 * @version
 */
public class OrderGoodsParams {
	
    private GoodsPrice goodsPrice;//商品信息
    private Long shopingCartId;//购物车id
    private int goodsCount;//商品应付金额
    private int buyType;//（0：购买，1：酒库）
    private int isGift;//是否为赠品（0：否，1：是）
    private Long giftMainGoodsId;//赠品对应的主商品id 不是赠品时，为 0
    private CommonActivityGoodsRt commonActivityGoodsRt;//单位id

	public OrderGoodsParams(){
		super();
	}


	public GoodsPrice getGoodsPrice() {
		return goodsPrice;
	}


	public void setGoodsPrice(GoodsPrice goodsPrice) {
		this.goodsPrice = goodsPrice;
	}


	public Long getShopingCartId() {
		return shopingCartId;
	}


	public void setShopingCartId(Long shopingCartId) {
		this.shopingCartId = shopingCartId;
	}


	public int getGoodsCount() {
		return goodsCount;
	}


	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}


	public int getBuyType() {
		return buyType;
	}


	public void setBuyType(int buyType) {
		this.buyType = buyType;
	}


	public int getIsGift() {
		return isGift;
	}


	public void setIsGift(int isGift) {
		this.isGift = isGift;
	}


	public Long getGiftMainGoodsId() {
		return giftMainGoodsId;
	}


	public void setGiftMainGoodsId(Long giftMainGoodsId) {
		this.giftMainGoodsId = giftMainGoodsId;
	}


	public CommonActivityGoodsRt getCommonActivityGoodsRt() {
		return commonActivityGoodsRt;
	}


	public void setCommonActivityGoodsRt(CommonActivityGoodsRt commonActivityGoodsRt) {
		this.commonActivityGoodsRt = commonActivityGoodsRt;
	}


	public String toString(){
		
    	return "goodsPrice:"+goodsPrice+"\t"+"shopingCartId:"+shopingCartId+"\t"+
    			"goodsCount:"+goodsCount+"\t"+"buyType:"+buyType+"\t"+"isGift:"+isGift+"\t"+
    			"giftMainGoodsId:"+giftMainGoodsId+"\t"+"commonActivityGoodsRt:"+commonActivityGoodsRt+"\t";
    }
}