package com.example.demo.repository;

import com.example.demo.dto.CommentDto;
import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment> {
    List<Comment> getAllByPost(int postId);
}
