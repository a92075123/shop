package com.example.shop.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 處理共用異常
    @ExceptionHandler(GlobalException.class)
    public AjaxResult handleResourceNotFoundException(GlobalException ex) {
        return AjaxResult.error(ex.getMessage(), null);
    }
}
