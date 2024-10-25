package com.example.demo.service;

import com.example.demo.dto.CommentDto;
import com.example.demo.model.CommentModel;

import java.util.List;

public interface CommentService extends BaseService<CommentDto, CommentModel>{
    List<CommentDto> getAllByPost(int postId);
}
