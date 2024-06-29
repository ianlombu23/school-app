package com.school.app.accountservice.dto.response;

import com.school.app.accountservice.dto.ClassDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
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
