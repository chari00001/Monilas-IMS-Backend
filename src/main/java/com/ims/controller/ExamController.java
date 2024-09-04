package com.ims.controller;

import com.ims.model.Exam;
import com.ims.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/exams")
public class ExamController {

  @Autowired
  private ExamService examService;

  // Get all exams
  @GetMapping
  public List<Exam> getAllExams() {
    return examService.getAllExams();
  }

  // Get an exam by ID
  @GetMapping("/{id}")
  public ResponseEntity<Exam> getExamById(@PathVariable Integer id) {
    Optional<Exam> exam = examService.getExamById(id);
    return exam.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Get exams by class ID
  @GetMapping("/class/{classId}")
  public List<Exam> getExamsByClassId(@PathVariable int classId) {
    return examService.getExamsByClassId(classId);
  }

  // Get exams by exam date
  @GetMapping("/date/{examDate}")
  public List<Exam> getExamsByExamDate(@PathVariable Date examDate) {
    return examService.getExamsByExamDate(examDate);
  }

  // Get exams by type
  @GetMapping("/type/{type}")
  public List<Exam> getExamsByType(@PathVariable String type) {
    return examService.getExamsByType(type);
  }

  // Not Working!
  // Get exams with duration greater than or equal to a certain value
  @GetMapping("/duration")
  public List<Exam> getExamsByDurationGreaterThanEqual(@RequestParam Time duration) {
    return examService.getExamsByDurationGreaterThanEqual(duration);
  }

  // Get exams by exam date and class ID
  @GetMapping("/date/{examDate}/class/{classId}")
  public List<Exam> getExamsByExamDateAndClassId(@PathVariable Date examDate, @PathVariable int classId) {
    return examService.getExamsByExamDateAndClassId(examDate, classId);
  }

  // Get exams by type and class ID
  @GetMapping("/type/{type}/class/{classId}")
  public List<Exam> getExamsByTypeAndClassId(@PathVariable String type, @PathVariable int classId) {
    return examService.getExamsByTypeAndClassId(type, classId);
  }

  // Not Working!
  // Get exams by type and duration less than a certain value
  @GetMapping("/type/{type}/duration")
  public List<Exam> getExamsByTypeAndDurationLessThan(@PathVariable String type, @RequestParam Time duration) {
    return examService.getExamsByTypeAndDurationLessThan(type, duration);
  }

  // Create or update an exam
  @PostMapping
  public Exam createOrUpdateExam(@RequestBody Exam exam) {
    return examService.saveExam(exam);
  }

  // Delete an exam by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteExamById(@PathVariable Integer id) {
    if (examService.getExamById(id).isPresent()) {
      examService.deleteExamById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
