package com.school.app.attendanceservice.service;

import com.school.app.attendanceservice.client.AccountClient;
import com.school.app.attendanceservice.dto.request.AttendanceStudentRequest;
import com.school.app.attendanceservice.dto.response.AttendanceStudentResponse;
import com.school.app.attendanceservice.entity.Attendance;
import com.school.app.attendanceservice.entity.enums.AttendanceStatus;
import com.school.app.attendanceservice.exception.CustomException;
import com.school.app.attendanceservice.repository.AttendanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PostAttendanceStudentService {

    private final AttendanceRepository attendanceRepository;
    private final AccountClient accountClient;

    public AttendanceStudentResponse postAttendanceStudent(AttendanceStudentRequest request) {
        checkStudentAccount(request.getStudentId());
        checkIfStudentExist(request);
        Attendance attendance = Attendance.builder()
                .attendanceBy(request.getAttendanceBy())
                .studentId(request.getStudentId())
                .classId(request.getClassId())
                .attendanceStatus(AttendanceStatus.valueOf(request.getAttendanceStatus().toUpperCase()))
                .description(request.getDescription())
                .build();

        attendance.setCreatedBy(attendance.getAttendanceBy());
        attendanceRepository.save(attendance);

        return AttendanceStudentResponse.builder()
                .attendanceId(attendance.getAttendanceId())
                .build();
    }

    private void checkStudentAccount(String studentId) {
        accountClient.getStudentDetail(studentId);
    }

    private void checkIfStudentExist(AttendanceStudentRequest request) {
        attendanceRepository.findByStudentIdAndCreatedAt(request.getStudentId(), LocalDate.now())
                .ifPresent(a -> {
                    throw new CustomException(
                            "4700",
                            "Student telah di absen",
                            HttpStatus.CONFLICT
                    );
                });
    }
}
