package order;

import java.util.ArrayList;
import java.util.List;

public class OrderCreator {
    private int nextOrderNumber;
    private List<Order> orderList;

    public OrderCreator(){
        this.nextOrderNumber=0;
        orderList=new ArrayList<>();
    }

    public void createNewOrder(Order order){
        orderList.add(order);
        nextOrderNumber+=1;
        order.orderNumber=nextOrderNumber;
    }
}
