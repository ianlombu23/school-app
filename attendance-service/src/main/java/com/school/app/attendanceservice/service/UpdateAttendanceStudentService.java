package com.school.app.attendanceservice.service;

import com.school.app.attendanceservice.dto.request.AttendanceStudentRequest;
import com.school.app.attendanceservice.dto.response.AttendanceStudentResponse;
import com.school.app.attendanceservice.entity.Attendance;
import com.school.app.attendanceservice.entity.enums.AttendanceStatus;
import com.school.app.attendanceservice.exception.CustomException;
import com.school.app.attendanceservice.repository.AttendanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAttendanceStudentService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceStudentResponse updateAttendanceStudent(AttendanceStudentRequest request) {
        Attendance attendance = attendanceRepository.findById(request.getAttendanceId())
                .orElseThrow(() -> new CustomException(
                        "4100",
                        "Data attendance tidak ditemukan",
                        HttpStatus.CONFLICT
                ));

        attendance.setAttendanceStatus(AttendanceStatus.valueOf(request.getAttendanceStatus().toUpperCase()));
        attendance.setDescription(request.getDescription());
        attendanceRepository.save(attendance);

        return AttendanceStudentResponse.builder()
                .attendanceId(attendance.getAttendanceId())
                .build();
    }
}
