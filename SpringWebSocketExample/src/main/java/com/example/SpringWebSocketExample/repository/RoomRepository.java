package com.example.SpringWebSocketExample.repository;


import com.example.SpringWebSocketExample.dto.RoomDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class RoomRepository {

    private Map<String, RoomDto> roomDtoMap;




    @PostConstruct  //의존성 주입이 이루어진후 초기화 수
    private void init(){
        roomDtoMap = new LinkedHashMap<>();

    }

    public List<RoomDto> createRoomDto(String nameOfRoom){
        RoomDto room = RoomDto.create(nameOfRoom);
        roomDtoMap.put(room.getName(), room);   //방이름으로 방찾기

        List<RoomDto> roomList = new ArrayList<>(roomDtoMap.values());
        Collections.reverse(roomList);

        return roomList;
    }

    public List<RoomDto> findAllRooms(){
        List<RoomDto> roomList = new ArrayList<>(roomDtoMap.values());
        Collections.reverse(roomList);
        return roomList;
    }

    public RoomDto findRoomByName(String name){
        RoomDto room = roomDtoMap.get(name);
        return room;
    }

}
