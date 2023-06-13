package sinabeulo.sinabeulobackend.controller;

import org.springframework.web.bind.annotation.*;
import sinabeulo.sinabeulobackend.service.googleOAuthService;

@RestController
@RequestMapping(value = "/stt", produces = "application/json")
public class googleOAuthController {

    googleOAuthService sttService;

    public googleOAuthController(googleOAuthService loginService) {
        this.sttService = loginService;
    }

    @GetMapping("/code/{registrationId}")
    public void googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        googleOAuthService.socialLogin(code, registrationId);
        //https://accounts.google.com/o/oauth2/auth?client_id=266463498433-tkoh04m7he8psbidnaataa3rtg51ckmp.apps.googleusercontent.com&redirect_uri=http://localhost:8080/stt/code/google&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile
        //위 링크로 접속.
    }
}
