package com.ims.repository;

import com.ims.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("null")
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

  // Find departments by faculty
  List<Department> findByFaculty(String faculty);

  // Find a department by its head's ID
  Optional<Department> findByDepartmentHead(int departmentHeadId);

  <D extends Department> D save(D entity);

  // Find departments with a specific name
  List<Department> findByName(String name);

  // Find departments with a specific name within a specific faculty
  List<Department> findByNameAndFaculty(String name, String faculty);

  // Find departments by a part of the name (useful for search functionality)
  List<Department> findByNameContaining(String keyword);

  // Find all departments that do not have a department head assigned
  List<Department> findByDepartmentHeadIsNull();

  // Count departments within a specific faculty
  long countByFaculty(String faculty);

  // Delete departments by faculty
  void deleteByFaculty(String faculty);
}
