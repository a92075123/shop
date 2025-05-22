package com.example.shop.service;

import com.example.shop.common.AjaxResult;
import com.example.shop.common.GlobalException;
import com.example.shop.dao.UserMapper;
import com.example.shop.dto.UserDto;
import com.example.shop.filter.CustomFilter;
import com.example.shop.service.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserMapper userMapper;
    private final HttpServletRequest request;


    public AjaxResult checkUser(UserDto data) throws IOException {
        User userById = userMapper.getUserById(data.getUsername());
        if (userById == null){
            throw new GlobalException("帳號或密碼錯誤");
        }else{
            //記住session
            HttpSession session = request.getSession();
            session.setAttribute("loginStatus","true");
            Map map =new HashMap<>();
            map.put("url",CustomFilter.targetPage != null ? CustomFilter.targetPage : "/index");
            // 回傳跳轉 URL 給前端
            return AjaxResult.success("success", map);
        }
    }
}
