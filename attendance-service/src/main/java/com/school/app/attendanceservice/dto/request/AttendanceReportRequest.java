package com.school.app.attendanceservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AttendanceReportRequest {
    private String attendanceBy;
    private String studentId;
    private String attendanceStatus;
    private String classId;
}
