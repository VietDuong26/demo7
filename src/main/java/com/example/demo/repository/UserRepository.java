package com.example.demo.repository;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

public interface UserRepository extends BaseRepository<User>{
    User findById(int id);
}
