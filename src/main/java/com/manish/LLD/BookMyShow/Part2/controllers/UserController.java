package com.manish.LLD.BookMyShow.Part2.controllers;


import com.manish.LLD.BookMyShow.Part2.dtos.SignUpUserRequestDto;
import com.manish.LLD.BookMyShow.Part2.dtos.SignUpUserResponseDto;
import com.manish.LLD.BookMyShow.Part2.models.User;
import com.manish.LLD.BookMyShow.Part2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpUserResponseDto signUpUser(SignUpUserRequestDto request) {
        User user = userService.signUpUser(
                request.getEmail(), request.getPassword()
        );

        SignUpUserResponseDto response = new SignUpUserResponseDto();
        response.setUserId(user.getId());

        return response;
    }
}
