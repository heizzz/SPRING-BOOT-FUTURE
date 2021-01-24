package com.blibli.cashier.controller.request;

import com.blibli.cashier.entity.Customer;
import com.blibli.cashier.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class InsertOrderRequest {
    private Customer customer;
    private List<OrderItem> orderItemList;
}
