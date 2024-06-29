package com.school.app.accountservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateSchoolClassRequest {
    private String className;
    private String teacherId;
}
