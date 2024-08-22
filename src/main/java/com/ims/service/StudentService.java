package com.ims.service;

import com.ims.model.Student;
import com.ims.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Optional<Student> getStudentById(Integer id) {
    return studentRepository.findById(id);
  }

  public Student saveStudent(Student student) {
    String encodedPassword = passwordEncoder.encode(student.getPassword());
    student.setPassword(encodedPassword);
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

  public List<Student> getStudentsByFullName(String firstName, String lastName) {
    return studentRepository.findByFullName(firstName, lastName);
  }

  public List<Student> getStudentsByPartialEmail(String email) {
    return studentRepository.findByPartialEmail(email);
  }

  public long countStudents() {
    return studentRepository.countStudents();
  }

  // New methods for authentication and status management

  public Optional<Student> authenticate(String email, String rawPassword) {
    Optional<Student> studentOpt = studentRepository.findByEmail(email);
    if (studentOpt.isPresent()) {
      Student student = studentOpt.get();
      if (passwordEncoder.matches(rawPassword, student.getPassword())) {
        return Optional.of(student);
      }
    }
    return Optional.empty(); // Return empty if authentication fails
  }

  public List<Student> getStudentsByStatus(String status) {
    return studentRepository.findByStatus(status);
  }

  public Optional<Student> findByEmail(String email) {
    return studentRepository.findByEmail(email);
  }
}
