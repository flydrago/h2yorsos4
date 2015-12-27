package com.h2y.os.entity;

import java.util.Date;

import com.h2y.object.BaseObject;

/**
 * 项目名称：h2yorsos  
 * 类名称：OrderFlow  
 * 类描述：订单流向记录模型  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:32:37  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:32:37  
 * 修改备注：  
 * @version
 */
public class OrderFlow extends BaseObject{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
    public static final String key = "keyOrderFlow";
    private long id;
    private long orderId;
    private String orderNo;
    private Double longitude;
    private Double latitude;
    private String position;
    private int orderStatus;
    private String memo;
    private Date createDate;
    private int operatorType;
    private String operatorId;
    private String operatorName;

	public OrderFlow(){
		super();
	}

	public OrderFlow(long id){
		super();
		this.id = id;
	}

	public OrderFlow(long id,long orderId,String orderNo,Double longitude,Double latitude,String position,int orderStatus,String memo,Date createDate,int operatorType,String operatorId,String operatorName){
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.longitude = longitude;
		this.latitude = latitude;
		this.position = position;
		this.orderStatus = orderStatus;
		this.memo = memo;
		this.createDate = createDate;
		this.operatorType = operatorType;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
	}
  
    public long getId(){
      return id;
    }
    
    public void setId(long id){
      this.id = id;
    }

    public long getOrderId(){
      return orderId;
    }
    
    public void setOrderId(long orderId){
      this.orderId = orderId;
    }


    public String getOrderNo(){
      return orderNo;
    }
    
    public void setOrderNo(String orderNo){
      this.orderNo = orderNo;
    }


    public Double getLongitude(){
      return longitude;
    }
    
    public void setLongitude(Double longitude){
      this.longitude = longitude;
    }


    public Double getLatitude(){
      return latitude;
    }
    
    public void setLatitude(Double latitude){
      this.latitude = latitude;
    }


    public String getPosition(){
      return position;
    }
    
    public void setPosition(String position){
      this.position = position;
    }


    public int getOrderStatus(){
      return orderStatus;
    }
    
    public void setOrderStatus(int orderStatus){
      this.orderStatus = orderStatus;
    }


    public String getMemo(){
      return memo;
    }
    
    public void setMemo(String memo){
      this.memo = memo;
    }


    public Date getCreateDate(){
      return createDate;
    }
    
    public void setCreateDate(Date createDate){
      this.createDate = createDate;
    }


    public int getOperatorType(){
      return operatorType;
    }
    
    public void setOperatorType(int operatorType){
      this.operatorType = operatorType;
    }


    public String getOperatorId(){
      return operatorId;
    }
    
    public void setOperatorId(String operatorId){
      this.operatorId = operatorId;
    }


    public String getOperatorName(){
      return operatorName;
    }
    
    public void setOperatorName(String operatorName){
      this.operatorName = operatorName;
    }

    public String toString(){
	return "id:"+id+"\t"+"orderId:"+orderId+"\t"+"orderNo:"+orderNo+"\t"+"longitude:"+longitude+"\t"+"latitude:"+latitude+"\t"+"position:"+position+"\t"+"orderStatus:"+orderStatus+"\t"+"memo:"+memo+"\t"+"createDate:"+createDate+"\t"+"operatorType:"+operatorType+"\t"+"operatorId:"+operatorId+"\t"+"operatorName:"+operatorName;
    }
}