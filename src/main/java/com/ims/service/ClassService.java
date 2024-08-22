package com.ims.service;

import com.ims.model.ClassObj;
import com.ims.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

  @Autowired
  private ClassRepository classRepository;

  // Get all classes
  public List<ClassObj> getAllClasses() {
    return classRepository.findAll();
  }

  // Get a class by its ID
  public Optional<ClassObj> getClassById(Integer id) {
    return classRepository.findById(id);
  }

  // Save or update a class
  public ClassObj saveClass(ClassObj classObj) {
    return classRepository.save(classObj);
  }

  // Delete a class by its ID
  public void deleteClass(Integer id) {
    classRepository.deleteById(id);
  }

  // Get a class by its name
  public Optional<ClassObj> getClassByName(String name) {
    return classRepository.findByName(name);
  }

  // Get classes by lecturer ID
  public List<ClassObj> getClassesByLecturerId(Integer lecturerId) {
    return classRepository.findByLecturerId(lecturerId);
  }

  // Get classes by partial name match
  public List<ClassObj> getClassesByPartialName(String name) {
    return classRepository.findByPartialName(name);
  }

  // Get classes within a specific credit range
  public List<ClassObj> getClassesByCreditRange(int minCredit, int maxCredit) {
    return classRepository.findByCreditRange(minCredit, maxCredit);
  }

  // Get classes by lecturer ID and within a specific credit range
  public List<ClassObj> getClassesByLecturerIdAndCreditRange(int lecturerId, int minCredit, int maxCredit) {
    return classRepository.findByLecturerIdAndCreditRange(lecturerId, minCredit, maxCredit);
  }

  // Count the number of classes taught by a specific lecturer
  public long countClassesByLecturerId(int lecturerId) {
    return classRepository.countByLecturerId(lecturerId);
  }
}
