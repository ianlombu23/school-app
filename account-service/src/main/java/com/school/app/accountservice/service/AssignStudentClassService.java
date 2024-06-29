package com.school.app.accountservice.service;

import com.school.app.accountservice.dto.request.AssignStudentClassRequest;
import com.school.app.accountservice.exception.CustomException;
import com.school.app.accountservice.entity.StudentClass;
import com.school.app.accountservice.repository.ClassRepository;
import com.school.app.accountservice.repository.StudentClassRepository;
import com.school.app.accountservice.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssignStudentClassService {

    private final StudentClassRepository studentClassRepository;
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    public StudentClass assignStudentClass(AssignStudentClassRequest request) {
        validateSchoolClass(request);
        validateStudent(request);
        checkStudentAssignedInClass(request);

        StudentClass studentClass = StudentClass.builder()
                .classId(request.getClassId())
                .studentId(request.getStudentId())
                .build();

        return studentClassRepository.save(studentClass);
    }

    private void checkStudentAssignedInClass(AssignStudentClassRequest request) {
        studentClassRepository.findByStudentIdAndClassId(request.getStudentId(), request.getClassId())
                .ifPresent(s -> {
                    throw new CustomException(
                            "5600",
                            "Student telah di daftarkan",
                            HttpStatus.CONFLICT);
                });
    }

    private void validateSchoolClass(AssignStudentClassRequest request) {
        classRepository.findById(request.getClassId())
                .orElseThrow(() -> new CustomException(
                        "5400",
                        "Class tidak ditemukan",
                        HttpStatus.CONFLICT
                ));
    }

    private void validateStudent(AssignStudentClassRequest request) {
        studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new CustomException(
                        "5500",
                        "Student tidak ditemukan",
                        HttpStatus.CONFLICT
                ));
    }
}
