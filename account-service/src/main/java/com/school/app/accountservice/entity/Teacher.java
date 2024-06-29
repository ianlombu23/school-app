package com.school.app.accountservice.entity;

import com.school.app.accountservice.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name="teacher_id")
    private String teacherId;

    @Column(name="full_name")
    private String fullName;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="address")
    private String address;

    @Column(name="is_active")
    private Boolean isActive;
}
