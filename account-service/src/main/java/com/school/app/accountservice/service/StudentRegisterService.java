package com.school.app.accountservice.service;

import com.school.app.accountservice.dto.request.StudentRegisterRequest;
import com.school.app.accountservice.exception.CustomException;
import com.school.app.accountservice.entity.Student;
import com.school.app.accountservice.entity.enums.Gender;
import com.school.app.accountservice.repository.StudentRepository;
import com.school.app.accountservice.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class StudentRegisterService {
    private final StudentRepository studentRepository;
    private final Validator validator;

    public Student studentRegister(StudentRegisterRequest request) {
        validateByEmail(request);

        Student student = Student.builder()
                .fullName(request.getFullName())
                .dateOfBirth(request.getDateOfBirth())
                .gender(Gender.valueOf(request.getGender().toUpperCase()))
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .motherMaidenName(request.getMotherMaidenName())
                .address(request.getAddress())
                .isActive(true)
                .build();

        return studentRepository.save(student);
    }

    private void validateByEmail(StudentRegisterRequest request) {
        if (!validator.isValidEmail(request.getEmail())) {
            throw new CustomException("5000", "Format Email Tidak Valid", HttpStatus.CONFLICT);
        }

        studentRepository.findByEmail(request.getEmail())
                .ifPresent(d -> {
                    throw new CustomException("5100", "Email Telah Digunakan", HttpStatus.CONFLICT);
                });
    }
}
