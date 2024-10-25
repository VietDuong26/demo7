package com.example.demo.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Post {
    private int id;
    private String titile;
    private String content;
    private String createdDate;
}
