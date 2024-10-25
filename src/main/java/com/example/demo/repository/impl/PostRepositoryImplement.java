package com.example.demo.repository.impl;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class PostRepositoryImplement implements PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Post> getAll() {
        return jdbcTemplate.query("select * from post order by createdDate desc", new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Post(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        });
    }

    @Override
    public int add(Post post) {
        return jdbcTemplate.update("insert into post(title,content,createdDate) value(?,?,?)",post.getTitile(),post.getContent(),post.getCreatedDate());
    }

    @Override
    public int update(Post post) {
        return jdbcTemplate.update("update post set title=?,content=?,createdDate=? where id=?",post.getTitile(),post.getContent(),post.getCreatedDate());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from post where id=?",id);
    }

    @Override
    public Post findById(int id) {
        return jdbcTemplate.query("select * from post where id=?",new RowMapper<Post>(){

            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Post(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        },id).get(0);
    }

    @Override
    public List<Post> findNewestPost() {
        return jdbcTemplate.query("select * from post order by createdDate desc limit 3", new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Post(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        });
    }

    @Override
    public List<Post> findPostByPage(int page) {
        return jdbcTemplate.query("select * from post limit ? offset ?", new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Post(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        },3*(page+1),3*page);
    }
}
