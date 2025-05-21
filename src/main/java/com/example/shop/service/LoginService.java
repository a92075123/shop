package com.example.shop.service;

import com.example.shop.common.AjaxResult;
import com.example.shop.common.GlobalException;
import com.example.shop.dao.UserMapper;
import com.example.shop.dto.UserDto;
import com.example.shop.service.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserMapper userMapper;
    private final HttpServletRequest request;

    public AjaxResult checkUser(UserDto data) {
        User userById = userMapper.getUserById(data.getUsername());
        if (userById == null){
            throw new GlobalException("帳號或密碼錯誤");
        }
        //記住session
        HttpSession session = request.getSession();
        session.setAttribute("loginStatus","true");
        return AjaxResult.success("success", null);
    }
}
