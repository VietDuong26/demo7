package com.example.demo.service.impl;

import com.example.demo.dto.CommentDto;
import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.CommentModel;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentServiceImplement implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CommentMapper mapper;
    @Override
    public List<CommentDto> getAll() {
        return commentRepository.getAll().stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }

    @Override
    public int add(CommentModel commentModel) {
        return commentRepository.add(mapper.toEntity(commentModel));
    }

    @Override
    public int update(int id,CommentModel commentModel) {
        return commentRepository.update(new Comment(id,commentModel.getUser_id(),commentModel.getPost_id(), commentModel.getContent(), commentModel.getCreatedDate(), commentModel.getTime()));
    }

    @Override
    public int delete(int id) {
        return commentRepository.delete(id);
    }

    @Override
    public List<CommentDto> getAllByPost(int postId) {
        return commentRepository.getAllByPost(postId).stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }
}
