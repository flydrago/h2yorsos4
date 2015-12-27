package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.util.OrderUtil;
import com.h2y.os.util.SysBaseUtil.DeliveryStatusKey;
import com.h2y.os.util.SysBaseUtil.PayType;
import com.h2y.util.DictUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;

public class OrderTest {

	
	public static void main(String[] args) {
		
//		submit();
		
		orderParams();
		
//		getList();
		
//		getDetail();
		
//		getTrack();
		
//		memberDeal();
		
//		deliveryerDeal();
		
//		dqdList();
		
//		dfhList();
		
//		ywcList();
		
//		getDeliveryDetail();
		
//		clearOrder();
		
//		orderComment();
		
//		goodsComment();
		
//		updateOrder();
		
//		payParams();
		
//		getListRows();
		
//		Map<String,String> payMode = new HashMap<String, String>();
		
		
//		Map<String,PayType> payModeData = new HashMap<String,PayType>();
//		
////		payTypeCheck(payModeData, DictUtil.getDictDetailList(1, "payMode"));
//		
//		payTypeCheck(payModeData, DictUtil.getDictDetailList(14, "payMode"));
//		payTypeCheck(payModeData, DictUtil.getDictDetailList(63, "payMode"));
//		
//		System.out.println(payModeData);
		
//		refund();
		
	}
	
	
	private static void payTypeCheck(Map<String,PayType> payModeData,List<Map<String,Object>> payDictList){
			
			boolean isEmpty = payModeData.isEmpty();
			for (Map<String, Object> map : payDictList) {
				String value = map.get("value")+"";
				String code = map.get("code")+"";
				if (!MatcherUtil.isOnlinePay(code)) {
					continue;
				}
				
				if (MatcherUtil.checkNumber(value) && value.equals("1")) {
					if (isEmpty) {
						payModeData.put(code, OrderUtil.getPayTypeByValue(code));
					}
				}else {
					if (!isEmpty) {
						payModeData.remove(code);
					}
				}
			}
		}
	
	public static void update(Integer a){
		
		a-=1;
	}
	
	
	/**
	 * 提交订单
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * receiverAddressId:收货地址,
	 * receiverLongitude:收货地址经度,
	 * receiverLatitude:收货地址纬度,
	 * receiverAddress:收货地址信息,
	 * receiverName:收货人姓名,
	 * receiverMobile:收货人手机号码,
	 * isUseVipCoin:是否使用达人币（0：不使用、1：使用）,
	 * vipCoin:使用达人币额度,
	 * shopingCartList:{{id:购物车id1},{id:购物车id2}]
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void submit(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/submit.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 28);
		postData.put("zoneCode", "cs2");
		postData.put("receiverAddressId", 5001);
		postData.put("receiverLongitude", "113.700955");
		postData.put("receiverLatitude", "34.752369");
		postData.put("receiverAddress", "郑州市郑汴路城东路交叉口向东50米康桥商务广场");
		postData.put("receiverName", "侯飞龙");
		postData.put("receiverMobile", "13838257740");
		postData.put("payType", "1");//0：货到付款、1：支付宝支付、2：微信支付(暂不支持)
		List<Map<String,Object>> shoppingCartList = new ArrayList<Map<String,Object>>();
		Map<String,Object> shoppingCart = new HashMap<String, Object>();
		shoppingCart.put("id", "53869");
		
//		Map<String,Object> shoppingCart1 = new HashMap<String, Object>();
//		shoppingCart1.put("id", "53863");
//		Map<String,Object> shoppingCart2 = new HashMap<String, Object>();
//		shoppingCart2.put("id", "53864");
//		Map<String,Object> shoppingCart3 = new HashMap<String, Object>();
//		shoppingCart3.put("id", "53865");
//		
		shoppingCartList.add(shoppingCart);
//		shoppingCartList.add(shoppingCart1);
//		shoppingCartList.add(shoppingCart2);
//		shoppingCartList.add(shoppingCart3);
		postData.put("shoppingCartList", shoppingCartList);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	
	/**
	 * 获取订单参数
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * shopingCartList:{{id:购物车id1},{id:购物车id2}]
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单参数数据}
	 */
	public static void orderParams(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/orderParams.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 28);
		postData.put("zoneCode", "cs2");
		
		List<Map<String,Object>> shoppingCartList = new ArrayList<Map<String,Object>>();
		Map<String,Object> shoppingCart = new HashMap<String, Object>();
		shoppingCart.put("id", "53870");
		
//		Map<String,Object> shoppingCart1 = new HashMap<String, Object>();
//		shoppingCart1.put("id", "227");
		
		shoppingCartList.add(shoppingCart);
//		shoppingCartList.add(shoppingCart1);
		postData.put("shoppingCartList", shoppingCartList);
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	/**
	 * 获取订单列表
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * page:页码,
	 * pagesize:页显示最大记录数,
	 * listFlag:列表标识（dfkList:待付款,dshList:待收货） null时不做判断}}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表数据}
	 */
	public static void getList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/getList.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 28);
		postData.put("page", "1");
		postData.put("pagesize", "20");
//		postData.put("listFlag", "dshList");
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 获取订单详细
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单详细数据}
	 */
	public static void getDetail(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/getDetail.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "20151220101609120163370");
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 获取配送端订单详细
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单详细数据}
	 */
	public static void getDeliveryDetail(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/getDeliveryDetail.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "201504291016367716347");
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 得到订单的跟踪信息
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单跟踪信息}
	 */
	public static void getTrack(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/getTrack.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "20151220101609120163370");
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 会员处理订单
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号,
	 * orderStatus: 收货状态（21：签收订单、-21：取消订单、-22:拒绝签收）,
	 * memberId:会员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void memberDeal(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/memberDeal.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "20151219174033673008162");
		postData.put("orderStatus", -21);
		postData.put("memberId", 28);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 配送员处理订单
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号,
	 * orderStatus: 配送状态（11：商品配送中、12：配送完成、-11:客户拒收）,
	 * deliveryerId:配送员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void deliveryerDeal(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/deliveryerDeal.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "201505081001588871083");
		postData.put("orderStatus", DeliveryStatusKey.juShou.status);
		postData.put("deliveryerId", 1);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 配送员待抢单列表
	 * @param reqMap
	 * postData={
	 * deliveryerId:配送员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表}
	 */
	public static void dqdList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/dqdList.htm";
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("deliveryerId", 3);
		
		System.out.println(JSONUtil.getJson(postData));
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 配送员待发货列表
	 * @param reqMap
	 * postData={
	 * deliveryerId:配送员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表}
	 */
	public static void dfhList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/dfhList.htm";
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("deliveryerId", 3);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 配送员已完成列表
	 * @param reqMap
	 * postData={
	 * deliveryerId:配送员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表}
	 */
	public static void ywcList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/ywcList.htm";
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("deliveryerId", 3);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 配送员已退货列表
	 * @param reqMap
	 * postData={
	 * deliveryerId:配送员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表}
	 */
	public static void ythList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/ythList.htm";
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("deliveryerId", 1);
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	
	/**
	 * 获取订单参数
	 * @param reqMap
	 * postData={}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void clearOrder(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/clearOrder.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 订单评论
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void orderComment(){
		
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/orderComment.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "20150601141424851303635");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 订单商品评论
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号,
	 * goodsPriceId:商品定价id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void goodsComment(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/goodsComment.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "20150601141424851303635");
		postData.put("goodsPriceId", "81");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 更新订单（付款状态、退款状态）
	 * @param reqMap
	 * postData={
	 * updateFlag:更新标识(pay:付款、refund:退款),
	 * tradeNo:交易号,
	 * orderNo:订单编号 （updateFlag为pay时，不可为空）,
	 * refundAmount:退款金额  （updateFlag为refund时，不可为空）,
	 * refundBatchNo:退款批次号 （updateFlag为refund时，不可为空）
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void updateOrder(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/updateOrder.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
//		postData.put("orderNo", "20150826155021011217735");
//		postData.put("updateFlag", "pay");
//		postData.put("tradeNo", "1212122135");
		
		postData.put("updateFlag", "refund");
		postData.put("tradeNo", "1212122135");
		postData.put("refundAmount", "12.04");
		postData.put("refundBatchNo", "201508272324");
		
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	/**
	 * 获取订单支付方式
	 * @param reqMap
	 * postData={
	 * orderNo:订单编号
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:{payType:支付方式,payParams:支付参数}}
	 */
	public static void payParams(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/payParams.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("orderNo", "20150910152911542635805");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 获取订单列表行数
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * listFlag:列表标识（dfkList:待付款,dshList:待收货） null时不做判断}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:订单列表行数}
	 */
	public static void getListRows(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/order/getListRows.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 30);
		postData.put("listFlag", "dpjList");
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
}
