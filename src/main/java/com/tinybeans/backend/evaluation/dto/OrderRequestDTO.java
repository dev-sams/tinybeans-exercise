package com.tinybeans.backend.evaluation.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private List<ItemDTO> items;
    private double totalAmount;
}
