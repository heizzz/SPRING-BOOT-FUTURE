package com.blibli.cashier.controller.response;

import com.blibli.cashier.entity.Order;
import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class GetOrderIdResponse {
    private Order order;
}
