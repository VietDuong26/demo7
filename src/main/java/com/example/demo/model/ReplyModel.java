package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReplyModel {
    private int comment_id;
    private int user_id;
    private int tag_user_id;
    private String content;
    private String createdDate;
    private String time;
}
