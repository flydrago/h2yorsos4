package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.h2y.util.DataResponseUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class AdvertTest {

	
	public static void main(String[] args) {
		
//		AdvertTest advertTest = new AdvertTest();
//		advertTest.AdvertListTest();
//		advertTest.AdvertDataTest();
		
//		UUID uuid  =  UUID.randomUUID(); 
//		
//		for (int i = 0; i < 10; i++) {
//			
//			System.out.println(UUID.randomUUID().toString().length());
//		}
		
//		memberUserRegister();
		
//		createQrCode();
		
//		String wealth = "0";
//		
//		if(!StringUtils.isNotBlank(wealth)){
//			wealth="3";
//		}
//		
//		System.out.println(wealth);
		
//		test(3);
		
		
//		Double realAmount = 0.0d;
//		
//		System.out.println(realAmount==0);
//		
//		System.out.println(realAmount.doubleValue()==0);
//
		
		String a = "5dd998ad-e2ff-4e1a-ae76-51ad29684aaf";
		
		System.out.println(a.length());
	}
	
	
	public void AdvertListTest(){
		
		String url = "http://10.10.10.182:8080/h2yos/server/advert/wechat.htm";
		
		Map<String,Object> params = new HashMap<String,Object>();
		Map<String,Object> params1 = new HashMap<String, Object>();
		params.put("paraJson", "{\"paraJson\"={\"zoneCode\":\"410100000\"}}");
		String result = HttpTookit.doPost(url, params);
		
		System.out.println("返回结果："+result);
		
		List<Map<String,Object>> advertList = JSONUtil.jsonToListMap(result);
		
		for (Map<String, Object> map : advertList) {
			System.out.println("返回结果："+map);
		}
	}
	
	
	public void AdvertDataTest(){
		
		String url = "http://10.10.10.182:8080/h2yos/server/advert/getData.htm";
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("advertId", "8");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	public static void memberUserRegister(){
		
		String url = "http://10.10.10.182:80/h2yos/server/member/register.htm";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("type", 1);
		map.put("openId", "asdfasdf");
		map.put("account", "13836936936");
		map.put("pwd", "123456");
		map.put("moduleCode", "moduleCode");
		map.put("veriCode", "veriCode");
		map.put("realName", "测试");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("paraJson", JSONUtil.getJson(map));
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	public static void createQrCode(){
		
		String url = "http://10.10.10.182:80/h2yos/server/member/createQrCode.htm";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", 3);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("paraJson", JSONUtil.getJson(map));
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	public static void test(int dataType){
		
		switch (dataType) {
		case 0:
			
			break;
		case 1:
						
			break;
		case 2:
			
			break;
		case 3:
			
			System.out.println("case:"+dataType);
			System.out.println("case:"+dataType);
			break;
		default:
			System.out.println("default:"+dataType);
			return ;
		}
		
		System.out.println("end:"+dataType);
	}
	
}
