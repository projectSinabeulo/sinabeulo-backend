package sinabeulo.sinabeulobackend.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sinabeulo.sinabeulobackend.service.OauthService;

import java.io.IOException;

@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class OauthController {

    OauthService  oauthService;

    public OauthController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping("/code/{registrationId}")
    public void googleLogin(@RequestParam(value="code", required=false)String code, @PathVariable String registrationId) {
        System.out.print("success to access?");
        oauthService.socialLogin(code, registrationId);
    }
}