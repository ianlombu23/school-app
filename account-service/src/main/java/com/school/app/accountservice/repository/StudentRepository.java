package com.school.app.accountservice.repository;

import com.school.app.accountservice.entity.Student;
import com.school.app.accountservice.entity.projections.StudentDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByEmail(String email);

    @Query(value = "SELECT s.studentId AS studentId, " +
            "s.fullName AS fullName, s.dateOfBirth AS dateOfBirth, " +
            "s.gender AS gender, s.email AS email, s.phoneNumber AS phoneNumber, " +
            "s.motherMaidenName AS motherMaidenName, s.address AS address, " +
            "c.classId AS classId, c.className AS className, t.fullName AS teacherName, " +
            "t.gender AS teacherGender, t.email AS teacherEmail, " +
            "t.phoneNumber AS teacherPhoneNumber  " +
            "FROM Student s " +
            "INNER JOIN StudentClass sc ON s.studentId = sc.studentId " +
            "INNER JOIN Class c ON sc.classId = c.classId " +
            "INNER JOIN Teacher t ON c.teacherId = t.teacherId " +
            "WHERE s.studentId = :studentId " +
            "AND s.isActive = true")
    Optional<StudentDetailProjection> findStudentDetail(String studentId);
}
