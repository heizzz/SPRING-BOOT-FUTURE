package com.blibli.cashier.service;

import com.blibli.cashier.controller.request.InsertOrderRequest;
import com.blibli.cashier.entity.Order;

import java.util.List;

public interface CashierService {
    void insertOrder(InsertOrderRequest insertOrderRequest);
    List<Order> getOrder();
    Order getOrderById(int i);
}
