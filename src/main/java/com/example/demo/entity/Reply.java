package com.example.demo.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reply {
    private int id;
    private int comment_id;
    private int user_id;
    private int tag_user_id;
    private String content;
    private String createdDate;
    private String time;
}
