package com.ahabilet.dto;

import lombok.Data;

@Data
public class PasswordUpdateRequest {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
