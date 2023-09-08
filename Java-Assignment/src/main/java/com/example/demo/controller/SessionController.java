package com.example.demo.controller;

import com.example.demo.models.Session.SessionModel;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @PostMapping("/create")
    public ResponseEntity<Object> createSession(@RequestBody SessionModel sessionModel) {
        Map<String, Object> result = new HashMap<>();
        try {
            sessionService.createSession(sessionModel);
            result.put("result", "success");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            result.put("error", e.getLocalizedMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
