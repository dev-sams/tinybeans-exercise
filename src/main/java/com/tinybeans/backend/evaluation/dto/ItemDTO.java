package com.tinybeans.backend.evaluation.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String name, description, photoUrl;
    private Double price;
    private int quantity;
}
