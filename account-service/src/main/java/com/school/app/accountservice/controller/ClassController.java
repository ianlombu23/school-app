package com.school.app.accountservice.controller;

import com.school.app.accountservice.dto.request.AssignStudentClassRequest;
import com.school.app.accountservice.dto.request.CreateSchoolClassRequest;
import com.school.app.accountservice.entity.Class;
import com.school.app.accountservice.entity.StudentClass;
import com.school.app.accountservice.service.AssignStudentClassService;
import com.school.app.accountservice.service.CreateSchoolClassService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1/class")
@AllArgsConstructor
public class ClassController {

    private final CreateSchoolClassService createSchoolClassService;
    private final AssignStudentClassService assignStudentClassService;

    @PostMapping("/create")
    public Class createSchoolClass(@RequestBody CreateSchoolClassRequest createSchoolClassRequest) {
        return createSchoolClassService.createSchoolClass(createSchoolClassRequest);
    }

    @PostMapping("/assign-student")
    public StudentClass assignedStudent(@RequestParam String classId,
                                        @RequestParam String studentId) {

        return assignStudentClassService.assignStudentClass(AssignStudentClassRequest.builder()
                .classId(classId)
                .studentId(studentId)
                .build());
    }

//    @GetMapping("/list-student")
}
