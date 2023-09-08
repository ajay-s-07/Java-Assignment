package com.example.demo.controller;

import com.example.demo.models.Course.CourseModel;
import com.example.demo.models.Enrollment.EnrollmentModel;
import com.example.demo.service.EnrollmentService;
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
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/create")
    public ResponseEntity<Object> createEnrollment(@RequestBody EnrollmentModel enrollmentModel) {
        Map<String, Object> result = new HashMap<>();
        try {
            enrollmentService.createEnrollment(enrollmentModel);
            result.put("result", "success");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            result.put("error", e.getLocalizedMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
