package com.example.AlgoCampEcom.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private Integer status;
    private String message;
    private LocalDateTime timestamp;
}
