package com.example.SimpleNoticeBoardExample.service.posts;

import com.example.SimpleNoticeBoardExample.domain.posts.Posts;
import com.example.SimpleNoticeBoardExample.domain.posts.PostsRepository;
import com.example.SimpleNoticeBoardExample.web.dto.PostsListResponseDto;
import com.example.SimpleNoticeBoardExample.web.dto.PostsResponseDto;
import com.example.SimpleNoticeBoardExample.web.dto.PostsSaveRequestDto;
import com.example.SimpleNoticeBoardExample.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @javax.transaction.Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        Long id;
        id = postsRepository.save(requestDto.toEntity()).getId();   //repository 에 save 요청하고 아이디값 얻어서 return
        return id;
    }

    @javax.transaction.Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. "));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다."));

        return new PostsResponseDto(entity);
    }


    //조회 기능만 남겨두어 조회속도 개선시키기
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());

    }

    @org.springframework.transaction.annotation.Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }



}
