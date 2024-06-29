package com.school.app.accountservice.entity;

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
@Table(name = "class")
public class Class extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name="class_id")
    private String classId;

    @Column(name="class_name")
    private String className;

    @Column(name = "teacher_id")
    private String teacherId;
}
