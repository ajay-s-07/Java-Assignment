package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Course course;

    private String date;

    private String time;

    private String topic;

    private String zoomLink;

    private String recordingLink;


    // Constraints:
    // - 'topic' is required and cannot be null.

    // Relationships:
    // - Class belongs to a Course, so its a @ManyToOne relationship.

    // Data Types:
    // - 'id' is of type Integer.
    // - 'date' is of type Date.
    // - 'time', 'topic', 'zoomLink', and 'recordingLink' are of type String.

}

