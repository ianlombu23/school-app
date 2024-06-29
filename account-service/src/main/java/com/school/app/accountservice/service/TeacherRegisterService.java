package com.school.app.accountservice.service;

import com.school.app.accountservice.dto.request.TeacherRegisterRequest;
import com.school.app.accountservice.exception.CustomException;
import com.school.app.accountservice.entity.Teacher;
import com.school.app.accountservice.entity.enums.Gender;
import com.school.app.accountservice.repository.TeacherRepository;
import com.school.app.accountservice.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TeacherRegisterService {
    private final TeacherRepository teacherRepository;
    private final Validator validator;

    public Teacher teacherRegister(TeacherRegisterRequest request) {
        validateByEmail(request);

        Teacher teacher = Teacher.builder()
                .fullName(request.getFullName())
                .dateOfBirth(request.getDateOfBirth())
                .gender(Gender.valueOf(request.getGender().toUpperCase()))
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .isActive(true)
                .build();

        return teacherRepository.save(teacher);
    }

    private void validateByEmail(TeacherRegisterRequest request) {
        if (!validator.isValidEmail(request.getEmail())) {
            throw new CustomException("5000", "Format Email Tidak Valid", HttpStatus.CONFLICT);
        }

        teacherRepository.findByEmail(request.getEmail())
                .ifPresent(d -> {
                    throw new CustomException("5100", "Email Telah Digunakan", HttpStatus.CONFLICT);
                });
    }
}
