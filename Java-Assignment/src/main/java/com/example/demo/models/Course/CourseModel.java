package com.example.demo.models.Course;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseModel {

    private String title;

    private String description;

    private String instructor;

    private double price;

    private String startDate;

    private String[] topics;
}
