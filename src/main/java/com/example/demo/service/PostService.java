package com.example.demo.service;

import com.example.demo.dto.PostDto;
import com.example.demo.model.PostModel;

import java.util.List;

public interface PostService extends BaseService<PostDto, PostModel> {
    PostDto findById(int id);
    List<PostDto> getNewestPost();
    List<PostDto> findPostByPage(int page);
}
