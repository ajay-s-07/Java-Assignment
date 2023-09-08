package com.example.demo.service;

import com.example.demo.models.Course.CourseModel;
import com.example.demo.models.Session.SessionResponseModel;

import java.util.List;

public interface CourseService {

    void createCourse(CourseModel courseModel);

    List<CourseModel> getAllCourses();

    List<SessionResponseModel> getSessionDetails(Integer courseId);
}
