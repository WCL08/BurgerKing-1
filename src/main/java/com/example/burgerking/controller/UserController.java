package com.example.burgerking.controller;

import com.example.burgerking.dto.LoginRequestDto;
import com.example.burgerking.dto.ResponseDto;
import com.example.burgerking.dto.SignupRequestDto;
import com.example.burgerking.service.UserService;
import com.example.burgerking.vo.MenuVo;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

//    @CrossOrigin("*")
//    @PostMapping("/signup")
//    public ResponseEntity signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
//        return userService.signup(signupRequestDto);
//    }

    @PostMapping("/signup")
    public ResponseDto<MenuVo> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.login(loginRequestDto, response);

    }

}
