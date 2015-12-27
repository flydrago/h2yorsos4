package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.h2y.util.DataResponseUtil;
import com.h2y.util.DictUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;

public class DictUtilTest {

	
	public static void main(String[] args) {
		
		
		List<Map<String,Object>> list = DictUtil.getDictDetailList(14, "payMode");
			for (Map<String,Object> map : list) {
				
				System.out.println(map.get("value"));
			}
		
	}
}
