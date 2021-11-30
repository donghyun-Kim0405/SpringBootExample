package com.example.SimpleNoticeBoardExample.web.dto;


import com.example.SimpleNoticeBoardExample.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        Posts postsEntity = Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
        return postsEntity;
    }
}
