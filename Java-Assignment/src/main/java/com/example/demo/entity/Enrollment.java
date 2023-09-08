package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Course course;

    private String enrollmentDate;

    @OneToOne
    @JoinColumn
    private Payment payment;


    // Constraints:
    // - 'paymentStatus' is required and cannot be null.

    // Relationships:
    // - Enrollment belongs to a User, that is @ManyToOne relationship.
    // - Enrollment belongs to a Course, that is @ManyToOne relationship.

    // Data Types:
    // - 'id' is of type Integer.
    // - 'enrollmentDate' is of type Date.
    // - 'paymentStatus' is of type String.
}

