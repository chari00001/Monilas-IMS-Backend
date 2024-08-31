package com.ims.service;

import com.ims.model.Exam;
import com.ims.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

  @Autowired
  private ExamRepository examRepository;

  // Get all exams
  public List<Exam> getAllExams() {
    return examRepository.findAll();
  }

  // Get an exam by its ID
  public Optional<Exam> getExamById(Integer id) {
    return examRepository.findById(id);
  }

  // Save or update an exam
  public Exam saveExam(Exam exam) {
    return examRepository.save(exam);
  }

  // Delete an exam by its ID
  public void deleteExamById(Integer id) {
    examRepository.deleteById(id);
  }

  // Custom methods

  // Get exams by class ID
  public List<Exam> getExamsByClassId(int classId) {
    return examRepository.findByClassId(classId);
  }

  // Get exams by exam date
  public List<Exam> getExamsByExamDate(java.sql.Date examDate) {
    return examRepository.findByExamDate(examDate);
  }

  // Get exams by type
  public List<Exam> getExamsByType(String type) {
    return examRepository.findByType(type);
  }

  // Get exams with duration greater than or equal to a certain value
  public List<Exam> getExamsByDurationGreaterThanEqual(java.sql.Time duration) {
    return examRepository.findByDurationGreaterThanEqual(duration);
  }

  // Get exams by exam date and class ID
  public List<Exam> getExamsByExamDateAndClassId(java.sql.Date examDate, int classId) {
    return examRepository.findByExamDateAndClassId(examDate, classId);
  }

  // Get exams by type and class ID
  public List<Exam> getExamsByTypeAndClassId(String type, int classId) {
    return examRepository.findByTypeAndClassId(type, classId);
  }

  // Get exams by type and duration less than a certain value
  public List<Exam> getExamsByTypeAndDurationLessThan(String type, java.sql.Time duration) {
    return examRepository.findByTypeAndDurationLessThan(type, duration);
  }

  // Additional business logic methods can be added here if needed
}
