package com.school.app.accountservice.repository;

import com.school.app.accountservice.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, String> {

    Optional<StudentClass> findByStudentIdAndClassId(String studentId, String classId);

}
