package com.school.app.attendanceservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.school.app.attendanceservice.dto.response.StudentDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttendanceReportDto {
    private String attendanceId;
    private String attendanceBy;
    private String attendanceStatus;
    private String description;
    private StudentDetailsResponse student;
}
