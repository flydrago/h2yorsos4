package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IOrderGoodsRtDaoR;
import com.h2y.os.dao.write.IOrderGoodsRtDaoW;
import com.h2y.os.entity.OrderGoodsRt;


@Service("orderGoodsRtDao")
public class OrderGoodsRtDaoImpl implements IOrderGoodsRtDao{
	
	@Autowired
	protected IOrderGoodsRtDaoR orderGoodsRtDaoR;
	
	@Autowired
	protected IOrderGoodsRtDaoW orderGoodsRtDaoW;

	public void add(OrderGoodsRt orderGoodsRt) {
		// TODO Auto-generated method stub
		orderGoodsRtDaoW.add(orderGoodsRt);
	}

	public void update(OrderGoodsRt orderGoodsRt) {
		// TODO Auto-generated method stub
		orderGoodsRtDaoW.update(orderGoodsRt);
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		orderGoodsRtDaoW.deleteById(id);
	}

	public void updateComment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		orderGoodsRtDaoW.updateComment(map);
	}

	public long getRowsByOrderNoAndGoodsPriceId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderGoodsRtDaoR.getRowsByOrderNoAndGoodsPriceId(map);
	}

	public void addBatch(List<OrderGoodsRt> list) {
		// TODO Auto-generated method stub
		orderGoodsRtDaoW.addBatch(list);
	}

	public List<OrderGoodsRt> getListByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return orderGoodsRtDaoR.getListByOrderNo(orderNo);
	}

	public void addHisBatch(List<OrderGoodsRt> list) {
		// TODO Auto-generated method stub
		orderGoodsRtDaoW.addHisBatch(list);
	}

	public void deleteByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		orderGoodsRtDaoW.deleteByOrderNo(orderNo);
	}

	public List<OrderGoodsRt> getValidListByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return orderGoodsRtDaoR.getValidListByOrderNo(orderNo);
	}

	public List<Map<String, Object>> getListByBuyType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderGoodsRtDaoR.getListByBuyType(map);
	}

	public long getRowsByBuyType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderGoodsRtDaoR.getRowsByBuyType(map);
	}

}
