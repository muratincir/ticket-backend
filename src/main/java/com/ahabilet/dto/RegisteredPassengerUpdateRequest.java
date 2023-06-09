package com.ahabilet.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisteredPassengerUpdateRequest {
    private long genderId;
    private LocalDate birthDate;
    private String fullName;

}
