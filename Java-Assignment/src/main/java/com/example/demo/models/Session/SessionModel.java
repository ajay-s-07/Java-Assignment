package com.example.demo.models.Session;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SessionModel {

    private Integer course_id;

    private String date;

    private String time;

    private String topic;

    private String zoomLink;

    private String recordingLink;
}
