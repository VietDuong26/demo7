package com.example.demo.repository.impl;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CommentRepositoryImplement implements CommentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Comment> getAll() {
        return jdbcTemplate.query("select * from comment", new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Comment(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getTime(6).toString());
            }
        });
    }

    @Override
    public int add(Comment comment) {
        return jdbcTemplate.update("insert into comment(id_user,id_post,content,createdDate,time) value(?,?,?,?,?)",comment.getUser_id(),comment.getPost_id(), comment.getContent(),comment.getCreatedDate(),comment.getTime());
    }

    @Override
    public int update(Comment comment) {
        return jdbcTemplate.update("update comment set content=?,createdDate=?, time=? where id=?", comment.getContent(),comment.getCreatedDate(),comment.getTime(),comment.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from comment where id=?",id);
    }

    @Override
    public List<Comment> getAllByPost(int postId) {
        return jdbcTemplate.query("select * from comment where id_post=? order by time asc", new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Comment(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getTime(6).toString());
            }
        },postId);
    }
}
