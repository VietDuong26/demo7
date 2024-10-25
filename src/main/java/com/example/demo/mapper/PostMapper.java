package com.example.demo.mapper;

import com.example.demo.dto.PostDto;
import com.example.demo.entity.Post;
import com.example.demo.model.PostModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    @Autowired
    CommentService commentService;
    public PostDto toDto(Post post){
        return PostDto.builder()
                .id(post.getId())
                .titile(post.getTitile())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .comments(commentService.getAllByPost(post.getId()))
                .build();
    }
    public Post toEntity(PostModel model){
        return Post.builder()
                .titile(model.getTitle())
                .content(model.getContent())
                .createdDate(model.getCreatedDate())
                .build();
    }
}
