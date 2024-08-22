package com.ims.repository;

import com.ims.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("null")
public interface StudentRepository extends JpaRepository<Student, Integer> {

  Optional<Student> findById(Integer id);

  List<Student> findAll();

  <S extends Student> S save(S entity);

  void deleteById(Integer id);

  List<Student> findByLastName(String lastName);

  List<Student> findByFirstName(String firstName);

  List<Student> findByAge(Integer age);

  // Custom query: Find students with first name and last name
  @Query("SELECT s FROM Student s WHERE s.firstName = :firstName AND s.lastName = :lastName")
  List<Student> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

  // Custom query: Find students by a partial email match
  @Query("SELECT s FROM Student s WHERE s.email LIKE %:email%")
  List<Student> findByPartialEmail(@Param("email") String email);

  // Custom query: Count the number of students
  @Query("SELECT COUNT(s) FROM Student s")
  long countStudents();

  // Authentication methods

  // Find a student by their username
  @Query("SELECT s FROM Student s WHERE s.email = :email")
  Optional<Student> findByEmail(@Param("email") String email); // Assuming email as username

  // Custom query to authenticate a user
  @Query("SELECT s FROM Student s WHERE s.email = :email AND s.password = :password")
  Optional<Student> authenticate(@Param("email") String email, @Param("password") String password);

  // Custom query: Find students by status (e.g., ACTIVE)
  @Query("SELECT s FROM Student s WHERE s.status = :status")
  List<Student> findByStatus(@Param("status") String status);
}
