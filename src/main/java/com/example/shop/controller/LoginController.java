package com.example.shop.controller;

import com.example.shop.common.AjaxResult;
import com.example.shop.dto.UserDto;
import com.example.shop.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 回傳登入畫面
     * @return
     */
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("/login");
        return mv;
    }

    /**
     * 處理帳號驗證
     * @return
     */
    @PostMapping("isCheckUser")
    public AjaxResult isCheckUser(@RequestBody UserDto request) {
        return loginService.checkUser(request);
    }
}
