package com.example.SpringWebSocketExample.controller;


import com.example.SpringWebSocketExample.dto.RoomDto;
import com.example.SpringWebSocketExample.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/room")
public class StompRoomController {

    private final RoomRepository roomRepository;


    @PostMapping("/create")
    public List<RoomDto> createRoom(@RequestBody RoomDto nameOfRoom){
        List<RoomDto> roomList = roomRepository.createRoomDto(nameOfRoom.getName());

        return roomList;
    }

    @PostMapping("/getAllRoom")
    public List<RoomDto> getAllRoom(@RequestBody RoomDto dtoFromAndroid){
        List<RoomDto> roomList = roomRepository.findAllRooms();
        return roomList;
    }

    @PostMapping("/findRoomIdByName")
    public RoomDto findRoomIdByName(@RequestBody RoomDto dtoFromAndroid){
        RoomDto room = roomRepository.findRoomByName(dtoFromAndroid.getName());
        return room;
    }
}

