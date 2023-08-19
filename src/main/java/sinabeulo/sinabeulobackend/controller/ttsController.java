package sinabeulo.sinabeulobackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sinabeulo.sinabeulobackend.service.ttsWordService;


@RestController
public class ttsController {

    //tts api with post words
    @PostMapping("/tts")
    public byte[] googlettspost(String words) {
        byte[] ttsfile = ttsWordService.ttsWords(words);    //front에서 받은 words를 인자로 api 요청 함수 호출
        return ttsfile;
    }


}
