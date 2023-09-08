package com.example.demo.service.Impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Session;
import com.example.demo.models.Session.SessionModel;
import com.example.demo.repo.SessionRepository;
import com.example.demo.repo.CourseRepository;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void createSession(SessionModel sessionModel) {

        //get the course object
        Optional<Course> optionalCourse = courseRepository.findById(sessionModel.getCourse_id());
        if (optionalCourse.isEmpty()) {
            throw new RuntimeException("Course not found");
        }
        Course course = optionalCourse.get();

        Session session = Session.builder()
                .course(course)
                .date(sessionModel.getDate())
                .topic(sessionModel.getTopic())
                .time(sessionModel.getTime())
                .recordingLink(sessionModel.getRecordingLink())
                .zoomLink(sessionModel.getZoomLink())
                .build();

        course.getSessionList().add(session);
        courseRepository.save(course);
    }
}
