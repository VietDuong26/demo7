package com.example.demo.repository;

import com.example.demo.dto.ReplyDto;
import com.example.demo.entity.Reply;
import com.example.demo.model.ReplyModel;
import com.example.demo.service.BaseService;

import java.util.List;

public interface ReplyRepository extends BaseRepository<Reply> {
    List<Reply> getAllByComment(int commentId);
}
