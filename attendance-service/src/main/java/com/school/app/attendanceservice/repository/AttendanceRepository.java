package com.school.app.attendanceservice.repository;

import com.school.app.attendanceservice.entity.Attendance;
import com.school.app.attendanceservice.entity.enums.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, String> {

    @Query(value =
            "SELECT a FROM Attendance a " +
                    "WHERE (:studentId IS NULL OR a.studentId = :studentId) " +
                    "AND (:classId IS NULL OR a.classId = :classId) " +
                    "AND (:attendanceBy IS NULL OR a.attendanceBy = :attendanceBy) " +
                    "AND (:attendanceStatus IS NULL OR a.attendanceStatus = :attendanceStatus)"
    )
    List<Attendance> getAttendanceReport(String studentId,
                                         String classId,
                                         String attendanceBy,
                                         AttendanceStatus attendanceStatus);

    @Query(value =
            "SELECT a FROM Attendance a " +
                    "WHERE a.studentId = :studentId " +
                    "AND DATE(a.createdAt) = Date(:createdAt) "
    )
    Optional<Attendance> findByStudentIdAndCreatedAt(String studentId, LocalDate createdAt);
}
