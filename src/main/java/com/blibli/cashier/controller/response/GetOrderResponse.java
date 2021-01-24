package com.blibli.cashier.controller.response;

import com.blibli.cashier.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class GetOrderResponse {
    private List<Order> orderList;
}
