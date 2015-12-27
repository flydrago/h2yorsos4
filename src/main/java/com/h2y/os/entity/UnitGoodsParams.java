package com.h2y.os.entity;

import java.util.List;

/**
 * 项目名称：h2yorsos  
 * 类名称：OrderGoodsParams  
 * 类描述：  单位商品参数（包括商品信息、活动信息、数量、是否为赠品等）
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:29:15  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:29:15  
 * 修改备注：  
 * @version
 */
public class UnitGoodsParams {
	
    private long unitId;
    private SysUnits sysUnits;
    private List<OrderGoodsParams> orderGoodsParams;

	public UnitGoodsParams(){
		super();
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public SysUnits getSysUnits() {
		return sysUnits;
	}

	public void setSysUnits(SysUnits sysUnits) {
		this.sysUnits = sysUnits;
	}

	public List<OrderGoodsParams> getOrderGoodsParams() {
		return orderGoodsParams;
	}

	public void setOrderGoodsParams(List<OrderGoodsParams> orderGoodsParams) {
		this.orderGoodsParams = orderGoodsParams;
	}

	public String toString(){
		
    	return "unitId:"+unitId+"\t"+"sysUnits:"+sysUnits+"\t"+"orderGoodsParams:"+orderGoodsParams;
    }
}