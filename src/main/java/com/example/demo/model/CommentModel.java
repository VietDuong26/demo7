package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CommentModel {
    private int user_id;
    private int post_id;
    private String content;
    private String createdDate;
    private String time;
}
