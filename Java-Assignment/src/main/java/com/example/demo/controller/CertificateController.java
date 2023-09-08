package com.example.demo.controller;

import com.example.demo.models.Certificate.CertificateModel;
import com.example.demo.models.User.UserModel;
import com.example.demo.service.CertificateService;
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
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCertificate(@RequestBody CertificateModel certificateModel) {
        Map<String, Object> result = new HashMap<>();
        try {
            certificateService.createCertificate(certificateModel);
            result.put("result", "success");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            result.put("error", e.getLocalizedMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
