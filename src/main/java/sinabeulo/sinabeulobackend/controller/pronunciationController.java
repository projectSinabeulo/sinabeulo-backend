package sinabeulo.sinabeulobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sinabeulo.sinabeulobackend.model.dto.WordDto;
import sinabeulo.sinabeulobackend.service.pronunciationService;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class pronunciationController {

    private final pronunciationService pronunciationService;

    //WordDto 해당 데이터 타입 객체를 통해 data를 받아 표준 발음 변환기 호출 함수 실행
    @PostMapping("/pronunn")
    public String postInfo(@RequestBody WordDto wordDto) throws IOException, URISyntaxException {
        String result = pronunciationService.trans(wordDto.getWord());
        return result;
    }


}
