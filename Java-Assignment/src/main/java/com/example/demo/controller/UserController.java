package com.example.demo.controller;

import com.example.demo.models.User.UserModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UserModel userModel) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.createUser(userModel);
            result.put("result", "success");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            result.put("error", "failed");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
