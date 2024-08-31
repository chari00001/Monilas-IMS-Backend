package com.ims.service;

import com.ims.model.Enrollment;
import com.ims.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

  @Autowired
  private EnrollmentRepository enrollmentRepository;

  // Get all enrollments
  public List<Enrollment> getAllEnrollments() {
    return enrollmentRepository.findAll();
  }

  // Get an enrollment by its ID
  public Optional<Enrollment> getEnrollmentById(Integer id) {
    return enrollmentRepository.findById(id);
  }

  // Save or update an enrollment
  public Enrollment saveEnrollment(Enrollment enrollment) {
    return enrollmentRepository.save(enrollment);
  }

  // Delete an enrollment by its ID
  public void deleteEnrollmentById(Integer id) {
    enrollmentRepository.deleteById(id);
  }

  // Custom methods

  // Get enrollments by student ID
  public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
    return enrollmentRepository.findByStudentId(studentId);
  }

  // Get enrollments by class ID
  public List<Enrollment> getEnrollmentsByClassId(int classId) {
    return enrollmentRepository.findByClassId(classId);
  }

  // Get enrollments by enrollment date
  public List<Enrollment> getEnrollmentsByEnrollmentDate(Date enrollmentDate) {
    return enrollmentRepository.findByEnrollmentDate(enrollmentDate);
  }

  // Get enrollments by student ID and class ID
  public List<Enrollment> getEnrollmentsByStudentIdAndClassId(int studentId, int classId) {
    return enrollmentRepository.findByStudentIdAndClassId(studentId, classId);
  }
  
  // Get enrollments within a specific date range
  public List<Enrollment> getEnrollmentsByDateRange(Date startDate, Date endDate) {
    return enrollmentRepository.findByEnrollmentDateBetween(startDate, endDate);
  }

  // Additional business logic methods can be added here if needed
}
