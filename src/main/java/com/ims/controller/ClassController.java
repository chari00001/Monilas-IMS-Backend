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

  // Get all classes
  @GetMapping
  public List<ClassObj> getAllClasses() {
    return classService.getAllClasses();
  }

  // Get a class by ID
  @GetMapping("/{id}")
  public ResponseEntity<ClassObj> getClassById(@PathVariable Integer id) {
    Optional<ClassObj> classObj = classService.getClassById(id);
    return classObj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Get a class by name
  @GetMapping("/name/{name}")
  public ResponseEntity<ClassObj> getClassByName(@PathVariable String name) {
    Optional<ClassObj> classObj = classService.getClassByName(name);
    return classObj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Get classes by lecturer ID
  @GetMapping("/lecturer/{lecturerId}")
  public List<ClassObj> getClassesByLecturerId(@PathVariable Integer lecturerId) {
    return classService.getClassesByLecturerId(lecturerId);
  }

  // Get classes by partial name match
  @GetMapping("/search")
  public List<ClassObj> getClassesByPartialName(@RequestParam String name) {
    return classService.getClassesByPartialName(name);
  }

  // Get classes within a specific credit range
  @GetMapping("/credits")
  public List<ClassObj> getClassesByCreditRange(@RequestParam int minCredit, @RequestParam int maxCredit) {
    return classService.getClassesByCreditRange(minCredit, maxCredit);
  }

  // Get classes by lecturer ID and within a specific credit range
  @GetMapping("/lecturer/{lecturerId}/credits")
  public List<ClassObj> getClassesByLecturerIdAndCreditRange(
      @PathVariable int lecturerId,
      @RequestParam int minCredit,
      @RequestParam int maxCredit) {
    return classService.getClassesByLecturerIdAndCreditRange(lecturerId, minCredit, maxCredit);
  }

  // Count classes by lecturer ID
  @GetMapping("/lecturer/{lecturerId}/count")
  public long countClassesByLecturerId(@PathVariable int lecturerId) {
    return classService.countClassesByLecturerId(lecturerId);
  }

  // Create or update a class
  @PostMapping
  public ClassObj createOrUpdateClass(@RequestBody ClassObj classObj) {
    return classService.saveClass(classObj);
  }

  // Delete a class by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClass(@PathVariable Integer id) {
    if (classService.getClassById(id).isPresent()) {
      classService.deleteClass(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
