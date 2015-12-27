package com.h2y.os.dao.write;

import java.util.Map;

import org.springframework.stereotype.Component;

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
@Component
public interface IGoodsDaoW{
	
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