package com.example.demo.models.Certificate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CertificateModel {

    private Integer user_id;
    private Integer course_id;
    private String issueDate;
    private String downloadLink;
}
