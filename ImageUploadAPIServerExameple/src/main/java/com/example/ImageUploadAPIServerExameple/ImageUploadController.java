package com.example.ImageUploadAPIServerExameple;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class ImageUploadController {

    @PostMapping("/uploadImage")
    public ResponseEntity<String> authorize(@RequestParam("image") MultipartFile files) {
        String responseMessage = "ok";

        try {
            String origFilename = files.getOriginalFilename();
            String filename = origFilename.toString();

            //savePath -> 현재 프로젝트 폴더내 존재하는 files폴더의 경로
            String savePath = System.getProperty("user.dir") + "/files";

            // /files폴더가 존재하지 않으면 생성
            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }

            //   현재프로젝트경로/files/filename   ->  filename == (androdi)fileName 변수
            String filePath = savePath + "/" + filename;

            // 파일 저장
            files.transferTo(new File(filePath));

        } catch(Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(responseMessage);
    }// image upload


    @PostMapping("/uploadString")
    public ResponseEntity<String> textController(@RequestParam("testData") String testData) {
        String responseMessage = "ok";

        System.out.println(testData);



        return ResponseEntity.ok(responseMessage);
    }




}
