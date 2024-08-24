package com.ims.repository;

import com.ims.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SuppressWarnings("null")
public interface NoteRepository extends JpaRepository<Note, Integer> {

  // Custom query method to find notes by student ID
  List<Note> findByStudentId(int studentId);

  // Custom query method to find notes by class ID
  List<Note> findByClassId(int classId);

  // Custom query method to find notes by grade
  List<Note> findByGrade(String grade);

  // Custom query method to find notes by type
  List<Note> findByType(String type);

  <N extends Note> N save(N entity);

  // Custom query method to find notes by points greater than or equal to a
  // certain value
  List<Note> findByPointsGreaterThanEqual(int points);

  // Custom query method to find notes with attendance greater than or equal to a
  // certain value
  List<Note> findByAttendanceGreaterThanEqual(int attendance);

  // Custom query method to find notes by student ID and class ID
  List<Note> findByStudentIdAndClassId(int studentId, int classId);
}
