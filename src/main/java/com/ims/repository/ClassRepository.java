package com.ims.repository;

import com.ims.model.ClassObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("null")
public interface ClassRepository extends JpaRepository<ClassObj, Integer> {

  // Find a class by its ID
  Optional<ClassObj> findById(Integer id);

  // Find all classes
  List<ClassObj> findAll();

  // Save or update a class
  <C extends ClassObj> C save(C entity);

  // Delete a class by its ID
  void deleteById(Integer id);

  // Find a class by its name
  Optional<ClassObj> findByName(String name);

  // Find classes taught by a specific lecturer
  List<ClassObj> findByLecturerId(int lecturerId);

  // Custom query: Find classes by a partial name match
  @Query("SELECT c FROM ClassObj c WHERE c.name LIKE %:name%")
  List<ClassObj> findByPartialName(@Param("name") String name);

  // Custom query: Find classes within a certain credit range
  @Query("SELECT c FROM ClassObj c WHERE c.credit BETWEEN :minCredit AND :maxCredit")
  List<ClassObj> findByCreditRange(@Param("minCredit") int minCredit, @Param("maxCredit") int maxCredit);

  // Custom query: Find classes by a lecturer and within a certain credit range
  @Query("SELECT c FROM ClassObj c WHERE c.lecturerId = :lecturerId AND c.credit BETWEEN :minCredit AND :maxCredit")
  List<ClassObj> findByLecturerIdAndCreditRange(@Param("lecturerId") int lecturerId, @Param("minCredit") int minCredit,
      @Param("maxCredit") int maxCredit);

  // Custom query: Count the number of classes taught by a specific lecturer
  @Query("SELECT COUNT(c) FROM ClassObj c WHERE c.lecturerId = :lecturerId")
  long countByLecturerId(@Param("lecturerId") int lecturerId);
}
