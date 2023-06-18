package sinabeulo.sinabeulobackend.controller;


import com.google.auth.oauth2.GoogleCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sinabeulo.sinabeulobackend.service.sttWavService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
//@RequestMapping("/stt")
@RequiredArgsConstructor
public class sttController {

    @PostMapping("/stt")
    public String uploadFormPost(@RequestBody MultipartFile file) throws IOException {

        //byte[]로 받기
//        @RequestBody MultipartFile file

        //Wav file로 받기
//        @RequestParam(value = "file", required = false) MultipartFile file

        if (file.isEmpty()) {
            return "File is empty";
        }

        try {
            // Process the file (e.g., save it to a location or perform operations)
            // For example, you can save the file using file.getBytes() or perform any required processing
            byte[] fileData = file.getBytes();

            // Your code here
            String stttext = sttWavService.sttWav2(fileData);

            return stttext;
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }


}
