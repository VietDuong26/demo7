package com.example.demo.service.impl;

import com.example.demo.dto.ReplyDto;
import com.example.demo.mapper.ReplyMapper;
import com.example.demo.model.ReplyModel;
import com.example.demo.repository.ReplyRepository;
import com.example.demo.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReplyServiceImplement implements ReplyService {
    @Autowired
    ReplyMapper mapper;
    @Autowired
    ReplyRepository  repository;
    @Override
    public List<ReplyDto> getAllByComment(int commentId) {
        return repository.getAllByComment(commentId).stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }

    @Override
    public List<ReplyDto> getAll() {
        return null;
    }

    @Override
    public int add(ReplyModel replyModel) {
        return repository.add(mapper.toEntity(replyModel));
    }

    @Override
    public int update(int id, ReplyModel replyModel) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
