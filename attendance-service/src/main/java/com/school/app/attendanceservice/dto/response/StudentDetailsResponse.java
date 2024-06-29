package com.school.app.attendanceservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.school.app.attendanceservice.dto.ClassDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDetailsResponse {
    private String studentId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private String motherMaidenName;
    private String address;
    private ClassDetailsDto classInformation;
}
