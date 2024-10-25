package com.example.demo.mapper;

import com.example.demo.dto.CommentDto;
import com.example.demo.entity.Comment;
import com.example.demo.model.CommentModel;
import com.example.demo.service.ReplyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class CommentMapper {
    @Autowired
    ReplyService replyService;
    @Autowired
    UserService userService;
    public CommentDto toDto(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .user(userService.findById(comment.getUser_id()))
                .post_id(comment.getPost_id())
                .content(comment.getContent())
                .createdDate(comment.getCreatedDate())
                .time(comment.getTime())
                .listReply(replyService.getAllByComment(comment.getId()))
                .build();
    }
    public Comment toEntity(CommentModel model){
        return Comment.builder()
                .user_id(model.getUser_id())
                .post_id(model.getPost_id())
                .content(model.getContent())
                .createdDate(model.getCreatedDate())
                .time(model.getTime())
                .build();
    }
}
