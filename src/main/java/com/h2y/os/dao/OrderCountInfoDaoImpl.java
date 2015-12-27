package com.h2y.os.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IOrderCountInfoDaoR;
import com.h2y.os.dao.write.IOrderCountInfoDaoW;
import com.h2y.os.entity.OrderCountInfo;


@Service("orderCountInfoDao")
public class OrderCountInfoDaoImpl implements IOrderCountInfoDao{
	
	@Autowired
	protected IOrderCountInfoDaoR orderCountInfoDaoR;
	
	@Autowired
	protected IOrderCountInfoDaoW orderCountInfoDaoW;

	public void add(OrderCountInfo orderCountInfo) {
		// TODO Auto-generated method stub
		orderCountInfoDaoW.add(orderCountInfo);
	}

	public void update(OrderCountInfo orderCountInfo) {
		// TODO Auto-generated method stub
		orderCountInfoDaoW.update(orderCountInfo);
	}

	public OrderCountInfo get(long id) {
		// TODO Auto-generated method stub
		return orderCountInfoDaoR.get(id);
	}

	public OrderCountInfo getByCountIdAndInfoType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderCountInfoDaoR.getByCountIdAndInfoType(map);
	}

}
