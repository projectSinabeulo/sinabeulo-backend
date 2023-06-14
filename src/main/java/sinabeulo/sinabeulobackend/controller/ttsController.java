package sinabeulo.sinabeulobackend.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinabeulo.sinabeulobackend.service.sttWavService;
import sinabeulo.sinabeulobackend.service.ttsStartService;
import sinabeulo.sinabeulobackend.service.ttsWordService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


//@RestController
//@RequestMapping("/tts")
//@RequiredArgsConstructor
@RestController
public class ttsController {

   // ttsStartService
//    @GetMapping("tts")
//    public void googletts() {
////        System.out.print("tts quicksample");
//        ttsStartService.quickSample1();
//
//    }

    //ttsStartService with post word
    @PostMapping("tts")
    public void googlettspost(String words) {
//        System.out.print("tts quicksample");
        ttsWordService.ttsWords(words);

    }



    //tts Service return InputStreamResource!
//    @GetMapping("/tts")
//    public ResponseEntity<InputStreamResource> streamMp3File() {
//
//        return ttsStartService.quickSample2();
//    }



}
