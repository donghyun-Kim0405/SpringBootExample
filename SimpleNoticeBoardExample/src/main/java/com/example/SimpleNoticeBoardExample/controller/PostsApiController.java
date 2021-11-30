package com.example.SimpleNoticeBoardExample.controller;


import com.example.SimpleNoticeBoardExample.service.posts.PostsService;
import com.example.SimpleNoticeBoardExample.web.dto.PostsResponseDto;
import com.example.SimpleNoticeBoardExample.web.dto.PostsSaveRequestDto;
import com.example.SimpleNoticeBoardExample.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    // 서비스 객체 생성 -> Bean 의존성 주입 from lombook
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save (@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);   //service에 저장 요청
    }

    @PutMapping("/api/v1/posts/{id}")   // put vs post => 멱등성의 차이 (이 메서드를 여러번 호출할 경우 클라이언트가 받는 응답은 동일하다)
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto); // posts service에 update를 요청한 결과를 client에 반환
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}