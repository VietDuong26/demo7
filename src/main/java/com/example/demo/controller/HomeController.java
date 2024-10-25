package com.example.demo.controller;

import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    PostService postService;
    @GetMapping("/index")
    String index(Model model){
        model.addAttribute("posts",postService.getNewestPost());
        return "index";
    }
    @GetMapping("/post_detail")
    String post_detail(Model model, @RequestParam("id")int id){
        model.addAttribute("slt_post",postService.findById(id));
        return "post_detail";
    }
}
