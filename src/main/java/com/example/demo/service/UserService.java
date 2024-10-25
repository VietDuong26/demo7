package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.model.UserModel;

public interface UserService extends BaseService<UserDto, UserModel> {
    UserDto findById(int id);
}
