package sinabeulo.sinabeulobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sinabeulo.sinabeulobackend.model.dto.TestUserInfoDto;
import sinabeulo.sinabeulobackend.service.TestService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/name")
    ResponseEntity<?> getHelloWorld(@RequestParam(required = false) String name){
        return new ResponseEntity<>(testService.myName(name), HttpStatus.OK);
    }

    @PostMapping("/age/{age}")
    ResponseEntity<?> postHelloWorld(@PathVariable("age") Integer age){
        return new ResponseEntity<>(testService.myAge(age),HttpStatus.OK);
    }

    @PutMapping("/info")
    ResponseEntity<?> putHelloWorld(@RequestBody TestUserInfoDto userInfoDto){
        return new ResponseEntity<>(testService.myInfo(userInfoDto),HttpStatus.OK);
    }

    @DeleteMapping("/name")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader String address, @RequestBody TestUserInfoDto userInfoDto){
        return new ResponseEntity<>(testService.myInfoWithaddress(address, userInfoDto),HttpStatus.OK);
    }
}
