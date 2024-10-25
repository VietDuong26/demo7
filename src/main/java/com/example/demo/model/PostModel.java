package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PostModel {
    private String title;
    private String content;
    private String createdDate;
}
