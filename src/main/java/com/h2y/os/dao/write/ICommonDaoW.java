package com.h2y.os.dao.write;

import java.util.Map;

import org.springframework.stereotype.Component;


/**
 * 常见的数据库操作

 * 作者：侯飞龙

 * 时间：2014-10-13 上午11:31:51

 * 电子邮件：1162040314@qq.com
 */
@Component
public interface ICommonDaoW{

	/**
	 * 更新活动商品销售数量
	 * @param commonActivityGoodsRt
	 * @return
	 */
	public int updateCommonActivityGoodsRt(Map<String,Object> map);


	/**
	 * 更新活动商品历史销售数量
	 * @param map
	 * @return
	 */
	public int updateCommonActivityGoodsRtHis(Map<String,Object> map);
}