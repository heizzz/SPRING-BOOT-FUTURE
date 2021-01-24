package com.blibli.cashier.controller;

import com.blibli.cashier.controller.request.InsertOrderRequest;
import com.blibli.cashier.controller.response.GetOrderIdResponse;
import com.blibli.cashier.controller.response.GetOrderResponse;
import com.blibli.cashier.controller.response.InsertOrderResponse;
import com.blibli.cashier.entity.Order;
import com.blibli.cashier.service.CashierService;
import com.blibli.cashier.service.impl.CashierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class CashierController {

    @Autowired
    private CashierServiceImpl cashierService;

    @GetMapping(value = "/orders")
    public GetOrderResponse getOrder(
            @RequestParam(value = "orderByCustomer", defaultValue = "false") String orderByCustomer,
            @RequestParam(value = "orderByPrice", defaultValue = "false") String orderByPrice
    ){
        List<Order> orderList =  cashierService.getOrder();

        if (orderByCustomer.equals("true")){
            orderList.sort(Comparator.comparing(a -> a.getCustomer().getName()));
        }

        if (orderByPrice.equals("true")){
            orderList.sort(Comparator.comparing(Order::getTotalPrice).reversed());
        }
        return GetOrderResponse
                .builder()
                .orderList(orderList)
                .build();
    }

    @GetMapping(value = "/orders/{orderId}")
    public GetOrderIdResponse getOrderById(@PathVariable int orderId){
        Order order =  cashierService.getOrderById(orderId);
        return GetOrderIdResponse
                .builder()
                .order(order)
                .build();
    }

    @PostMapping(value = "/orders")
    public InsertOrderResponse createOrder(@RequestBody InsertOrderRequest insertOrderRequest) {
        cashierService.insertOrder(insertOrderRequest);
        return InsertOrderResponse
                .builder()
                .message("Success")
                .build();
    }
}
