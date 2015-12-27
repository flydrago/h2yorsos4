package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IGoodsDaoR;
import com.h2y.os.dao.write.IGoodsDaoW;
import com.h2y.os.entity.CommonActivityGoodsRt;
import com.h2y.os.entity.DataGoodsInfo;
import com.h2y.os.entity.GoodsPrice;


@Service("goodsDao")
public class GoodsDaoImpl implements IGoodsDao{
	
	@Autowired
	protected IGoodsDaoR goodsDaoR;
	
	@Autowired
	protected IGoodsDaoW goodsDaoW;

	public GoodsPrice get(long id) {
		// TODO Auto-generated method stub
		return goodsDaoR.get(id);
	}

	public CommonActivityGoodsRt getCommonActivityGoodsRt(long id) {
		// TODO Auto-generated method stub
		return goodsDaoR.getCommonActivityGoodsRt(id);
	}

	public List<DataGoodsInfo> getDataGoodsInfoList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsDaoR.getDataGoodsInfoList(map);
	}

	public void updateGoodsSellRate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		goodsDaoW.updateGoodsSellRate(map);
	}

	public void updateGoodsInventory(Map<String, Object> map) {
		// TODO Auto-generated method stub
		goodsDaoW.updateGoodsInventory(map);
	}


}
