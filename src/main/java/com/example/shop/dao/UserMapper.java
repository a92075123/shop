package com.example.shop.dao;

import com.example.shop.service.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUsers();
    User getUserById(String username);
}
