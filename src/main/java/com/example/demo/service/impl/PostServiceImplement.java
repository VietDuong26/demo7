package com.example.demo.service.impl;

import com.example.demo.dto.PostDto;
import com.example.demo.entity.Post;
import com.example.demo.mapper.PostMapper;
import com.example.demo.model.PostModel;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostServiceImplement implements PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostMapper mapper;
    @Override
    public List<PostDto> getAll() {
        return postRepository.getAll().stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }

    @Override
    public int add(PostModel model) {
        return postRepository.add(mapper.toEntity(model));
    }

    @Override
    public int update(int id, PostModel model) {
        return postRepository.update(new Post(id,model.getTitle(),model.getContent(),model.getCreatedDate()));
    }

    @Override
    public int delete(int id) {
        return postRepository.delete(id);
    }

    @Override
    public PostDto findById(int id) {
        return mapper.toDto(postRepository.findById(id));
    }

    @Override
    public List<PostDto> getNewestPost() {
        return postRepository.findNewestPost().stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findPostByPage(int page) {
        return postRepository.findPostByPage(page).stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }
}
