package com.tinybeans.backend.evaluation.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> implements Serializable {
    private T data;
    private Integer statusCode;
    private String errorMessage;
}