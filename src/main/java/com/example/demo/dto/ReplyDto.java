package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReplyDto {
    private int id;
    private int comment_id;
    private UserDto user_id;
    private UserDto tag_user_id;
    private String content;
    private String createdDate;
    private String time;
}
