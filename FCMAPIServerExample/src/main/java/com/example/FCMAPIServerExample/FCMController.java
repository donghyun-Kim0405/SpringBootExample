package com.example.FCMAPIServerExample;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FCMController {

    private final FCMService fcmService;

    @PostMapping("/api/fcm")
    public ResponseEntity pushMessage(@RequestBody RequestDto dto) throws IOException {
        System.out.println(dto.getToken() + " "
                +dto.getTitle() + " " + dto.getBody());

        fcmService.sendMessageTo(
                dto.getToken(),
                dto.getTitle(),
                dto.getBody()
        );

        return ResponseEntity.ok().build();
    } //pushMessage

}
