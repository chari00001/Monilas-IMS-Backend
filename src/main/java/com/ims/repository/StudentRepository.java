package com.ims.repository;

import com.ims.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("null")
public interface StudentRepository extends JpaRepository<Student, Integer> {

  // Find a student by their ID
  Optional<Student> findById(Integer id);

  // Find all students
  List<Student> findAll();

  // Save a student (create or update)
  <S extends Student> S save(S entity);

  // Delete a student by their ID
  void deleteById(Integer id);

  // Find students by their last name
  List<Student> findByLastName(String lastName);

  // Find students by their first name
  List<Student> findByFirstName(String firstName);

  // Find students by their email
  Optional<Student> findByEmail(String email);

  // Find students by their age
  List<Student> findByAge(Integer age);

  // Custom query: Find students older than a certain age
  @Query("SELECT s FROM Student s WHERE s.age > :age")
  List<Student> findStudentsOlderThan(@Param("age") Integer age);

  // Custom query: Find students with first name and last name
  @Query("SELECT s FROM Student s WHERE s.firstName = :firstName AND s.lastName = :lastName")
  List<Student> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

  // Custom query: Find students by a partial email match
  @Query("SELECT s FROM Student s WHERE s.email LIKE %:email%")
  List<Student> findByPartialEmail(@Param("email") String email);

  // Custom query: Count the number of students
  @Query("SELECT COUNT(s) FROM Student s")
  long countStudents();
}
