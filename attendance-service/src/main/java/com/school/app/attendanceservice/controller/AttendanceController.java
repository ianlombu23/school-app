package com.school.app.attendanceservice.controller;

import com.school.app.attendanceservice.dto.request.AttendanceStudentRequest;
import com.school.app.attendanceservice.dto.response.AttendanceStudentResponse;
import com.school.app.attendanceservice.service.PostAttendanceStudentService;
import com.school.app.attendanceservice.service.UpdateAttendanceStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance/v1")
@AllArgsConstructor
public class AttendanceController {

    private final PostAttendanceStudentService postAttendanceStudentService;
    private final UpdateAttendanceStudentService updateAttendanceStudentService;

    @PostMapping("/create")
    public AttendanceStudentResponse createAttendance(@RequestBody AttendanceStudentRequest attendanceStudentRequest) {
        return postAttendanceStudentService.postAttendanceStudent(attendanceStudentRequest);
    }

    @PostMapping("/edit")
    public AttendanceStudentResponse editAttendance(@RequestBody AttendanceStudentRequest attendanceStudentRequest) {
        return updateAttendanceStudentService.updateAttendanceStudent(attendanceStudentRequest);
    }
}
