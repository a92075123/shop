package com.example.shop.common;


import lombok.Data;

@Data
public class GlobalException extends RuntimeException{
    // 帶訊息的建構子
    public GlobalException(String message) {
        super(message);
    }
}
