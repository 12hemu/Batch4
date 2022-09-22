package com.Hexaware.CMS.Factory;

import java.sql.Date;
import java.util.List;

import com.Hexaware.CMS.Model.OrderList;
import com.Hexaware.CMS.Persistence.OrderListDB;


public class OrderListFactory{

    
/**
Retrieve Customer Order History
@param custId customerId int
@return OrderList array
 */

public static OrderList[] getCustomerHistory(int cust_Id){
    List<OrderList> list =  OrderListDB.customerHistory(cust_Id);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}


/**
Retrieve Vendor Order History
@param vendor_Id vendor_Id int
@return OrderList array
 */

public static OrderList[] getVendorHistory(int vendor_Id){
    List<OrderList> list =  OrderListDB.vendorHistory(vendor_Id);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}

/**
Retrieve Current Pending  Order for Customer
@param custId customerId int
@return OrderList array
 */

public static OrderList[] getPendingOrdersC(int cust_Id){
    List<OrderList> list =  OrderListDB.pendingOrdersC(cust_Id);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}

/**
Retrieve Current Pending Orders for Vendor
@param vendorId vendorId int
@return OrderList array
 */

public static OrderList[] getPendingOrdersV(int vendor_Id){
    List<OrderList> list =  OrderListDB.pendingOrdersV(vendor_Id);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}

/**
Retrieve Order Details
*@param id orderId int
*@return OrderList object  */

public static OrderList getOrderDetails(int id){
    OrderList order = OrderListDB.orderDetails(id);
    return order;
}


 /**
   * to add new Order Details
   * @param custId customerId int
   * @param tot totalPrice double
   * @param foodCode foodCode int
   * @param date orderDate Date
   * @param qty quantity int
   * @param vId vendorId int
   * @param stat status String
   * @return int
   */

    
    public static int completeFoodOrder(int cust_Id,double total_Price,int foodCode,Date order_Date,String stat,int vId,int qty){
        int r = OrderListDB.completeFoodOrder(cust_Id,total_Price,foodCode,order_Date,stat,vId,qty);
        return r;
    }






   public static int updateOrderStatus(int order_Id,String stat){
   int r=OrderListDB.updateOrderStatus(order_Id,stat);
   return r;
   }

   /**
  List all Pending and Complete Orders for Current Day for Customer
  *@param custId customerId int
  *@return OrderList array
  */

  public static OrderList[] listAllOrdersForToday(int cust_Id){
      List <OrderList> list  =OrderListDB.listAllOrdersForToday(cust_Id);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList; 
  }



}