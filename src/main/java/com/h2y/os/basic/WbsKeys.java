package com.h2y.os.basic;

/**
 * 常用参数处理
 * 
 * @author：段晓刚
 * 
 * @update：2015年4月3日 上午11:39:23
 * 
 * @Email：
 */
public class WbsKeys {

	/**
	 * 服务端调用参数
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年3月27日 上午9:12:27
	 * 
	 * @Email：
	 */
	public enum SInvokeKeys {

		// 配合skey使用进行安全验证
		slock("slock"),
		// 配合slock使用
		skey("skey"),
		// 请求发出后的唯一标示
		sid("sid"),
		// 操作系统
		os("os"),
		// 系统操作类型
		osv("osv"),
		// app版本号
		appv("appv"),
		// 参数头部
		paramData("paramData"),
		// 业务参数
		postData("postData"),
		// 业务参数
		postMark("postMark"),
		// 返回结果标示
		resultFlag("resultFlag"),
		// 返回结果信息
		resultMsg("resultMsg"),
		// 返回的业务逻辑
		resultData("resultData");

		private String _value;

		SInvokeKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * bean常量
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年4月3日 上午11:43:26
	 * 
	 * @Email：
	 */
	public enum UserKeys {

		// 用户id
		userId("userId"),
		// 用户名字
		userName("userName"),
		// 昵称
		nickName("nickName"),
		// 账号
		account("account"),
		// 密码
		password("password");

		private String _value;

		UserKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 单位信息键值
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年4月7日 上午9:35:52
	 * 
	 * @Email：
	 */
	public enum UnitKeys {

		// 单位id
		unitId("unitId"),
		// 单位code
		unitCode("unitCode"),
		// 单位名称
		unitName("unitName"),
		// 地区编码
		zoneCode("zoneCode"),
		// 地区名称
		zoneName("zoneName");

		private String _value;

		UnitKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 方法处理
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年3月31日 下午4:41:40
	 * 
	 * @Email：
	 */
	public enum MethodKeys {

		// 注册
		register("user/register"),
		// 登录
		login("login"),
		// 用户退出
		exit("update"),
		// 商品数据
		goods("goods");

		private String _value;

		MethodKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 象过河对接参数
	 * 
	 * @author sunfj
	 * 
	 */
	public enum XghKeys {

		// 象过河账套编码,类似于公司信息中的公司id或者公司code
		xghucode("xghucode"),
		// 象过河中对应的公司编码
		xghuname("xghuname"),
		// 象过河返回数据
		xghcreatedate("xghcreatedate"),
		// 象过河记录的商品编码
		xghgdscode("xghgdscode"),
		// 象过河仓库编码
		xghstcode("xghstcode"),
		//象过河用户编号
		xghusercode("xghusercode"),
		// 象过河主订单编码
		xghordercode("xghordercode"),
		// 象过河子订单编码
		xghordercode2("xghordercode2"),

		// 单位id
		unitid("unitid"),
		// 单位code
		unitcode("unitcode"),
		// 单位名称
		unitname("unitname"),
		// 地区编码
		unitzone("unitzone"),
		// 地区名称
		unitzname("unitzname"),
		// 商品id
		goodsid("goodsid"),
		// 商品类型 0代表瓶，1代表箱
		goodstype("goodstype"),
		// 商品编码
		goodscode("goodscode"),
		// 商品名称
		goodsname("goodsname"),
		// 商品单位
		goodsunit("goodsunit"),
		// 商品规格
		goodsspec("goodsspec"),
		// 会员价格
		memberprice("memberprice"),
		// 市场价格
		marketprice("marketprice"),
		// 零售价格
		sellprice("sellprice"),
		// 商品活动价格
		activityprice("activityprice"),
		// 零售价格
		goodsintrodoce("goodsintrodoce"),
		//
		goodsintrodoce2("goodsintrodoce2"),
		// 仓库编码
		storageid("storageid"),
		// 仓库名称
		storagename("storagename"),
		// 仓库地址
		storageaddress("storageaddress"),
		// 店铺id
		shopid("shopid"),
		// 门店名称
		shopname("shopname"),
		// 主订单编号
		orderno("orderno"),
		// 子订单编号
		orderno2("orderno2"),
		// 数量
		count("count"),
		// 类型
		type("type"),
		// 时间单位s
		time("shopname"),
		// 支付类型，0虚拟货币支付、1现金支付、2pos支付、3支付宝、4微信支付、5其他支付
		paytype("paytype"),
		// 支付名称和paytype配合使用，主要显示对应的名称
		payname("payname"),
		// 应付金额，两位有效小数
		amount("amount"),
		// 支付账号
		payno("payno"),
		// 账号
		cardno("cardno"),
		// 单价
		price("price"),
		// 总价
		allprice("allprice"),
		// 用户名称
		username("username"),
		// 用户帐号
		account("account"),
		// 用户昵称
		usernick("usernick"),
		// 收货人手机号码
		receivemobile("receivemobile"),
		// 收货人名称
		receivename("receivename"),
		// 0客户退货，1客户收货
		optype("optype"),
		// 订单-价钱
		pricedata("pricedata"),
		// 订单-用户
		userdata("userdata"),
		// 订单-商品
		goodsstdata("goodsstdata"),
		//制单人信息
		makerdata("makerdata");

		private String _value;

		XghKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 优惠券
	 * @author sunfj
	 *
	 */
	public enum CouponsKeys {

		// 优惠券id
		couponsId("couponsId"),
		// 账号
		account("account"),
		//优惠券状态
		couponsStatus("couponsStatus"),
		//优惠券名称
		couponsName("couponsName"),
		//实际支付金额
		payAmount("payAmount"),
		//优惠券来源
		sourceCode("sourceCode"),
		//优惠券号
		couponsCode("couponsCode"),
		//是否使用优惠券
		isCoupons("isCoupons"),
		//关联id
		rid("rid"),
		// 订单编号
		orderNo("orderNo");

		private String _value;

		CouponsKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 服务端调用参数
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年3月27日 上午9:12:27
	 * 
	 * @Email：
	 */
	public enum JydKeys {

		// 单位id
		unitid("unitid"),
		// 单位code
		unitcode("unitcode"),

		// 商品id
		focusId("focusId"),

		// 商品id
		goodsId("goodsId"),
		// 商品编码
		gdsCode("gdsCode"),
		// 会员id
		memberId("memberId"),
		// 关注类型 0商品 1店铺
		focusType("focusType"),
		// 地区编号
		zoneCode("zoneCode"),

		// 定价表id
		goodsPriceId("goodsPriceId"),

		// 定价表版本号
		goodsPriceVersion("goodsPriceVersion"),

		// 商品类别
		goodsTypeId("goodsTypeId"),
		// 店铺id
		shopId("shopId"),
		// 商品来源
		goodsSource("goodsSource");

		private String _value;

		JydKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}
}