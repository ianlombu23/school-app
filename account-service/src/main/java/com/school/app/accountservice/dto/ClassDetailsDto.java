package com.school.app.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClassDetailsDto {
    private String classId;
    private String className;
    private String teacherName;
    private String teacherGender;
    private String teacherEmail;
    private String teacherPhoneNumber;
}
