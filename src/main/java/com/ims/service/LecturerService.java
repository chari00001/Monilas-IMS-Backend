package com.ims.service;

import com.ims.model.Lecturer;
import com.ims.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerService {

  @Autowired
  private LecturerRepository lecturerRepository;

  // Get all lecturers
  public List<Lecturer> getAllLecturers() {
    return lecturerRepository.findAll();
  }

  // Get a lecturer by ID
  public Optional<Lecturer> getLecturerById(Integer id) {
    return lecturerRepository.findById(id);
  }

  // Save a lecturer (create or update)
  public Lecturer saveLecturer(Lecturer lecturer) {
    return lecturerRepository.save(lecturer);
  }

  // Delete a lecturer by ID
  public void deleteLecturer(Integer id) {
    lecturerRepository.deleteById(id);
  }

  // Find lecturers by department ID
  public List<Lecturer> getLecturersByDepartmentId(int departmentId) {
    return lecturerRepository.findByDepartmentId(departmentId);
  }

  // Find lecturers by name (partial match)
  public List<Lecturer> searchLecturersByName(String name) {
    return lecturerRepository.findByNameContaining(name);
  }

  // Find department heads
  public List<Lecturer> getDepartmentHeads() {
    return lecturerRepository.findDepartmentHeads();
  }
}
