package com.ims.repository;

import com.ims.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

  Optional<Lecturer> findById(Integer id);

  List<Lecturer> findAll();

  <L extends Lecturer> L save(L entity);

  void deleteById(Integer id);

  // Custom query to find lecturers by departmentId
  @Query("SELECT l FROM Lecturer l WHERE l.departmentId = :departmentId")
  List<Lecturer> findByDepartmentId(@Param("departmentId") int departmentId);

  // Custom query to find lecturers by name
  @Query("SELECT l FROM Lecturer l WHERE l.name LIKE %:name%")
  List<Lecturer> findByNameContaining(@Param("name") String name);

  // Custom query to find lecturers who are department heads
  @Query("SELECT l FROM Lecturer l WHERE l.isDepartmentHead = true")
  List<Lecturer> findDepartmentHeads();
}
