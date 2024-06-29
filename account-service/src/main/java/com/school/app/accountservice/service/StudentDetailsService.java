package com.school.app.accountservice.service;

import com.school.app.accountservice.dto.ClassDetailsDto;
import com.school.app.accountservice.dto.response.StudentDetailsResponse;
import com.school.app.accountservice.entity.projections.StudentDetailProjection;
import com.school.app.accountservice.exception.CustomException;
import com.school.app.accountservice.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentDetailsService {

    private final StudentRepository studentRepository;

    public StudentDetailsResponse studentDetails(String studentId) {
        StudentDetailProjection student = studentRepository.findStudentDetail(studentId)
                .orElseThrow(() -> new CustomException(
                        "5300",
                        "Student tidak ditemukan",
                        HttpStatus.CONFLICT
                ));

        ClassDetailsDto classDetails = ClassDetailsDto.builder()
                .classId(student.getClassId())
                .className(student.getClassName())
                .teacherName(student.getTeacherName())
                .teacherGender(student.getGender())
                .teacherEmail(student.getEmail())
                .teacherPhoneNumber(student.getPhoneNumber())
                .build();

        return StudentDetailsResponse.builder()
                .studentId(student.getStudentId())
                .fullName(student.getFullName())
                .dateOfBirth(student.getDateOfBirth())
                .gender(student.getGender())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .motherMaidenName(student.getMotherMaidenName())
                .address(student.getAddress())
                .classInformation(classDetails)
                .build();
    }
}
