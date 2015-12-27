package com.h2y.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.IOrderService;
import com.h2y.os.util.SysBaseUtil.DeliveryStatusKey;
import com.h2y.os.util.SysBaseUtil.MemberStatusKey;

/**
 * 项目名称：h2ygdsos  
 * 类名称：OrderController  
 * 类描述：订单服务接口（提交等）  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:21:54  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:21:54  
 * 修改备注：  
 * @version
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/order")
public class OrderController extends BaseController{
	
	@Autowired
	protected IOrderService orderService;
	
	/**
	 * 提交订单
	 */
	@RequestMapping(value="/submit")
	public void submit(){
		
		outJson(orderService.submit(getReqMap()));
	}
	
	/**
	 * 获取填写订单，需要的参数
	 */
	@RequestMapping(value="/orderParams")
	public void orderParams(){
		
		outJson(orderService.orderParams(getReqMap()));
	}
	
	
	/**
	 * 获取订单列表
	 */
	@RequestMapping(value="/getList")
	public void getList(){
		
		outJson(orderService.getList(getReqMap()));
	}
	
	
	
	/**
	 * 获取订单详细
	 */
	@RequestMapping(value="/getDetail")
	public void getDetail(){
		
		outJson(orderService.getDetail(getReqMap()));
	}
	
	
	/**
	 * 获取订单跟踪
	 */
	@RequestMapping(value="/getTrack")
	public void getTrack(){
		
		outJson(orderService.getTrackInfo(getReqMap()));
	}
	
	
	/**
	 * 会员处理订单
	 */
	@RequestMapping(value="/memberDeal")
	public void memberDeal(){
		
		outJson(orderService.memberDeal(getReqMap()));
	}
	
	/**
	 * 配送员处理订单
	 */
	@RequestMapping(value="/deliveryerDeal")
	public void deliveryerDeal(){
		
		outJson(orderService.deliveryerDeal(getReqMap()));
	}
	
	/**
	 * 配送端待抢单列表
	 */
	@RequestMapping(value="/dqdList")
	public void dqdList(){
			
		outJson(orderService.getDeliveryOrderList(getReqMap(), MemberStatusKey.submitOrder.status));
	}
	
	/**
	 * 配送端已完成列表
	 */
	@RequestMapping(value="/ywcList")
	public void ywcList(){
			
		outJson(orderService.getDeliveryOrderList(getReqMap(), DeliveryStatusKey.peiSongEnd.status));
	}
	
	
	/**
	 * 配送端已退货列表
	 */
	@RequestMapping(value="/ythList")
	public void ythList(){
			
		outJson(orderService.getDeliveryOrderList(getReqMap(), DeliveryStatusKey.juShou.status));
	}
	
	
	/**
	 * 获取配送端订单详细
	 */
	@RequestMapping(value="/getDeliveryDetail")
	public void getDeliveryDetail(){
		
		outJson(orderService.getDeliveryDetail(getReqMap()));
	}
	
	/**
	 * 订单评论
	 */
	@RequestMapping(value="/orderComment")
	public void comment(){
		
		outJson(orderService.orderComment(getReqMap()));
	}
	
	
	/**
	 * 订单商品评论
	 */
	@RequestMapping(value="/goodsComment")
	public void goodsComment(){
		
		outJson(orderService.goodsComment(getReqMap()));
	}
	
	/**
	 * 获取订单列表行数
	 */
	@RequestMapping(value="/getListRows")
	public void getListRows(){
		
		outJson(orderService.getListRows(getReqMap()));
	}
}
