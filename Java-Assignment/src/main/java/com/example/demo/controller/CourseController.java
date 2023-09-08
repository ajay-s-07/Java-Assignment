package com.example.demo.controller;

import com.example.demo.models.Course.CourseModel;
import com.example.demo.models.Session.SessionModel;
import com.example.demo.models.Session.SessionResponseModel;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/course")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCourse(@RequestBody CourseModel courseModel) {
        Map<String, Object> result = new HashMap<>();
        try {
            courseService.createCourse(courseModel);
            result.put("result", "success");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            result.put("error", "failed");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllCourses() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<CourseModel> courses = courseService.getAllCourses();
            result.put("result", courses);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("error", "failed");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sessionDetails/{course_id}")
    public ResponseEntity<Object> getSessionDetails(@PathVariable Integer courseId) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<SessionResponseModel> sessions = courseService.getSessionDetails(courseId);
            result.put("result", sessions);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("error", e.getLocalizedMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
