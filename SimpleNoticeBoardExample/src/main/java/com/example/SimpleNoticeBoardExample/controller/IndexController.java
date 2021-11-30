package com.example.SimpleNoticeBoardExample.controller;


import com.example.SimpleNoticeBoardExample.service.posts.PostsService;
import com.example.SimpleNoticeBoardExample.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {


    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("greet", "This is First Spring Boot Project");
        model.addAttribute("posts", postsService.findAllDesc());

        return "index";//mustache starter 로 인해 컨트롤러에서 문자열 반환하여도 경로와 확장자는 자동 지정

    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";

    }


}

