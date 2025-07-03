package com.example.Capstone.backend.exception;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiError {
    private String message;
    private LocalDate dataErrore;
}
