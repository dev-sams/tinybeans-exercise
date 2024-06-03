package com.tinybeans.backend.evaluation.controller;

import com.tinybeans.backend.evaluation.dto.OrderRequestDTO;
import com.tinybeans.backend.evaluation.dto.OrderResponseDTO;
import com.tinybeans.backend.evaluation.dto.ResponseDTO;
import com.tinybeans.backend.evaluation.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseDTO<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
}
