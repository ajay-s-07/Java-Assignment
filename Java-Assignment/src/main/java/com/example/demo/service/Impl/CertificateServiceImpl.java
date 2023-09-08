package com.example.demo.service.Impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.models.Certificate.CertificateModel;
import com.example.demo.repo.CertificateRepository;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void createCertificate(CertificateModel certificateModel) {

        Optional<User> optionalUser = userRepository.findById(certificateModel.getUser_id());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();

        Optional<Course> optionalCourse = courseRepository.findById(certificateModel.getCourse_id());
        if (optionalCourse.isEmpty()) {
            throw new RuntimeException("Course not found");
        }
        Course course = optionalCourse.get();

        Certificate certificate = Certificate.builder()
                .user(user)
                .course(course)
                .issueDate(certificateModel.getIssueDate())
                .downloadLink(certificateModel.getDownloadLink())
                .build();

        user.getCertificateList().add(certificate);
        course.getCertificateList().add(certificate);

        userRepository.save(user);
        courseRepository.save(course);
    }
}
