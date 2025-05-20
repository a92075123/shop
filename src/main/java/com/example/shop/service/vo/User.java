package com.example.shop.service.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime createdAt;
}
