package com.school.app.attendanceservice.controller;

import com.school.app.attendanceservice.dto.AttendanceReportDto;
import com.school.app.attendanceservice.dto.request.AttendanceReportRequest;
import com.school.app.attendanceservice.dto.response.AttendanceReportResponse;
import com.school.app.attendanceservice.service.AttendanceReportDetailService;
import com.school.app.attendanceservice.service.AttendanceReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance/v1/report")
@AllArgsConstructor
public class AttendanceReportController {

    private final AttendanceReportService attendanceReportService;
    private final AttendanceReportDetailService attendanceReportDetailService;

    @GetMapping("/list")
    public AttendanceReportResponse getAttendanceReport(@RequestParam(required = false) String attendanceBy,
                                                        @RequestParam(required = false) String studentId,
                                                        @RequestParam(required = false)  String attendanceStatus,
                                                        @RequestParam(required = false) String classId) {

        AttendanceReportRequest request = AttendanceReportRequest.builder()
                .attendanceBy(attendanceBy)
                .studentId(studentId)
                .attendanceStatus(attendanceStatus)
                .classId(classId)
                .build();

        return attendanceReportService.attendanceReport(request);
    }

    @GetMapping("/detail/{attendanceId}")
    public AttendanceReportDto getAttendanceDetail(@PathVariable String attendanceId) {
        return attendanceReportDetailService.attendanceReportDetail(attendanceId);
    }
}
