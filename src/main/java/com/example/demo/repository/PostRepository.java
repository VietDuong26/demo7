package com.example.demo.repository;

import com.example.demo.dto.PostDto;
import com.example.demo.entity.Post;

import java.util.List;

public interface PostRepository extends BaseRepository<Post>{
    Post findById(int id);

    List<Post> findNewestPost();
    List<Post> findPostByPage(int page);
}
