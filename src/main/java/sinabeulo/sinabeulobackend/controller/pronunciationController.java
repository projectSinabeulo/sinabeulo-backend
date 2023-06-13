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

    @PostMapping("/pronunn")
    public String postInfo(@RequestBody WordDto wordDto) throws IOException, URISyntaxException {
        String result = pronunciationService.trans(wordDto.getWord());
        return result;

//        return name + "hello!";
    }


}
