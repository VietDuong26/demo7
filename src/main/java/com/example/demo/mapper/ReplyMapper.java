package com.example.demo.mapper;

import com.example.demo.dto.ReplyDto;
import com.example.demo.entity.Reply;
import com.example.demo.model.ReplyModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyMapper {
    @Autowired
    UserService userService;
    public ReplyDto toDto(Reply reply){
        return ReplyDto.builder()
                .id(reply.getId())
                .comment_id(reply.getComment_id())
                .user_id(userService.findById(reply.getUser_id()))
                .tag_user_id(userService.findById(reply.getTag_user_id()))
                .content(reply.getContent())
                .createdDate(reply.getCreatedDate())
                .time(reply.getTime())
                .build();
    }
    public Reply toEntity(ReplyModel model){
        return Reply.builder()
                .comment_id(model.getComment_id())
                .user_id(model.getUser_id())
                .tag_user_id(model.getTag_user_id())
                .content(model.getContent())
                .createdDate(model.getCreatedDate())
                .time(model.getTime())
                .build();
    }
}
