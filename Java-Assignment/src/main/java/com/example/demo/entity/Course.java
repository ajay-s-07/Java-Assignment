package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private String instructor;

    private double price;

    private String startDate;

    private String topics;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Session> sessionList = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Certificate> certificateList = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Enrollment> enrollmentList = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Payment> paymentList = new ArrayList<>();

    // Constraints:
    // - 'title', 'description', 'instructor', 'price', 'schedule', 'topics', and 'zoomLink' are required and cannot be null.

    // Relationships:
    // - Course can have multiple enrollments, define a @OneToMany relationship.
    // - Course can have multiple class sessions, define a @OneToMany relationship.

    // Data Types:
    // - 'id' is of type Integer.
    // - 'title', 'description', 'instructor', 'schedule', and 'zoomLink' are of type String.
    // - 'topics' is an Array of String.
    // - 'price' is of type double.
}
