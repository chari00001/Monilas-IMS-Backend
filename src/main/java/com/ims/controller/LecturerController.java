package com.ims.controller;

import com.ims.model.Lecturer;
import com.ims.service.LecturerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

import com.ims.util.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lecturers")
public class LecturerController {

  @Autowired
  private LecturerService lecturerService;

  @Autowired
  private JwtUtil jwtUtil;

  // Get all lecturers
  @GetMapping
  public List<Lecturer> getAllLecturers() {
    return lecturerService.getAllLecturers();
  }

  // Get a lecturer by ID
  @GetMapping("/{id}")
  public ResponseEntity<Lecturer> getLecturerById(@PathVariable Integer id) {
    Optional<Lecturer> lecturer = lecturerService.getLecturerById(id);
    return lecturer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Create a new lecturer
  @PostMapping
  public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) {
    Lecturer savedLecturer = lecturerService.saveLecturer(lecturer);
    return ResponseEntity.ok(savedLecturer);
  }

  // Update an existing lecturer
  @PutMapping("/{id}")
  public ResponseEntity<Lecturer> updateLecturer(@PathVariable Integer id, @RequestBody Lecturer lecturer) {
    Optional<Lecturer> existingLecturer = lecturerService.getLecturerById(id);
    if (existingLecturer.isPresent()) {
      lecturer.setId(id);
      Lecturer updatedLecturer = lecturerService.saveLecturer(lecturer);
      return ResponseEntity.ok(updatedLecturer);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Delete a lecturer by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLecturer(@PathVariable Integer id) {
    Optional<Lecturer> existingLecturer = lecturerService.getLecturerById(id);
    if (existingLecturer.isPresent()) {
      lecturerService.deleteLecturer(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Get lecturers by department ID
  @GetMapping("/department/{departmentId}")
  public List<Lecturer> getLecturersByDepartmentId(@PathVariable int departmentId) {
    return lecturerService.getLecturersByDepartmentId(departmentId);
  }

  // Search lecturers by name
  @GetMapping("/search")
  public List<Lecturer> searchLecturersByName(@RequestParam String name) {
    return lecturerService.searchLecturersByName(name);
  }

  // Get all department heads
  @GetMapping("/department-heads")
  public List<Lecturer> getDepartmentHeads() {
    return lecturerService.getDepartmentHeads();
  }

  // Login endpoint for lecturer authentication
  @PostMapping("/login")
  public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
    String email = credentials.get("email");
    String password = credentials.get("password");

    Optional<Lecturer> lecturer = lecturerService.authenticateLecturer(email, password);

    if (lecturer.isPresent()) {
      String token = jwtUtil.generateToken(email);
      Map<String, Object> response = new HashMap<>();
      response.put("token", token);
      response.put("data", lecturer.get());
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.status(401).build();
    }
  }
}
