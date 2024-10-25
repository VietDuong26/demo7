package com.example.demo.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostDto {
    private int id;
    private String titile;
    private String content;
    private String createdDate;
    private List<CommentDto> comments;
}
