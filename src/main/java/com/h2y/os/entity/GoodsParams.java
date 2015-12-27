package com.h2y.os.entity;


/**
 * 类描述：商品定价模型 作者：侯飞龙 时间：2015年1月28日上午11:57:03 邮件：1162040314@qq.com
 */
public class GoodsParams{

	private long goodsPriceId;
	private int goodsCount;
	private int buyType;
	private String goodsType;
	private String markInfoIds;
	private Double singlePrice;
	private int isActivity;
	private long sellUnit;

	public GoodsParams() {
		super();
	}

	public GoodsParams(long goodsPriceId, int goodsCount, int buyType,
			String goodsType, String markInfoIds, Double singlePrice,
			int isActivity,long sellUnit) {
		super();
		this.goodsPriceId = goodsPriceId;
		this.goodsCount = goodsCount;
		this.buyType = buyType;
		this.goodsType = goodsType;
		this.markInfoIds = markInfoIds;
		this.singlePrice = singlePrice;
		this.isActivity = isActivity;
		this.sellUnit = sellUnit;
	}

	public long getGoodsPriceId() {
		return goodsPriceId;
	}

	public void setGoodsPriceId(long goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
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

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getMarkInfoIds() {
		return markInfoIds;
	}

	public void setMarkInfoIds(String markInfoIds) {
		this.markInfoIds = markInfoIds;
	}

	public Double getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(Double singlePrice) {
		this.singlePrice = singlePrice;
	}

	public int getIsActivity() {
		return isActivity;
	}

	public void setIsActivity(int isActivity) {
		this.isActivity = isActivity;
	}

	public long getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(long sellUnit) {
		this.sellUnit = sellUnit;
	}

	@Override
	public String toString() {
		return "GoodsParams [goodsPriceId=" + goodsPriceId + ", goodsCount="
				+ goodsCount + ", buyType=" + buyType + ", goodsType="
				+ goodsType + ", markInfoIds=" + markInfoIds + 
				", singlePrice="+ singlePrice + 
				", isActivity=" + isActivity + 
				", sellUnit="+ sellUnit + 
				"]";
	}

}