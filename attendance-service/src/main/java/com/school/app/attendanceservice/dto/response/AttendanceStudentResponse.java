package com.school.app.attendanceservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AttendanceStudentResponse {
    private String attendanceId;
}
