package com.example.demo.entity;

import com.example.demo.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Role role;

    private String email;

    private String contact_no;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Certificate> certificateList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Enrollment> enrollmentList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Payment> paymentList = new ArrayList<>();

    // Constraints:
    // - 'name' and 'email' are required and cannot be null.
    // - 'email' must be unique (no duplicate emails allowed).

    // Relationships:
    // - User can have multiple enrollments in courses, that is @OneToMany relationship.

    // Data Types:
    // - 'id' is of type Integer.
    // - 'name', 'email', 'password', and 'role' are of type String.

}

