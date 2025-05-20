package com.example.shop.service;

import com.example.shop.common.AjaxResult;
import com.example.shop.common.GlobalException;
import com.example.shop.dao.UserMapper;
import com.example.shop.dto.UserDto;
import com.example.shop.service.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserMapper userMapper;

    public AjaxResult checkUser(UserDto request) {
        User userById = userMapper.getUserById(request.getUsername());
        if (userById == null){
            throw new GlobalException("帳號或密碼錯誤");
        }
        //記住session
        return new AjaxResult(200, "success", null);
    }

}
