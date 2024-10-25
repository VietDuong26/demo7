package com.example.demo.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CommentDto {
    private int id;
    private UserDto user;
    private int post_id;
    private String content;
    private String createdDate;
    private String time;
    private List<ReplyDto> listReply;
}
