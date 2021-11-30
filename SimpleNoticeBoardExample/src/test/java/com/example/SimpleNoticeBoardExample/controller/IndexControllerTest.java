package com.example.SimpleNoticeBoardExample.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    //URL호출시 페이지의 내용이 제대로 호출되는지에 대한 테스트 수행
    @Test
    public void load_indexPage(){
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("Start!! SpringBoot WebService");

    }
}
