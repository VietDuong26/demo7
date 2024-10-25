package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserDto> getAll() {
        return userRepository.getAll().stream().map(x->userMapper.toDto(x)).collect(Collectors.toList());
    }

    @Override
    public int add(UserModel model) {
        return userRepository.add(userMapper.toEntity(model));
    }

    @Override
    public int update(int id, UserModel model) {
        return userRepository.update(new User(id, model.getUsername(), model.getPassword()));
    }

    @Override
    public int delete(int id) {
        return userRepository.delete(id);
    }

    @Override
    public UserDto findById(int id) {
        return userMapper.toDto(userRepository.findById(id));
    }
}
