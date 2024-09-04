package com.ims.controller;

import com.ims.model.Department;
import com.ims.model.Lecturer;
import com.ims.service.DepartmentService;
import com.ims.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @Autowired
  private LecturerService lecturerService;

  // Get all departments
  @GetMapping
  public ResponseEntity<List<Department>> getAllDepartments() {
    List<Department> departments = departmentService.findAllDepartments();
    return ResponseEntity.ok(departments);
  }

  // Get a department by ID
  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
    Optional<Department> department = departmentService.findDepartmentById(id);
    return department.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Create a new department
  @PostMapping
  public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
    Department savedDepartment = departmentService.saveDepartment(department);
    return ResponseEntity.status(201).body(savedDepartment);
  }

  // Update an existing department
  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department departmentDetails) {
    Optional<Department> existingDepartment = departmentService.findDepartmentById(id);
    if (existingDepartment.isPresent()) {
      Department department = existingDepartment.get();
      department.setName(departmentDetails.getName());
      department.setFaculty(departmentDetails.getFaculty());
      department.setDepartmentHead(departmentDetails.getDepartmentHead());
      Department updatedDepartment = departmentService.saveDepartment(department);
      return ResponseEntity.ok(updatedDepartment);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Delete a department by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDepartmentById(@PathVariable int id) {
    Optional<Department> department = departmentService.findDepartmentById(id);
    if (department.isPresent()) {
      departmentService.deleteDepartmentById(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Get departments by faculty
  @GetMapping("/faculty/{faculty}")
  public ResponseEntity<List<Department>> getDepartmentsByFaculty(@PathVariable String faculty) {
    List<Department> departments = departmentService.findDepartmentsByFaculty(faculty);
    return ResponseEntity.ok(departments);
  }

  @GetMapping("/head/{id}")
  public ResponseEntity<Optional<Lecturer>> getDepartmentHead(@PathVariable int id) {
    Optional<Department> department = departmentService.findDepartmentById(id);
    if (department.isPresent()) {
      Department dept = department.get(); // Extract the Department object from Optional
      Optional<Lecturer> lecturer = lecturerService.getLecturerById(dept.getDepartmentHead());
      return ResponseEntity.ok(lecturer);
    }
    return ResponseEntity.notFound().build();
  }
}
