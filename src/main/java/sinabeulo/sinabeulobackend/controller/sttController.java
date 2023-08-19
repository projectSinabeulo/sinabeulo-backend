package sinabeulo.sinabeulobackend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sinabeulo.sinabeulobackend.service.sttWavService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class sttController {

    //stt api with post word
    @PostMapping("/stt")
    public String SttGetByte(@RequestBody MultipartFile file) throws IOException {

        //입력값이 없을 때 예외 처리
        if (file.isEmpty()) {
            return "File is empty";
        }

        try {
            byte[] fileData = file.getBytes();

            // Your code here
            String stttext = sttWavService.sttWav(fileData);

            return stttext;
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }


}
