package com.h2y.os.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.h2y.object.BaseObject;

/**
 * 项目名称：h2yorsos  
 * 类名称：Order  
 * 类描述：  订单参数模型
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:29:15  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:29:15  
 * 修改备注：  
 * @version
 */
public class OrderParams extends BaseObject{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
    public static final String key = "keyOrder";
    private Double goodsAmount;//商品总数量
    private Double goodsTransportAmount;//商品运费
    private Double giveBean;//促销活动，赠送的达人豆
    private Double giveCoin;//促销活动，赠送的达人币
    private Double goodsGiveCoin;//商品赠送达人币数量
    private Double useVipCoin;//使用的达人币数量
    private Double useVipCoinTop;//使用达人币上限
    private Double goodsRealAmount;//商品应付金额
    private Double coinAmount;//商品应付金额
    private Date createDate;
    private int goodsCount;//订单的商品的总数量
    private int giftCount;//订单赠品数量
    private int isUseVipCoin;//是否使用大人币 0 否、1 使用
    private long unitId;//单位id
    private int unitType;//单位类型
    private String orderNo;//订单编码
    private List<OrderGoodsRt> orderGoodsRts;
    private List<Long> shopingCartIds;
    private int resultFlag;//结果标识 0：失败、1：成功
    private String resultMsg;//结果提示信息
    private List<Map<String,Object>> useGradeInfos;//消耗的积分
    private List<Map<String,Object>> giveGradeInfos;//赠送的积分
    private Order order;
    
	public OrderParams(){
		super();
	}



	public Double getGoodsAmount() {
		return goodsAmount;
	}



	public void setGoodsAmount(Double goodsAmount) {
		this.goodsAmount = goodsAmount;
	}



	public Double getGoodsTransportAmount() {
		return goodsTransportAmount;
	}



	public void setGoodsTransportAmount(Double goodsTransportAmount) {
		this.goodsTransportAmount = goodsTransportAmount;
	}



	public Double getGiveBean() {
		return giveBean;
	}



	public void setGiveBean(Double giveBean) {
		this.giveBean = giveBean;
	}



	public Double getGiveCoin() {
		return giveCoin;
	}



	public void setGiveCoin(Double giveCoin) {
		this.giveCoin = giveCoin;
	}



	public Double getGoodsGiveCoin() {
		return goodsGiveCoin;
	}



	public void setGoodsGiveCoin(Double goodsGiveCoin) {
		this.goodsGiveCoin = goodsGiveCoin;
	}



	public Double getUseVipCoin() {
		return useVipCoin;
	}



	public void setUseVipCoin(Double useVipCoin) {
		this.useVipCoin = useVipCoin;
	}



	public Double getUseVipCoinTop() {
		return useVipCoinTop;
	}



	public void setUseVipCoinTop(Double useVipCoinTop) {
		this.useVipCoinTop = useVipCoinTop;
	}



	public Double getGoodsRealAmount() {
		return goodsRealAmount;
	}



	public void setGoodsRealAmount(Double goodsRealAmount) {
		this.goodsRealAmount = goodsRealAmount;
	}



	public Double getCoinAmount() {
		return coinAmount;
	}



	public void setCoinAmount(Double coinAmount) {
		this.coinAmount = coinAmount;
	}



	public int getGoodsCount() {
		return goodsCount;
	}



	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}



	public int getGiftCount() {
		return giftCount;
	}



	public void setGiftCount(int giftCount) {
		this.giftCount = giftCount;
	}



	public int getIsUseVipCoin() {
		return isUseVipCoin;
	}



	public void setIsUseVipCoin(int isUseVipCoin) {
		this.isUseVipCoin = isUseVipCoin;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createData) {
		this.createDate = createData;
	}



	public long getUnitId() {
		return unitId;
	}



	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public int getUnitType() {
		return unitType;
	}



	public void setUnitType(int unitType) {
		this.unitType = unitType;
	}





	public List<OrderGoodsRt> getOrderGoodsRts() {
		return orderGoodsRts;
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



	public void setOrderGoodsRts(List<OrderGoodsRt> orderGoodsRts) {
		this.orderGoodsRts = orderGoodsRts;
	}



	public List<Long> getShopingCartIds() {
		return shopingCartIds;
	}



	public void setShopingCartIds(List<Long> shopingCartIds) {
		this.shopingCartIds = shopingCartIds;
	}



	public String getOrderNo() {
		return orderNo;
	}



	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}



	public List<Map<String, Object>> getUseGradeInfos() {
		return useGradeInfos;
	}



	public void setUseGradeInfos(List<Map<String, Object>> useGradeInfos) {
		this.useGradeInfos = useGradeInfos;
	}



	public List<Map<String, Object>> getGiveGradeInfos() {
		return giveGradeInfos;
	}



	public void setGiveGradeInfos(List<Map<String, Object>> giveGradeInfos) {
		this.giveGradeInfos = giveGradeInfos;
	}



	public String toString(){
		
    	return "goodsAmount:"+goodsAmount+"\t"
    			+"goodsTransportAmount:"+goodsTransportAmount+"\t"+
    			"giveBean:"+giveBean+"\t"+"giveCoin:"+giveCoin+"\t"+"goodsGiveCoin:"+goodsGiveCoin+"\t"+
    			"useVipCoin:"+useVipCoin+"\t"+"useVipCoinTop:"+useVipCoinTop+"\t"+
    			"goodsRealAmount:"+goodsRealAmount+"\t"+"coinAmount:"+coinAmount+"\t"+"goodsCount:"+goodsCount+"\t"+
    			"giftCount:"+giftCount+"\t"+"isUseVipCoin:"+isUseVipCoin+"\t"+
    			"unitId:"+unitId+"\t"+"unitType:"+unitType+"\t"+
    			"orderNo:"+orderNo+"\t"+
    			"orderGoodsRts:"+orderGoodsRts+"\t"+"shopingCartIds:"+shopingCartIds+"\t"+
    			"resultFlag:"+resultFlag+"\t"+"resultMsg:"+resultMsg+"\t"+
    			"useGradeInfos:"+useGradeInfos+"\t"+"giveGradeInfos:"+giveGradeInfos+"\t"+"order:"+order+"\t";
    }
}