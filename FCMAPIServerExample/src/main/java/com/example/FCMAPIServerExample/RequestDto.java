package com.example.FCMAPIServerExample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class RequestDto {

    private String token;
    private String title;
    private String body;

}
