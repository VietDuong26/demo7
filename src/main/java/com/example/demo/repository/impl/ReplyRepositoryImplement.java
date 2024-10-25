package com.example.demo.repository.impl;

import com.example.demo.dto.ReplyDto;
import com.example.demo.entity.Reply;
import com.example.demo.model.ReplyModel;
import com.example.demo.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ReplyRepositoryImplement implements ReplyRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Reply> getAll() {
        return null;
    }

    @Override
    public int add(Reply reply) {
        return jdbcTemplate.update("insert into reply(comment_id,user_id,tag_user_id,content,createdDate,time) value(?,?,?,?,?,?)",reply.getComment_id(),reply.getUser_id(),reply.getTag_user_id(),reply.getContent(),reply.getCreatedDate(),reply.getTime());
    }

    @Override
    public int update(Reply reply) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Reply> getAllByComment(int commentId) {
        return jdbcTemplate.query("select * from reply where comment_id=?", new RowMapper<Reply>() {
            @Override
            public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Reply(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getTime(7).toString());
            }
        }, commentId);
    }
}
