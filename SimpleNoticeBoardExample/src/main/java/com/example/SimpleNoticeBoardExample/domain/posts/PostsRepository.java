package com.example.SimpleNoticeBoardExample.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaREpository 상속 받을경우 기본적인 db접근 메서드 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //자동으로 생성되지 않은 쿼리의 경우 직접 작성 가능
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
