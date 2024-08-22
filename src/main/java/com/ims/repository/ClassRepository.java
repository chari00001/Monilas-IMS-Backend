package com.ims.repository;

import com.ims.model.ClassObj;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("null")
public interface ClassRepository extends JpaRepository<ClassObj, Integer> {
  Optional<ClassObj> findById(Integer id);

  List<ClassObj> findAll();

  <C extends ClassObj> C save(C entity);

  void deleteById(Integer id);

  ClassObj findByClassName(String class_name);

  List<ClassObj> findByLecturerId(int lecturer_id);

}
