package sinabeulo.sinabeulobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sinabeulo.sinabeulobackend.service.secondService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class secondController {

    private final secondService secondService;

    @PostMapping("/second")
    public String postInfo(@RequestParam String name) throws IOException, URISyntaxException {
        String result = secondService.trans(name);
        return result;

        //todo. post man에 가서 localhost~~//second를 했을 때 console에 result값만 뜨는지 확인하기

//        return name + "hello!";
    }



//코드 참고용
//    @GetMapping("/first")
//    public Map<String, Object> firstController() {
//        return firstService.getFirstData();
//    }

//    @PostMapping("/name")
//    ResponseEntity<?> postHelloWorld(@PathVariable("name") String name){
//        return new ResponseEntity<>(testService.myName(name), HttpStatus.OK);
//    }

}
