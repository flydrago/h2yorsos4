package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IOrderFlowDaoR;
import com.h2y.os.dao.write.IOrderFlowDaoW;
import com.h2y.os.entity.OrderFlow;


@Service("orderFlowDao")
public class OrderFlowDaoImpl implements IOrderFlowDao{
	
	@Autowired
	protected IOrderFlowDaoR orderFlowDaoR;
	
	@Autowired
	protected IOrderFlowDaoW orderFlowDaoW;

	public int add(OrderFlow orderFlow) {
		// TODO Auto-generated method stub
		return orderFlowDaoW.add(orderFlow);
	}

	public int update(OrderFlow orderFlow) {
		// TODO Auto-generated method stub
		return orderFlowDaoW.update(orderFlow);
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		orderFlowDaoW.deleteById(id);
	}

	public OrderFlow get(long id) {
		// TODO Auto-generated method stub
		return orderFlowDaoR.get(id);
	}

	public List<Map<String, Object>> getListMap(String orderNo) {
		// TODO Auto-generated method stub
		return orderFlowDaoR.getListMap(orderNo);
	}

	public long getRowsByStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderFlowDaoR.getRowsByStatus(map);
	}

	public List<OrderFlow> getListByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return orderFlowDaoR.getListByOrderNo(orderNo);
	}

	public void addHisBatch(List<OrderFlow> list) {
		// TODO Auto-generated method stub
		orderFlowDaoW.addHisBatch(list);
	}

	public void deleteByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		orderFlowDaoW.deleteByOrderNo(orderNo);
	}


}
