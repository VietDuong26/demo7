package com.example.demo.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Comment {
    private int id;
    private int user_id;
    private int post_id;
    private String content;
    private String createdDate;
    private String time;
}
