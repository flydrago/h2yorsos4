package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import com.h2y.os.entity.CommonActivityGoodsRt;
import com.h2y.os.entity.DataGoodsInfo;
import com.h2y.os.entity.GoodsPrice;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IGoodsPriceDao  
 * 类描述：商品定价数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月1日 上午9:03:55  
 * 修改人：侯飞龙
 * 修改时间：2015年4月1日 上午9:03:55  
 * 修改备注：  
 * @version
 */
public interface IGoodsDao{

	
	/**
	 * 得到商品定价信息
	 * @return
	 */
	public GoodsPrice get(long id);
	
	/**
	 * 根据id，得到活动商品关联
	 * @param id 活动商品关联id
	 * @return
	 */
	public CommonActivityGoodsRt getCommonActivityGoodsRt(long id);
	
	/**
	 * 根据定价id和版本号，得到商品对应的赠品或关联商品列表数据
	 * @param map 
	 * {goodsPriceId:商品定价id,
	 * goodsPriceVersion:商品定价版本号,
	 * dataType:关联类型（1赠品 2关联商品）}
	 * @return
	 */
	public List<DataGoodsInfo> getDataGoodsInfoList(Map<String,Object> map);
	
	/**
	 * 更新商品的购买量
	 * @param map
	 * {id:商品定价id,
	 * count:购买数量}
	 */
	public void updateGoodsSellRate(Map<String,Object> map);
	
	
	/**
	 * 更新商品的库存
	 * @param map
	 * {id:商品定价id,
	 * count:购买数量}
	 */
	public void updateGoodsInventory(Map<String,Object> map);
}