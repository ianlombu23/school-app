package com.school.app.attendanceservice.entity;

import com.school.app.attendanceservice.entity.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendance")
public class Attendance extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name="attendance_id")
    private String attendanceId;

    @Column(name="attendance_by")
    private String attendanceBy;

    @Column(name="student_id")
    private String studentId;

    @Column(name="class_id")
    private String classId;

    @Column(name="description")
    private String description;

    @Column(name="attendance_status")
    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;
}
