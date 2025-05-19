package com.shwephoo.joystay_api.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
public class LoginRequest {
    private String username;
    private String password;
}
