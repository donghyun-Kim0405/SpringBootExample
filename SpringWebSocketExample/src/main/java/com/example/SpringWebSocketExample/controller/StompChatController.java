package com.example.SpringWebSocketExample.controller;


import com.example.SpringWebSocketExample.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompChatController {
    private final SimpMessagingTemplate template;

    //clinet send 경로 -> config에서 설정한 applicationDestinationPrefixes 와 @MessageMapping 경로 병합
    @MessageMapping(value ="/chat/enter")       //client에서 prefix를 붙여 /pub/chat/enter 요청 -> Controller는 /sub/chat/chat/room/roomId로 전송
    public void enter(ChatMessageDto newMessage){
        newMessage.setMessage(newMessage.getWriter()+"님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/sub/chat/room/"+newMessage.getRoomId(), newMessage);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDto newMessage){

        template.convertAndSend("/sub/chat/room"+newMessage.getRoomId(), newMessage);
    }

}
