package sinabeulo.sinabeulobackend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sinabeulo.sinabeulobackend.service.sttWavService;

import java.io.IOException;

@RestController
@RequestMapping("/stt")
@RequiredArgsConstructor
public class sttController {

    //sttStartService
//    @GetMapping("stt")
//    public String googlestt() {
////        System.out.print("stt sample");
//        String stttext = sttStartService.quickSample();
//        return stttext;
//    }

    //sttService.sttrequest()
//    @PostMapping("/json")
//    ResponseEntity<?> postgooglestt(@RequestBody sttDto sttDto) throws IOException {
//        return new ResponseEntity<>(sttService.sttrequest(sttDto), HttpStatus.OK);
//    }

    //wav try Post
//    @PostMapping()
//    ResponseEntity<?> wavgooglestt(@RequestBody sttDto sttDto) throws IOException {
//        return new ResponseEntity<>(sttService.sttrequest(sttDto), HttpStatus.OK);
//    }

    //wav try Get - success!!
    @GetMapping()
    public String googlestt() throws IOException {
        System.out.print("stt wav sample\n");
        String stttext = sttWavService.sttWav1();
//        String stttext = sttStartService.quickSample();
        return stttext;
    }

//    @RequestMapping(value = "/play/audio")
//    public void wavdownloadstt(HttpServletResponse response) {
//        byte[] wav = audioFile; // 업로드한 wav 파일 불러와서 담기
//        response.addHeader("Content-type", "attachment;filename=temp.wav");
//        response.setContentType("audio/wav");
//        response.setHeader("Content-Length", String.valueOf(wav.length));
//        response.getOutputStream().write(wav);
//        response.flushBuffer();
//    }





}
