package com.ims.controller;

import com.ims.model.ClassObj;
import com.ims.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
public class ClassController {

  @Autowired
  private ClassService classService;

  @GetMapping
  public List<ClassObj> getAllClasses() {
    return classService.getAllClasses();
  };

  @GetMapping("/{id}")
  public ResponseEntity<ClassObj> getClassById(@PathVariable Integer id) {
    Optional<ClassObj> classObj = classService.getClassById(id);
    return classObj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
