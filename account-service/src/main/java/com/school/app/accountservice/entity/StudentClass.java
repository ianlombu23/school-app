package com.school.app.accountservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "student_class")
public class StudentClass extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name="student_class_id")
    private String studentClassId;

    @Column(name="student_id")
    private String studentId;

    @Column(name = "class_id")
    private String classId;
}
