package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.entity.PushToData;
import com.h2y.os.dao.read.ICommonDaoR;
import com.h2y.os.dao.write.ICommonDaoW;
import com.h2y.os.entity.DeliveryUser;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.ReceiveAddress;
import com.h2y.os.entity.Storehouse;
import com.h2y.os.entity.SysDepartment;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.entity.SysUser;
import com.h2y.os.entity.Zone;


@Service("commonDao")
public class CommonDaoImpl implements ICommonDao{

	@Autowired
	protected ICommonDaoR commonDaoR;

	@Autowired
	protected ICommonDaoW commonDaoW;

	public List<SysUnits> getListByZoneCodeAndUnitType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commonDaoR.getListByZoneCodeAndUnitType(map);
	}

	public Zone getZoneByCode(String code) {
		// TODO Auto-generated method stub
		return commonDaoR.getZoneByCode(code);
	}

	public ReceiveAddress getReceiveAddress(long id) {
		// TODO Auto-generated method stub
		return commonDaoR.getReceiveAddress(id);
	}

	public SysDepartment getVitualShop(long unitId) {
		// TODO Auto-generated method stub
		return commonDaoR.getVitualShop(unitId);
	}

	public SysDepartment getNearShop(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commonDaoR.getNearShop(map);
	}

	public MemberUser getMemberUser(long id) {
		// TODO Auto-generated method stub
		return commonDaoR.getMemberUser(id);
	}

	public MemberUser getMemberUserByAccount(String account) {
		// TODO Auto-generated method stub
		return commonDaoR.getMemberUserByAccount(account);
	}

	public DeliveryUser getDeliveryer(long id) {
		// TODO Auto-generated method stub
		return commonDaoR.getDeliveryer(id);
	}

	public SysUnits getSysUnits(long id) {
		// TODO Auto-generated method stub
		return commonDaoR.getSysUnits(id);
	}

	public Storehouse getStorehouseByShopId(long shopId) {
		// TODO Auto-generated method stub
		return commonDaoR.getStorehouseByShopId(shopId);
	}

	public String getMemberRefRtAccount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commonDaoR.getMemberRefRtAccount(map);
	}

	public List<PushToData> getPushDeliveryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commonDaoR.getPushDeliveryList(map);
	}

	public List<PushToData> getPushShopList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commonDaoR.getPushShopList(map);
	}

	public long getVirtualShopStorehouseRows(long unitId) {
		// TODO Auto-generated method stub
		return commonDaoR.getVirtualShopStorehouseRows(unitId);
	}

	public SysUser getSysUserByDeptId(long deptId) {
		// TODO Auto-generated method stub
		return commonDaoR.getSysUserByDeptId(deptId);
	}

	public List<Long> getUnitIdsByDeliveryAccount(String account) {
		// TODO Auto-generated method stub
		return commonDaoR.getUnitIdsByDeliveryAccount(account);
	}

	public List<String> getDeliveryAccountsByUnitId(long unitId) {
		// TODO Auto-generated method stub
		return commonDaoR.getDeliveryAccountsByUnitId(unitId);
	}

	public Map<String, Object> getCommonActivityById(long dataId) {
		// TODO Auto-generated method stub
		return commonDaoR.getCommonActivityById(dataId);
	}

	public int updateCommonActivityGoodsRt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commonDaoW.updateCommonActivityGoodsRt(map);
	}

	public int updateCommonActivityGoodsRtHis(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commonDaoW.updateCommonActivityGoodsRtHis(map);
	}

	public SysUser getSysUserById(long userId) {
		// TODO Auto-generated method stub
		return commonDaoR.getSysUserById(userId);
	}

	public SysUnits getSysUnitsByDomain(String domain) {
		// TODO Auto-generated method stub
		return commonDaoR.getSysUnitsByDomain(domain);
	}

}
