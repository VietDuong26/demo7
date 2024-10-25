package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserModel {
    private String username;
    private String password;
}
