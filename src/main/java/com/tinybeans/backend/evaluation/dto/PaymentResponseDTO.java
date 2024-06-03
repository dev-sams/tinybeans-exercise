package com.tinybeans.backend.evaluation.dto;

import lombok.Data;

@Data
public class PaymentResponseDTO {
    private String paymentUrl;
    private String paymentId;
    private String paymentStatus;
}
