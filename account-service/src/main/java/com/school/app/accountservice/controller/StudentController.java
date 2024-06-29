package com.school.app.accountservice.controller;

import com.school.app.accountservice.dto.request.StudentRegisterRequest;
import com.school.app.accountservice.dto.response.StudentDetailsResponse;
import com.school.app.accountservice.entity.Student;
import com.school.app.accountservice.service.StudentDetailsService;
import com.school.app.accountservice.service.StudentRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentRegisterService studentRegisterService;
    private final StudentDetailsService studentDetailsService;

    @PostMapping("/register")
    public Student studentRegister(@RequestBody StudentRegisterRequest studentRegisterRequest) {
        return studentRegisterService.studentRegister(studentRegisterRequest);
    }

    @GetMapping("/details/{studentId}")
    public StudentDetailsResponse studentDetails(@PathVariable String studentId) {
        return studentDetailsService.studentDetails(studentId);
    }
}
