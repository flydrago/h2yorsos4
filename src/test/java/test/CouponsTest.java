package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.CouponsKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.basic.WbsKeys.UnitKeys;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class CouponsTest {

	public static void main(String[] args) {
		//getMyCouponsListTest();
		//getUnclaimedCouponsListTest();
		//getCouponsDetailTest();
		//addCouponsTest();
		//test();
		getPosterCouponsList();
	}
	
	public static void test() {

		List<Long> myClaimedIdList = new ArrayList<Long>();
		myClaimedIdList.add(1L);
		myClaimedIdList.add(2L);
		myClaimedIdList.add(3L);

		if(myClaimedIdList.toString().contains("1")){
			System.out.println("--" );
		}
		
		System.out.println("--" + myClaimedIdList.toString());
	}
	
	public static void getMyCouponsListTest() {

		String url = "http://10.10.10.189:8082/h2yorsos/server/coupons/getMyCouponsList.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(CouponsKeys.account.value(), "15838279930");
		//postMap.put(CouponsKeys.couponsStatus.value(), "0");
		postMap.put("page", 1);
		postMap.put("pagesize", 10);
		

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}
	
	
	public static void getPosterCouponsList() {

		String url = "http://10.10.10.189:8082/h2yorsos/server/coupons/getPosterCouponsList.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(UnitKeys.zoneCode.value(), "4101");
		postMap.put(CouponsKeys.account.value(), "18939327901");
		postMap.put("subjectId", 110);
		postMap.put("page", 1);
		postMap.put("pagesize", 10);
		

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}
	
	public static void getUnclaimedCouponsListTest() {

		String url = "http://10.10.10.189:8082/h2yorsos/server/coupons/getUnclaimedCouponsList.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(UnitKeys.zoneCode.value(), "4101");
		postMap.put(CouponsKeys.account.value(), "18939327901");
		postMap.put("page", 1);
		postMap.put("pagesize", 10);
		

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}
	
	
	public static void getCouponsDetailTest() {

		String url = "http://10.10.10.189:8082/h2yorsos/server/coupons/getCouponsDetail.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(CouponsKeys.rid.value(), 4);
		
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}
	
	
	
	
	public static void addCouponsTest() {

		String url = "http://10.10.10.189:8082/h2yorsos/server/coupons/addCoupons.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(CouponsKeys.sourceCode.value(), "send");
		postMap.put(CouponsKeys.account.value(), "18939327902");
		postMap.put(CouponsKeys.couponsId.value(), "1");
		postMap.put(CouponsKeys.couponsCode.value(), "201507060002");
		postMap.put(CouponsKeys.orderNo.value(), "18939327902");

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}
	
	

}
