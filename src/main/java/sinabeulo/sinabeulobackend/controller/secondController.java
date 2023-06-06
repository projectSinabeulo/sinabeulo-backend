package sinabeulo.sinabeulobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sinabeulo.sinabeulobackend.model.dto.WordDto;
import sinabeulo.sinabeulobackend.service.secondService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class secondController {

    private final secondService secondService;

    @PostMapping("/second")
    public String postInfo(@RequestBody WordDto wordDto) throws IOException, URISyntaxException {
        String result = secondService.trans(wordDto.getWord());
        return result;

//        return name + "hello!";
    }


}
