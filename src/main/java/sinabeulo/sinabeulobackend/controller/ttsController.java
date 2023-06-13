package sinabeulo.sinabeulobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinabeulo.sinabeulobackend.service.sttWavService;
import sinabeulo.sinabeulobackend.service.ttsStartService;

import java.io.IOException;


//@RestController
//@RequestMapping("/tts")
//@RequiredArgsConstructor
@RestController
public class ttsController {

    //sttStartService
    @GetMapping("tts")
    public void googletts() {
//        System.out.print("stt sample");
        ttsStartService.quickSample();

    }
}
