package com.tinybeans.backend.evaluation.service;

import com.tinybeans.backend.evaluation.dto.OrderRequestDTO;
import com.tinybeans.backend.evaluation.dto.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO createPayment(OrderRequestDTO orderRequestDTO);
}
