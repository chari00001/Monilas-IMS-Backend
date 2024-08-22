package com.ims.service;

import com.ims.model.Student;
import com.ims.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Optional<Student> getStudentById(Integer id) {
    return studentRepository.findById(id);
  }

  public Student saveStudent(Student student) {
    System.out.println("Saving student: " + student);

    return studentRepository.save(student);
  }

  public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
  }

  public List<Student> getStudentsByLastName(String lastName) {
    return studentRepository.findByLastName(lastName);
  }

  public List<Student> getStudentsByFirstName(String firstName) {
    return studentRepository.findByFirstName(firstName);
  }

  public Optional<Student> getStudentByEmail(String email) {
    return studentRepository.findByEmail(email);
  }

  public List<Student> getStudentsByAge(Integer age) {
    return studentRepository.findByAge(age);
  }

  public List<Student> getStudentsOlderThan(Integer age) {
    return studentRepository.findStudentsOlderThan(age);
  }

  public List<Student> getStudentsByFullName(String firstName, String lastName) {
    return studentRepository.findByFullName(firstName, lastName);
  }

  public List<Student> getStudentsByPartialEmail(String email) {
    return studentRepository.findByPartialEmail(email);
  }

  public long countStudents() {
    return studentRepository.countStudents();
  }
}
