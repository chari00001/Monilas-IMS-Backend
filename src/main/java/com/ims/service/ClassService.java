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

  public List<ClassObj> getAllClasses() {
    return classRepository.findAll();
  }

  public Optional<ClassObj> getClassById(Integer id) {
    return classRepository.findById(id);
  }

  public ClassObj saveClass(ClassObj classObj) {
    return classRepository.save(classObj);
  }

  public void deleteClass(Integer id) {
    classRepository.deleteById(id);
  }

  public ClassObj getClassesByClassName(String class_name) {
    return classRepository.findByClassName(class_name);
  }

  public List<ClassObj> getClassesByLecturerId(Integer id) {
    return classRepository.findByLecturerId(id);
  }
}
