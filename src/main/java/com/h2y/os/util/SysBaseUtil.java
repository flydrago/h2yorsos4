package com.h2y.os.util;

import com.h2y.memcached.MemcachedUtil;
import com.h2y.util.PropertiesUtil;



public class SysBaseUtil {

	/**
	 * mencached 缓存有效时间（秒）
	 */
	public final static long EXPIRY_TIME = 600;


	public final static String JYD_KF="4008609519";

	public final static String ZZS_CODE="41010000";

	/**
	 * 微信注册模块code
	 */
	public final static String WREGISTER_CODE="W_REGISTER_MODULE";

	/**
	 * 微信充值密码code
	 */
	public final static String WRESET_CODE="W_RESET_MODULE";

	//转发服务
	public static String CMBS_URL = null;

	/**
	 * 优惠券来源：平台发放
	 */
	public final static String PLATFORMSEND_CODE="platformSend";

	/**
	 * 优惠券来源：首单优惠
	 */
	public final static String FIRSTORDER_CODE="firstOrder";

	/**
	 * 优惠券来源：金额满赠
	 */
	public final static String FULLAMOUNT_CODE="fullAmount";

	/**
	 * 优惠券来源：推荐好友
	 */
	public final static String RECOMMENDREGISTER_CODE="recommendRegister";

	/**
	 * 优惠券来源：注册
	 */
	public final static String REGISTER_CODE="register";


	/**
	 * 优惠券来源：海报发放
	 */
	public final static String POSTERSEND_CODE="posterSend";


	//配送抢单同步键（1：抢单操作处理中、0：处理完毕）
	public static String DELIVERY_QIANG_DAN_SYN_KEY = "DELIVERY_QIANG_DAN_SYN_KEY";

	public static int deliverSynKey = 0;

	static {

		PropertiesUtil mPropertiesUtil = PropertiesUtil.getInstance("/confing.properties");

		if(mPropertiesUtil.getValueByKey("cmbs.url") != null){
			CMBS_URL = mPropertiesUtil.getValueByKey("cmbs.url");
		}

		reSetQingDanMemcache();
	}


	/**
	 * 重置抢单标识
	 */
	private static void reSetQingDanMemcache(){

		MemcachedUtil.getInstance().delete(SysBaseUtil.DELIVERY_QIANG_DAN_SYN_KEY);
		MemcachedUtil.getInstance().add(SysBaseUtil.DELIVERY_QIANG_DAN_SYN_KEY, "0");
	}


	public static void main(String[] args) {


		//		Calendar nowTime = Calendar.getInstance();
		//		long now = nowTime.getTimeInMillis();
		//		
		//		nowTime.add(Calendar.MINUTE, 30);
		//		long expiryTime = nowTime.getTimeInMillis();
		//		System.out.println("now:"+new Date().getTime());
		//		System.out.println("now:"+now+" expiryTime:"+(expiryTime-now)/60000);


		//		String prefix = "12_123123_2323";
		//		prefix = prefix.substring(prefix.indexOf("_")+1, prefix.length());
		//		System.out.println(prefix);
		//		System.out.println(prefix.replaceAll("_", ","));

		//		Map<String,Object> map = new HashMap<String,Object>();
		//		map.put("code", 1);
		//		map.put("value", "男");
		//
		//		Map<String,Object> map1 = new HashMap<String,Object>();
		//		map1.put("code", 1);
		//		map1.put("value", "女");
		//
		//		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//
		//		list.add(map1);
		//		list.add(map);
		//
		//		System.out.println(JSONUtil.getJson(list));

		//
		//		File filePath = new File("/opt1/test1/");
		//		if (!filePath.exists()) {
		//			filePath.mkdirs();
		//		}
		//		System.out.println(MD5Util.getMD5("123"));


		//		System.out.println(StringUtils.isNotBlank(""));
		//		System.out.println(StringUtils.isNotBlank(null));
		//		System.out.println(StringUtils.isNotBlank("   "));
		//		System.out.println(StringUtils.isNotBlank("adsfasd"));
		//		System.out.println(StringUtils.isNotBlank("  asdfasd"));
		//		System.out.println(StringUtils.isNotBlank("  asdfasdf"));
		//		System.out.println("");
		//		
		//		System.out.println(StringUtils.isEmpty(""));
		//		System.out.println(StringUtils.isEmpty(null));
		//		System.out.println(StringUtils.isEmpty("   "));
		//		System.out.println(StringUtils.isEmpty("adsfasd"));
		//		System.out.println(StringUtils.isEmpty("  asdfasd"));
		//		System.out.println(StringUtils.isEmpty("  asdfasdf"));


		//		
		//		long time = new Date().getTime();
		//		
		//		System.out.println(time);
	}



	/**
	 * 侯飞龙
	 * 混合选择窗口，列表健
	 */
	public enum MixSelectListKey{

		/**
		 * 人员列表健
		 */
		pepleKey("p_"),

		/**
		 * 部门列表健
		 */
		deptKey("d_");

		public String key;
		private MixSelectListKey(String result){
			this.key=result;
		}
	}


	/**
	 * 权限类型静态变量
	 */
	public class PrivilegeKey{

		/**
		 * 单位
		 */
		public final static String UNIT = "UNIT";


		/**
		 * 用户
		 */
		public final static String USER = "USER";

		/**
		 * 角色
		 */
		public final static String ROLE = "ROLE";

		/**
		 * 菜单
		 */
		public final static String MENU = "MENU";


		/**
		 * 按钮
		 */
		public final static String BUTTON = "BUTTON";
	}


	/**
	 * 积分情况
	 * @author lilaing
	 *
	 */
	public class GradeKey{

		/**
		 * 达人豆
		 */
		public final static String CATEGORY_BEAN="0";

		/**
		 * 达人币
		 */
		public final static String CATEGORY_COIN="1";

		/**
		 * 签到
		 */
		public final static String SIGN_TYPE="0";

		/**
		 * 消费
		 */
		public final static String FEE_TYPE="1";

		/**
		 * 作为第一推荐人获取奖励
		 */
		public final static String REF_ONE_TYPE="2";

		/**
		 * 作为第二推荐热获取奖励
		 */
		public final static String REF_TWO_TYPE="3";

		/**
		 * 退还
		 */
		public final static String BACK_TYPE="4";




		/**
		 * 大转盘
		 */
		public final static String WHEEL_TYPE="5";


		/**
		 * 刮刮卡
		 */
		public final static String CARD_TYPE="6";


		/**
		 * 砸金蛋
		 */
		public final static String EGG_TYPE="7";


		/**
		 * 推荐人关系建立
		 */
		public final static String REF_BUILD="8";

		/**
		 * 促销活动
		 */
		public final static String COMMON_ACTIVITY="9";

		/**
		 * 商品
		 */
		public final static String GOODS = "10";
	}




	/**
	 * mencached健前缀
	 */
	public class MemcachedKeyPrefix{

		/**
		 * 用户Id
		 */
		public final static String USER_ID = "H2Y_USER_ID";


		/**
		 * 单位Id
		 */
		public final static String UNIT_ID = "H2Y_UNIT_ID";

		/**
		 * 系统角色Id
		 */
		public final static String SYS_ROLE_ID = "H2Y_SYS_ROLE_ID";


		/**
		 * 用户对象
		 */
		public final static String USER = "H2Y_USER";

		/**
		 * 单位对象
		 */
		public final static String UNIT = "H2Y_UNIT";
	}


	/**
	 * 系统维护关联类型
	 */
	public class SysJoinType{


		/**
		 * 菜单
		 */
		public final static String MENU = "menu";


		/**
		 * 表格列
		 */
		public final static String GRID = "grid";

		/**
		 * 验证
		 */
		public final static String VALIDATE = "validate";


		/**
		 * 查询
		 */
		public final static String QUERY = "query";
	}



	public class DictKey{


		public final static String ABOUT_DELIVERY="ABOUT_DELIVERY";

		public final static String DELIVERY_TIME="DELIVERY_TIME";

		//运费
		public final static String FEE="FEE";

		//产生运费标准
		public final static String MIN_FEE="MIN_FEE";



	}


	/**
	 * 字典前缀 
	 */
	public class DictPrefix{

		/**
		 * 主表
		 */
		public final static String DIC_MAIN = "DIC_MAIN";


		/**
		 * 详细表
		 */
		public final static String DIC_DETAIL = "DIC_DETAIL";
	}


	public enum DictClumn{
		//id
		id,
		//主表Id
		dictMainId,
		//编码
		code,
		//对应值
		value,
		//备注信息
		memo,
		//排序字段
		ord;
	}

	public enum DictOrderBy{
		//降序
		desc,
		//升序
		asc
	}


	/**
	 * 操作类型
	 */
	public enum OpType{

		/**
		 * 登陆
		 */
		login,

		/**
		 * 退出
		 */
		loginOut,

		/**
		 * 添加
		 */
		add,

		/**
		 * 删除
		 */
		delete,

		/**
		 * 修改
		 */
		modify,

		/**
		 * 查询
		 */
		search;
	}

	/**
	 * 操作结果
	 */
	public enum OpRresult{

		/**
		 * 操作成功
		 */
		success,

		/**
		 * 操作失败
		 */
		fail;
	}


	/**
	 * 广告对象数组
	 */
	public enum AdvertObj{


		/**
		 * android客户端
		 */
		Android("android",1),

		/**
		 * Ios客户端
		 */
		IOS("ios",2),

		/**
		 * 微信客户端
		 */
		WeChat("wechat",4);

		public final String name;//字典code
		public final int pow;//次方
		private AdvertObj(String name,int pow){
			this.name = name;
			this.pow = pow;
		}
	}

	/**
	 * 广告主题类型枚举
	 */
	public enum AdvertSubjectType{

		/**
		 * 商品列表
		 */
		LIST("list"),

		/**
		 * 商品详细
		 */
		DETAIL("detail"),

		/**
		 * 宣传页面
		 */
		HTML("html");

		public final String name;//字典code
		private AdvertSubjectType(String name){
			this.name = name;
		}
	}


	/**
	 * 类描述：微信活动类型   
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum WechatActivityType{

		/**
		 * 大转盘
		 */
		wheel("wheel"),

		/**
		 * 刮刮卡
		 */
		card("card"),

		/**
		 * 砸金蛋
		 */
		egg("egg");

		public final String name;
		private WechatActivityType(String name){
			this.name = name;
		}
	}


	/**
	 * 类描述：奖品类型
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum PrizeType{

		/**
		 * 达人币
		 */
		darenbi("darenbi"),

		/**
		 * 达人豆
		 */
		darendou("darendou"),

		/**
		 * 商品
		 */
		goods("goods"),

		/**
		 * 其他
		 */
		qita("qita");

		public final String name;
		private PrizeType(String name){
			this.name = name;
		}
	}



	/**
	 * 类描述：订单静态变量
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum OrderKey{

		/**
		 * 商品列表
		 */
		goodsList("goodsList"),

		/**
		 * 商品单位id
		 */
		unitId("unitId"),

		/**
		 * 商品单位类型
		 */
		unitType("unitType");

		public final String value;
		private OrderKey(String value){
			this.value = value;
		}
	}



	/**
	 * 类描述：订单静态变量
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum OrderGoodsKey{

		/**
		 * 购物车id
		 */
		shopingCartId("shopingCartId"),

		/**
		 * 商品定价对象
		 */
		goodsPrice("goodsPrice"),

		/**
		 * 商品定价id
		 */
		goodsPriceId("goodsPriceId"),

		/**
		 * 商品数量
		 */
		goodsCount("goodsCount"),

		/**
		 * 商品类型（0：购买、1：酒库）
		 */
		buyType("buyType"),

		/**
		 * 是否赠品（0：不是、1：是）
		 */
		isGift("isGift"),

		/**
		 * 商品促销活动信息
		 */
		commonActivityGoodsRt("commonActivityGoodsRt"),

		/**
		 * 赠品对应的主商品的id
		 */
		giftMainGoodsId("giftMainGoodsId");

		public final String value;
		private OrderGoodsKey(String value){
			this.value = value;
		}
	}

	/**
	 * 类描述：配送端状态key
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum DeliveryStatusKey{

		/**
		 * 受理订单
		 */
		takeOrder(10,"受理订单"),

		/**
		 * 配送完成
		 */
		peiSongEnd(11,"配送完成"),

		/**
		 * 客户拒收
		 */
		juShou(-11,"客户拒收");

		public final int status;
		public final String name;
		private DeliveryStatusKey(int status,String name){
			this.status = status;
			this.name = name;
		}
	}



	/**
	 * 类描述：会员状态key
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum MemberStatusKey{

		/**
		 * 提交订单
		 */
		submitOrder(20,"提交订单"),
		
		/**
		 * 确认收货
		 */
		receiveGoods(21,"确认收货"),
		
		/**
		 * 取消订单
		 */
		cancelOrder(-21,"取消订单");

		public final int status;
		public final String name;
		private MemberStatusKey(int status,String name){
			this.status = status;
			this.name = name;
		}
	}


	/**
	 * 类描述：订单操作人员类型key （0：系统人员、1：配送人员、2：会员）
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum OrderOperatorType{

		/**
		 * 配送人员
		 */
		DeliveryUser(1),

		/**
		 * 会员
		 */
		memberUser(2);

		public final int value;
		private OrderOperatorType(int value){
			this.value = value;
		}
	}


	/**
	 * 类描述：支付类型
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum PayType{

		/**
		 * 货到付款
		 */
		payOnDelivery(0,"payOnDelivery","货到付款"),

		/**
		 * 支付宝支付
		 */
		alipay(1,"alipay","支付宝"),

		/**
		 * 微信支付
		 */
		weixin(2,"weixin","微信支付");

		public final int flag;
		public final String value;
		public final String text;
		private PayType(int flag,String value,String text){
			this.flag = flag;
			this.value = value;
			this.text = text;
		}
	}

}
