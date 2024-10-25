package com.example.demo.controller;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.PostDto;
import com.example.demo.model.CommentModel;
import com.example.demo.model.PostModel;
import com.example.demo.model.ReplyModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import com.example.demo.service.ReplyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class HomeRestController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    ReplyService replyService;
    @PostMapping("/addNewPost")
    ResponseEntity<String> addNewPost(@ModelAttribute("post")PostModel model){
        postService.add(model);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }
    @PostMapping("/addNewComment")
    ResponseEntity<String> addNewComment(@RequestParam("postId")int postId,
    @RequestParam("userId")int userId,
    @RequestParam("content")String content){
        Date date=new Date();
        commentService.add(new CommentModel(userId,postId,content,String.valueOf(date.getYear()+"-"+date.getMonth()+"-"+date.getDate()),date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()));
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }
    @GetMapping("/getAllPost")
    List<PostDto> getAllPost(){
        return postService.getAll();
    }
    @PostMapping("/addNewUser")
    ResponseEntity<String> addNewUser(@ModelAttribute("user")UserModel model){
        userService.add(model);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }
    @GetMapping("/findPostById")
    PostDto findPostById(@RequestParam("id")int id){
        return postService.findById(id);
    }
    @PostMapping("/addNewReply")
    ResponseEntity<String> addNewReply(@ModelAttribute("reply")ReplyModel model){
        replyService.add(model);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }
    @GetMapping("/getMorePost")
    List<PostDto> getMorePost(@RequestParam("page")int page){
        return postService.findPostByPage(page);
    }
    @GetMapping("/getAllCommentByPost")
    List<CommentDto> getAllCommentByPost(@RequestParam("postId")int postId){
        List<CommentDto> list=commentService.getAllByPost(postId);
        return list;
    }
}
