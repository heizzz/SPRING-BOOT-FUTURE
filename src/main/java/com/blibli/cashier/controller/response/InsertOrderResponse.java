package com.blibli.cashier.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class InsertOrderResponse {
    private String message;
}
