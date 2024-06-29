package com.school.app.accountservice.service;

import com.school.app.accountservice.dto.request.CreateSchoolClassRequest;
import com.school.app.accountservice.exception.CustomException;
import com.school.app.accountservice.entity.Class;
import com.school.app.accountservice.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateSchoolClassService {

    private final ClassRepository classRepository;

    public Class createSchoolClass(CreateSchoolClassRequest request) {

        checkIfClassExists(request);

        Class classSaved = Class.builder()
                .className(request.getClassName())
                .teacherId(request.getTeacherId())
                .build();

        return classRepository.save(classSaved);
    }

    private void checkIfClassExists(CreateSchoolClassRequest request) {
        classRepository.findByClassName(request.getClassName())
                .ifPresent(c -> {
                    throw new CustomException("5120", "Class telah didaftarkan", HttpStatus.CONFLICT);
                });
    }
}
