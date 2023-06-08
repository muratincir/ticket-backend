package com.ahabilet.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisteredPassengerRequest {

    private long userId;
    private long genderId;
    private LocalDate birthDate;
    private String fullName;


}
