package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IOrderDaoR;
import com.h2y.os.dao.write.IOrderDaoW;
import com.h2y.os.entity.Order;


@Service("orderDao")
public class OrderDaoImpl implements IOrderDao{
	
	@Autowired
	protected IOrderDaoR orderDaoR;
	
	@Autowired
	protected IOrderDaoW orderDaoW;

	public int add(Order order) {
		// TODO Auto-generated method stub
		return orderDaoW.add(order);
	}

	public int update(Order order) {
		// TODO Auto-generated method stub
		return orderDaoW.update(order);
	}

	public void updateComment(String orderNo) {
		// TODO Auto-generated method stub
		orderDaoW.updateComment(orderNo);
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		orderDaoW.deleteById(id);
	}

	public Order get(long id) {
		// TODO Auto-generated method stub
		return orderDaoR.get(id);
	}

	public Order getByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return orderDaoR.getByOrderNo(orderNo);
	}

	public List<Long> getHasGoodsShopList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getHasGoodsShopList(map);
	}

	public Map<String, Object> getVipCoinSumByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return orderDaoR.getVipCoinSumByOrderNo(orderNo);
	}

	public List<Map<String, Object>> getShoppingCartList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getShoppingCartList(map);
	}

	public void updateShoppingCartStatusByIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		orderDaoW.updateShoppingCartStatusByIds(map);
	}

	public List<Map<String, Object>> getListMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getListMap(map);
	}

	public long getListRows(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getListRows(map);
	}

	public Map<String, Object> getOrderDetail(String orderNo) {
		// TODO Auto-generated method stub
		return orderDaoR.getOrderDetail(orderNo);
	}

	public List<Map<String, Object>> getOrderGoodsList(String orderNo) {
		// TODO Auto-generated method stub
		return orderDaoR.getOrderGoodsList(orderNo);
	}

	public List<Map<String, Object>> getDeliveryListMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getDeliveryListMap(map);
	}

	public List<Order> getOrderListByDeliveryerStatus(int deliveryerStatus) {
		// TODO Auto-generated method stub
		return orderDaoR.getOrderListByDeliveryerStatus(deliveryerStatus);
	}

	public List<Order> getFinishOrderList() {
		// TODO Auto-generated method stub
		return orderDaoR.getFinishOrderList();
	}

	public void addHis(Order order) {
		// TODO Auto-generated method stub
		orderDaoW.addHis(order);
	}

	public void deleteByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		orderDaoW.deleteByOrderNo(orderNo);
	}

	public List<Map<String, Object>> getShopGoodsList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getShopGoodsList(map);
	}

	public long getCountOrder(String account) {
		// TODO Auto-generated method stub
		return orderDaoR.getCountOrder(account);
	}

	public List<Order> getUnDealOrderList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getUnDealOrderList(map);
	}

	public List<Order> getCountListByDate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDaoR.getCountListByDate(map);
	}

	public void updateIsHasCountByOrderNos(Map<String, Object> map) {
		// TODO Auto-generated method stub
		orderDaoW.updateIsHasCountByOrderNos(map);
	}

	public void updateRefundInfoByTradeNo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		orderDaoW.updateRefundInfoByTradeNo(map);
	}

	public void updateTradeInfoByOrderNo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		orderDaoW.updateTradeInfoByOrderNo(map);
	}

	public void updateRefundBatchNoByOrderNo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		orderDaoW.updateRefundBatchNoByOrderNo(map);
	}

	public List<Order> getByOrderUnique(String orderUnique) {
		// TODO Auto-generated method stub
		return orderDaoR.getByOrderUnique(orderUnique);
	}


}
