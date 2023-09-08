package com.example.demo.models.Enrollment;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EnrollmentModel {

    private Integer user_id;
    private Integer course_id;
    private String enrollmentDate;

    private double amount;
    private String paymentDate;
    private boolean paymentStatus;
    private String paymentMethod;
}
