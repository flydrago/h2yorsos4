package com.h2y.os.entity;

import java.util.List;
import java.util.Map;

import com.h2y.os.util.SysBaseUtil.PayType;


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
public class OrderCheckParams{

	private int resultFlag;//结果标识（0：失败、1：成功）
	private String resultMsg; //结果信息
	private String resultData;//结果数据（主要存储失败关键信息）
	private String os;
	private String osv;
	private String appv;
	private String orderUnique;
	private Map<Long,UnitGoodsParams> uMap;
	private ReceiveAddress receiveAddress;
	private MemberUser memberUser;
	private int isUseVipCoin;//是否使用达人币
	private Double useVipCoin;//会员计划使用达人币数量
	private Double hasVipCoin;//会员拥有的达人币数量
	private Double useVipCoinTop;//商品使用达人币的上限
	private List<Map<String,Object>> shoppingCartList;//购物车列表[{id:购车id2},{id:购车id2}]
	private String zoneCode;
	private boolean isUseSpirit;//是否使用酒库功能

	private List<Map<String,Object>> couponsParamsList;
	private CouponsParams couponsParams;
	private int isHasSpike;//是否有秒杀商品，秒杀商品不能使用优惠券
	private int payType;//支付方式

	//要使用的优惠券信息----订单保存时用到
	//优惠券列表-----订单初始化时用到

	public OrderCheckParams(){
		super();
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



	public String getResultData() {
		return resultData;
	}

	public void setResultData(String resultData) {
		this.resultData = resultData;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsv() {
		return osv;
	}

	public void setOsv(String osv) {
		this.osv = osv;
	}

	public String getAppv() {
		return appv;
	}

	public void setAppv(String appv) {
		this.appv = appv;
	}

	public String getOrderUnique() {
		return orderUnique;
	}

	public void setOrderUnique(String orderUnique) {
		this.orderUnique = orderUnique;
	}

	public Map<Long, UnitGoodsParams> getuMap() {
		return uMap;
	}



	public void setuMap(Map<Long, UnitGoodsParams> uMap) {
		this.uMap = uMap;
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

	public int getIsUseVipCoin() {
		return isUseVipCoin;
	}

	public void setIsUseVipCoin(int isUseVipCoin) {
		this.isUseVipCoin = isUseVipCoin;
	}

	public Double getUseVipCoin() {
		return useVipCoin;
	}

	public void setUseVipCoin(Double useVipCoin) {
		this.useVipCoin = useVipCoin;
	}

	public Double getHasVipCoin() {
		return hasVipCoin;
	}

	public void setHasVipCoin(Double hasVipCoin) {
		this.hasVipCoin = hasVipCoin;
	}

	public Double getUseVipCoinTop() {
		return useVipCoinTop;
	}

	public void setUseVipCoinTop(Double useVipCoinTop) {
		this.useVipCoinTop = useVipCoinTop;
	}

	public boolean isUseSpirit() {
		return isUseSpirit;
	}

	public void setUseSpirit(boolean isUseSpirit) {
		this.isUseSpirit = isUseSpirit;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public List<Map<String, Object>> getShoppingCartList() {
		return shoppingCartList;
	}

	public void setShoppingCartList(List<Map<String, Object>> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}





	public List<Map<String, Object>> getCouponsParamsList() {
		return couponsParamsList;
	}

	public void setCouponsParamsList(List<Map<String, Object>> couponsParamsList) {
		this.couponsParamsList = couponsParamsList;
	}

	public CouponsParams getCouponsParams() {
		return couponsParams;
	}

	public void setCouponsParams(CouponsParams couponsParams) {
		this.couponsParams = couponsParams;
	}



	public int getIsHasSpike() {
		return isHasSpike;
	}

	public void setIsHasSpike(int isHasSpike) {
		this.isHasSpike = isHasSpike;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	@Override
	public String toString() {
		return "OrderCheckParams [resultFlag=" + resultFlag + ", resultMsg="
				+ resultMsg + ", resultData=" + resultData + ", os=" + os
				+ ", osv=" + osv + ", appv=" + appv + ", orderUnique="
				+ orderUnique + ", uMap=" + uMap + ", receiveAddress="
				+ receiveAddress + ", memberUser=" + memberUser
				+ ", isUseVipCoin=" + isUseVipCoin + ", useVipCoin="
				+ useVipCoin + ", hasVipCoin=" + hasVipCoin
				+ ", useVipCoinTop=" + useVipCoinTop + ", shoppingCartList="
				+ shoppingCartList + ", zoneCode=" + zoneCode
				+ ", isUseSpirit=" + isUseSpirit + ", couponsParamsList="
				+ couponsParamsList + ", couponsParams=" + couponsParams
				+ ", isHasSpike=" + isHasSpike + ", payType=" + payType + "]";
	}


}