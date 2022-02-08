package com.example.ImageRoutingAPIExample;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/api/image")
public class APIController {

    @GetMapping("/getImage")
    public ResponseEntity<FileSystemResource> download() throws IOException {

        String savePath = System.getProperty("user.dir") + "/files/lenna.jpg";

        Path path = Paths.get(savePath);

        String contentType = Files.probeContentType(path);

        FileSystemResource resource = new FileSystemResource(savePath);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", contentType);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}



