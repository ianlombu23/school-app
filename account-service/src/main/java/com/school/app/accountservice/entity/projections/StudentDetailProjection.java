package com.school.app.accountservice.entity.projections;

import java.time.LocalDate;

public interface StudentDetailProjection {
    String getStudentId();
    String getFullName();
    LocalDate getDateOfBirth();
    String getGender();
    String getEmail();
    String getPhoneNumber();
    String getMotherMaidenName();
    String getAddress();
    String getClassId();
    String getClassName();
    String getTeacherName();
    String getTeacherGender();
    String getTeacherEmail();
    String getTeacherPhoneNumber();
}
