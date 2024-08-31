package com.ims.controller;

import com.ims.model.Enrollment;
import com.ims.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

  @Autowired
  private EnrollmentService enrollmentService;

  // Get all enrollments
  @GetMapping
  public List<Enrollment> getAllEnrollments() {
    return enrollmentService.getAllEnrollments();
  }

  // Get an enrollment by ID
  @GetMapping("/{id}")
  public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Integer id) {
    Optional<Enrollment> enrollment = enrollmentService.getEnrollmentById(id);
    return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Get enrollments by student ID
  @GetMapping("/student/{studentId}")
  public List<Enrollment> getEnrollmentsByStudentId(@PathVariable int studentId) {
    return enrollmentService.getEnrollmentsByStudentId(studentId);
  }

  // Get enrollments by class ID
  @GetMapping("/class/{classId}")
  public List<Enrollment> getEnrollmentsByClassId(@PathVariable int classId) {
    return enrollmentService.getEnrollmentsByClassId(classId);
  }

  // Get enrollments by enrollment date
  @GetMapping("/date/{enrollmentDate}")
  public List<Enrollment> getEnrollmentsByEnrollmentDate(@PathVariable Date enrollmentDate) {
    return enrollmentService.getEnrollmentsByEnrollmentDate(enrollmentDate);
  }

  // Get enrollments by student ID and class ID
  @GetMapping("/student/{studentId}/class/{classId}")
  public List<Enrollment> getEnrollmentsByStudentIdAndClassId(@PathVariable int studentId, @PathVariable int classId) {
    return enrollmentService.getEnrollmentsByStudentIdAndClassId(studentId, classId);
  }

  // Get enrollments within a specific date range
  @GetMapping("/date-range")
  public List<Enrollment> getEnrollmentsByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
    return enrollmentService.getEnrollmentsByDateRange(startDate, endDate);
  }

  // Create or update an enrollment
  @PostMapping
  public Enrollment createOrUpdateEnrollment(@RequestBody Enrollment enrollment) {
    return enrollmentService.saveEnrollment(enrollment);
  }

  // Delete an enrollment by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEnrollmentById(@PathVariable Integer id) {
    if (enrollmentService.getEnrollmentById(id).isPresent()) {
      enrollmentService.deleteEnrollmentById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
