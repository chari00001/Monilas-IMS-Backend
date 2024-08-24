package com.ims.service;

import com.ims.model.Department;
import com.ims.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  // Retrieve all departments
  public List<Department> findAllDepartments() {
    return departmentRepository.findAll();
  }

  // Find a department by ID
  public Optional<Department> findDepartmentById(int id) {
    return departmentRepository.findById(id);
  }

  // Find departments by faculty
  public List<Department> findDepartmentsByFaculty(String faculty) {
    return departmentRepository.findByFaculty(faculty);
  }

  // Find a department by department head's ID
  public Optional<Department> findDepartmentByDepartmentHeadId(int departmentHeadId) {
    return departmentRepository.findByDepartmentHead(departmentHeadId);
  }

  // Find departments by name
  public List<Department> findDepartmentsByName(String name) {
    return departmentRepository.findByName(name);
  }

  // Find departments by name and faculty
  public List<Department> findDepartmentsByNameAndFaculty(String name, String faculty) {
    return departmentRepository.findByNameAndFaculty(name, faculty);
  }

  // Find departments containing a specific keyword in their name
  public List<Department> findDepartmentsByNameContaining(String keyword) {
    return departmentRepository.findByNameContaining(keyword);
  }

  // Count departments in a specific faculty
  public long countDepartmentsByFaculty(String faculty) {
    return departmentRepository.countByFaculty(faculty);
  }

  // Save or update a department
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }

  // Delete a department by ID
  public void deleteDepartmentById(int id) {
    departmentRepository.deleteById(id);
  }
}
