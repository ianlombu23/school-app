package com.school.app.attendanceservice.service;

import com.school.app.attendanceservice.client.AccountClient;
import com.school.app.attendanceservice.dto.AttendanceReportDto;
import com.school.app.attendanceservice.dto.request.AttendanceReportRequest;
import com.school.app.attendanceservice.dto.response.AttendanceReportResponse;
import com.school.app.attendanceservice.dto.response.StudentDetailsResponse;
import com.school.app.attendanceservice.entity.Attendance;
import com.school.app.attendanceservice.entity.enums.AttendanceStatus;
import com.school.app.attendanceservice.repository.AttendanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendanceReportService {

    private final AttendanceRepository attendanceRepository;
    private final AccountClient accountClient;

    public AttendanceReportResponse attendanceReport(AttendanceReportRequest request) {
        AttendanceStatus attendanceStatus = Optional.ofNullable(request.getAttendanceStatus())
                .map(a -> AttendanceStatus.valueOf(a.toUpperCase()))
                .orElse(null);

        List<Attendance> attendance = attendanceRepository.getAttendanceReport(
                request.getStudentId(),
                request.getClassId(),
                request.getAttendanceBy(),
                attendanceStatus
        );

        List<AttendanceReportDto> attendanceReportDtoList = attendance.stream()
                .map(this::enrichResponse)
                .toList();

        return AttendanceReportResponse.builder()
                .attendanceReportList(attendanceReportDtoList)
                .build();
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
