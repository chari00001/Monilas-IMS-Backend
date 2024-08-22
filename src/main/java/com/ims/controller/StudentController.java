package com.ims.controller;

import com.ims.model.Student;
import com.ims.service.StudentService;
import com.ims.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @Autowired
  private JwtUtil jwtUtil;

  @GetMapping
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
    Optional<Student> student = studentService.getStudentById(id);
    return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    Student createdStudent = studentService.saveStudent(student);
    return ResponseEntity.ok(createdStudent);
  }

  // Not Working!
  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
    if (studentService.getStudentById(id).isPresent()) {
      student.setId(id);
      return ResponseEntity.ok(studentService.saveStudent(student));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
    if (studentService.getStudentById(id).isPresent()) {
      studentService.deleteStudent(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

  // New endpoint: Authenticate a student
  @PostMapping("/login")
  public ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String password) {
    Optional<Student> student = studentService.authenticate(email, password);
    if (student.isPresent()) {
      String token = jwtUtil.generateToken(email);
      Map<String, Object> response = new HashMap<>();
      response.put("token", token);
      response.put("data", student.get());
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.status(401).build();
    }
  }

  // New endpoint: Register a new student
  @PostMapping("/register")
  public ResponseEntity<Student> register(@RequestBody Student student) {
    if (studentService.findByEmail(student.getEmail()).isPresent()) {
      return ResponseEntity.status(409).build(); // Conflict status if email is already used
    }
    // Set the initial status as ACTIVE or any other default
    student.setStatus("ACTIVE");
    Student registeredStudent = studentService.saveStudent(student);
    return ResponseEntity.ok(registeredStudent);
  }

  // New endpoint: Get students by status
  @GetMapping("/status/{status}")
  public List<Student> getStudentsByStatus(@PathVariable String status) {
    return studentService.getStudentsByStatus(status);
  }

  // New endpoint: Find student by username (email)
  @GetMapping("/email/{email}")
  public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
    Optional<Student> student = studentService.findByEmail(email);
    return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
