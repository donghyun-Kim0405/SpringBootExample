package com.example.SpringSecurityExample.controller;


import com.example.SpringSecurityExample.domain.dto.TestDto;
import com.example.SpringSecurityExample.service.UserService;
import com.example.SpringSecurityExample.domain.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody JoinDto joinDto){

        String responseMessage;

        try{
            responseMessage = userService.signup(joinDto);
        }catch(Exception e){
            responseMessage = e.getMessage();
        }
        return ResponseEntity.ok(responseMessage);
    }

    @PostMapping("/test")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> test(@RequestBody TestDto testDto){
        System.out.println(testDto.getMessage());

        return ResponseEntity.ok("Success");
    }


}
