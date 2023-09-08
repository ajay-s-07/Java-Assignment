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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Course course;

    private double amount;

    private String paymentDate;

    private boolean paymentStatus;

    private String paymentMethod;


    // Constraints:
    // - 'paymentStatus' and 'paymentMethod' are required and cannot be null.

    // Relationships:
    // - Payment belongs to a User, define a @ManyToOne relationship.
    // - Payment belongs to a Course, define a @ManyToOne relationship.

    // Data Types:
    // - 'id' is of type Integer.
    // - 'amount' is of type double.
    // - 'paymentDate' is of type Date.
    // - 'paymentStatus' and 'paymentMethod' are of type String.
}
