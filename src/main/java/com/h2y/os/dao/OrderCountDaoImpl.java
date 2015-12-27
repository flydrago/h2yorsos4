package com.h2y.os.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IOrderCountDaoR;
import com.h2y.os.dao.write.IOrderCountDaoW;
import com.h2y.os.entity.OrderCount;


@Service("orderCountDao")
public class OrderCountDaoImpl implements IOrderCountDao{
	
	@Autowired
	protected IOrderCountDaoR orderCountDaoR;
	
	@Autowired
	protected IOrderCountDaoW orderCountDaoW;

	public void add(OrderCount orderCount) {
		// TODO Auto-generated method stub
		orderCountDaoW.add(orderCount);
	}

	public void update(OrderCount orderCount) {
		// TODO Auto-generated method stub
		orderCountDaoW.update(orderCount);
	}

	public OrderCount get(long id) {
		// TODO Auto-generated method stub
		return orderCountDaoR.get(id);
	}

	public OrderCount getByUnitIdAndDate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderCountDaoR.getByUnitIdAndDate(map);
	}

}
