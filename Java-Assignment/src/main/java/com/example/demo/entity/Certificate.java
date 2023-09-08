package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Course course;

    private String issueDate;

    private String downloadLink;


    // Constraints:
    // - 'downloadLink' is required and cannot be null.

    // Relationships:
    // - Certificate belongs to a User, we can define it @ManyToOne relationship.
    // - Certificate belongs to a Course, that is @ManyToOne relationship.

    // Data Types:
    // - 'id' is of type Integer.
    // - 'issueDate' is of type Date.
    // - 'downloadLink' is of type String.
}