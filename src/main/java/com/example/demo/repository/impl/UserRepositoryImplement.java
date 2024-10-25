package com.example.demo.repository.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserRepositoryImplement implements UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select * from user",new RowMapper<User>(){

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        });
    }

    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into user(username,password) value(?,?)",user.getUsername(),user.getPassword());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update user set username=?,password=? where id=?",user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from user where id=?",id);
    }

    @Override
    public User findById(int id) {
        return jdbcTemplate.query("select * from user where id=?",new RowMapper<User>(){

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        },id).get(0);
    }
}
