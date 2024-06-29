package com.school.app.attendanceservice.service;

import com.school.app.attendanceservice.client.AccountClient;
import com.school.app.attendanceservice.dto.AttendanceReportDto;
import com.school.app.attendanceservice.dto.response.StudentDetailsResponse;
import com.school.app.attendanceservice.entity.Attendance;
import com.school.app.attendanceservice.exception.CustomException;
import com.school.app.attendanceservice.repository.AttendanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendanceReportDetailService {

    private final AttendanceRepository attendanceRepository;
    private final AccountClient accountClient;

    public AttendanceReportDto attendanceReportDetail(String attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new CustomException(
                        "4300",
                        "Attendance tidak ditemukan",
                        HttpStatus.CONFLICT
                ));

        return enrichResponse(attendance);
    }

    private AttendanceReportDto enrichResponse(Attendance attendance) {
        StudentDetailsResponse student = getStudentDetail(attendance.getStudentId());
        return AttendanceReportDto.builder()
                .attendanceId(attendance.getAttendanceId())
                .attendanceBy(attendance.getAttendanceBy())
                .attendanceStatus(attendance.getAttendanceStatus().name())
                .description(attendance.getDescription())
                .student(student)
                .build();
    }

    private StudentDetailsResponse getStudentDetail(String studentId) {
        return accountClient.getStudentDetail(studentId);
    }
}
