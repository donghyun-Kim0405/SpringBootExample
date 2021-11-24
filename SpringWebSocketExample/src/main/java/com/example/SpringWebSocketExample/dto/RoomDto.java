package com.example.SpringWebSocketExample.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class RoomDto {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    public static RoomDto create(String name){
        RoomDto room = new RoomDto();
        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }




}
