package com.school.app.accountservice.controller;

import com.school.app.accountservice.dto.request.TeacherRegisterRequest;
import com.school.app.accountservice.entity.Teacher;
import com.school.app.accountservice.service.TeacherRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/v1/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherRegisterService teacherRegisterService;

    @PostMapping("/register")
    public Teacher studentRegister(@RequestBody TeacherRegisterRequest teacherRegisterRequest) {
        return teacherRegisterService.teacherRegister(teacherRegisterRequest);
    }
}
