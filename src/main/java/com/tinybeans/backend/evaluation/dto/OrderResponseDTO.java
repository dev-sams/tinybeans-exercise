package com.tinybeans.backend.evaluation.dto;

import lombok.Data;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private PaymentResponseDTO orderPayment;
}
