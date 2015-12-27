package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import com.h2y.entity.PushToData;
import com.h2y.os.entity.DeliveryUser;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.ReceiveAddress;
import com.h2y.os.entity.Storehouse;
import com.h2y.os.entity.SysDepartment;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.entity.SysUser;
import com.h2y.os.entity.Zone;


/**
 * 常见的数据库操作

 * 作者：侯飞龙

 * 时间：2014-10-13 上午11:31:51

 * 电子邮件：1162040314@qq.com
 */
public interface ICommonDao{

	/**
	 * 根据区域编码和单位类型得到单位列表
	 * @param map
	 * {zoneCode:区域编码,
	 * unitType:单位类型（0：区域代理、1：旗舰店、3：其他）}
	 * @return
	 */
	public List<SysUnits> getListByZoneCodeAndUnitType(Map<String,Object> map);

	/**
	 * 根据区域编码得到区域信息
	 * @param code 区域编码
	 * @return
	 */
	public Zone getZoneByCode(String code);

	/**
	 * 获取收货地址
	 * @param id 收货地址id
	 * @return
	 */
	public ReceiveAddress getReceiveAddress(long id);


	/**
	 * 根据单位id，获取虚拟门店
	 * @param unitId 单位id
	 * @return
	 */
	public SysDepartment getVitualShop(long unitId);

	/**
	 * 得到离收货地址，最近的门店
	 * @param map
	 * {latitude:收货地址纬度,
	 * longitude:收货地址经度,
	 * shopIds:门店id集合}
	 * @return
	 */
	public SysDepartment getNearShop(Map<String,Object> map);

	/**
	 * 根据id，得到对应的会员信息
	 * @param id 会员id
	 * @return
	 */
	public MemberUser getMemberUser(long id);

	/**
	 * 根据账号，得到对应的会员信息
	 * @param account 会员账号
	 * @return
	 */
	public MemberUser getMemberUserByAccount(String account);

	/**
	 * 根据id，得到对应的配送员信息
	 * @param id 配送员id
	 * @return
	 */
	public DeliveryUser getDeliveryer(long id);


	/**
	 * 根据id，得到对应的单位信息
	 * @param id 单位id
	 * @return
	 */
	public SysUnits getSysUnits(long id);

	/**
	 * 根据门店id，得到对应的仓库信息
	 * @param shopId 门店id
	 * @return
	 */
	public Storehouse getStorehouseByShopId(long shopId);

	/**
	 * 得到会员的推荐人
	 * @param map
	 * {memberId:会员id,
	 * refLevel:推荐人级别}
	 * @return
	 */
	public String getMemberRefRtAccount(Map<String,Object> map);

	/**
	 * 得到推送的配送员的列表
	 * @param map
	 * {latitude:收货地址纬度,
	 * longitude:收货地址经度,
	 * xKm:x距离以内的配送员,
	 * yPeople:y个配送员的人,
	 * iosDelivery:ios 配送端（配送登录类型）,
	 * androidDelivery: android 配送端（配送登录类型）,
	 * deliveryAcccoutList:配送员账号列表}
	 * @return
	 */
	public List<PushToData> getPushDeliveryList(Map<String,Object> map);


	/**
	 * 得到推送的门店列表
	 * @param map
	 * {unitId 单位id,
	 * pcApp:pc应用配送登录类型}
	 * @return
	 */
	public List<PushToData> getPushShopList(Map<String,Object> map);

	/**
	 * 得到虚拟门店仓库的数量（用于判断当前单位的虚拟门店是否维护仓库）
	 * @param unitId 单位id
	 * @return
	 */
	public long getVirtualShopStorehouseRows(long unitId);

	/**
	 * 根据部门id，得到部门下面的人员信息（取第一个人员）
	 * @param deptId 部门id
	 * @return
	 */
	public SysUser getSysUserByDeptId(long deptId);

	/**
	 * 根据配送员账号，得到配送的单位id列表
	 * @param account 配送员账号
	 * @return
	 */
	public List<Long> getUnitIdsByDeliveryAccount(String account);

	/**
	 * 根据单位id，得到当前单位下面的配送员账号列表
	 * @param unitId 单位id
	 * @return
	 */
	public List<String> getDeliveryAccountsByUnitId(long unitId);

	/**
	 * 获取当前活动（判断该活动是否为秒杀活动）
	 * @param dataId
	 * @return
	 */
	public Map<String,Object> getCommonActivityById(long dataId);

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


	/**
	 * 获取当前用户
	 * @param userId
	 * @return
	 */
	public SysUser getSysUserById(long userId);
	
	
	/**
	 * 根据id，得到单位对象
	 * @param id
	 * @return
	 */
	public SysUnits getSysUnitsByDomain(String domain);


}