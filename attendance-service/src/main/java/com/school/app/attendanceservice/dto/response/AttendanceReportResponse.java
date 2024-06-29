package com.school.app.attendanceservice.dto.response;

import com.school.app.attendanceservice.dto.AttendanceReportDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class AttendanceReportResponse {

    List<AttendanceReportDto> attendanceReportList;

}
