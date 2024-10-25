package com.example.demo.service;

import com.example.demo.dto.ReplyDto;
import com.example.demo.model.ReplyModel;

import java.util.List;

public interface ReplyService extends BaseService<ReplyDto, ReplyModel> {
    List<ReplyDto> getAllByComment(int commentId);
}
