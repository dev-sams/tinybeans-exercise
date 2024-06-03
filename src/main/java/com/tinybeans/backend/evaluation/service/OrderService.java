package com.tinybeans.backend.evaluation.service;

import com.tinybeans.backend.evaluation.dto.OrderRequestDTO;
import com.tinybeans.backend.evaluation.dto.OrderResponseDTO;
import com.tinybeans.backend.evaluation.dto.ResponseDTO;

public interface OrderService {
    ResponseDTO<OrderResponseDTO> createOrder(OrderRequestDTO orderRequestDTO);
}
