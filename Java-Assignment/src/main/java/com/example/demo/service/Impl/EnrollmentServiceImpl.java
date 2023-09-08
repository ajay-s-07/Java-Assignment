package com.example.demo.service.Impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Payment;
import com.example.demo.entity.User;
import com.example.demo.models.Enrollment.EnrollmentModel;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.EnrollmentRepository;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void createEnrollment(EnrollmentModel enrollmentModel) {

        //get user object, if not exists throw exception
        Optional<User> optionalUser = userRepository.findById(enrollmentModel.getUser_id());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = optionalUser.get();

        //get course object, if not exists throw exception
        Optional<Course> optionalCourse = courseRepository.findById(enrollmentModel.getCourse_id());
        if (optionalCourse.isEmpty()) {
            throw new RuntimeException("Course not available");
        }

        Course course = optionalCourse.get();

        //payment not completed
        if (!enrollmentModel.isPaymentStatus()) {
            throw new RuntimeException("Payment not completed!!");
        }

        Payment payment = Payment.builder()
                .paymentStatus(true)
                .paymentMethod(enrollmentModel.getPaymentMethod())
                .paymentDate(enrollmentModel.getPaymentDate())
                .amount(enrollmentModel.getAmount())
                .user(user)
                .course(course)
                .build();

        Enrollment enrollment = Enrollment.builder()
                .enrollmentDate(enrollmentModel.getEnrollmentDate())
                .user(user)
                .course(course)
                .payment(payment)
                .build();

        user.getEnrollmentList().add(enrollment);
        course.getEnrollmentList().add(enrollment);

        paymentRepository.save(payment);
        enrollmentRepository.save(enrollment);
        userRepository.save(user);
        courseRepository.save(course);
    }
}
