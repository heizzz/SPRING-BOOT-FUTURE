package com.blibli.cashier.service.impl;

import com.blibli.cashier.controller.request.InsertOrderRequest;
import com.blibli.cashier.entity.Order;
import com.blibli.cashier.entity.OrderItem;
import com.blibli.cashier.service.CashierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    private int id = 0;

    private List<Order> orderList = new ArrayList<>();

    @Override
    public void insertOrder(InsertOrderRequest insertOrderRequest){
        int total = 0;
        for (OrderItem item : insertOrderRequest.getOrderItemList()){
            total +=(item.getPrice()*item.getQuantity());
        }
        Order order = Order
                .builder()
                .id(id++)
                .totalPrice(total)
                .customer(insertOrderRequest.getCustomer())
                .orderItems(insertOrderRequest.getOrderItemList())
                .build();
        for (int i =0; i<order.getOrderItems().toArray().length; i++){
            order.getOrderItems().get(i).setId(i);
        }

        orderList.add(order);
    }

    @Override
    public List<Order> getOrder() {
        return orderList;
    }

    @Override
    public Order getOrderById(int i) {
        return orderList.get(i);
    }


}
