package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.LoginDTO;
import uz.pdp.appclickup.payload.RegisterDTO;
import uz.pdp.appclickup.security.JwtProvider;
import uz.pdp.appclickup.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        ApiResponse apiResponse = authService.registerUser(registerDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        ApiResponse apiResponse = authService.loginToSystem(loginDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse.getToken());
    }


    @PutMapping("/verifyEmail")
    public HttpEntity<?> verifyEmail(@RequestParam String email, @RequestParam String emailCode) {
        ApiResponse apiResponse = authService.verifyEmail(email, emailCode);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
