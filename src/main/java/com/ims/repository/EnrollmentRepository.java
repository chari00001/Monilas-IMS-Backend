package com.ims.repository;

import com.ims.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

  // Custom query method to find enrollments by student ID
  List<Enrollment> findByStudentId(int studentId);

  // Custom query method to find enrollments by class ID
  List<Enrollment> findByClassId(int classId);

  // Custom query method to find enrollments by enrollment date
  List<Enrollment> findByEnrollmentDate(Date enrollmentDate);

  // Custom query method to find enrollments by student ID and class ID
  List<Enrollment> findByStudentIdAndClassId(int studentId, int classId);

  // Custom query method to find enrollments by a date range
  List<Enrollment> findByEnrollmentDateBetween(Date startDate, Date endDate);
}
