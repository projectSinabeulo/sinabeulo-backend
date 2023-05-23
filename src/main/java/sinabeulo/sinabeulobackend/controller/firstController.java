package sinabeulo.sinabeulobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sinabeulo.sinabeulobackend.service.firstService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class firstController {

    private final firstService firstService;

//    @Autowired
//    public void firstServiceImpl() {
//        firstServiceImpl(null);
//    }

//    @Autowired
//    public void firstServiceImpl(firstService firstService) {
//        this.firstService = firstService;
//    }

    @GetMapping("/first")
    public Map<String, Object> firstController() {
        return firstService.getFirstData();
    }
}