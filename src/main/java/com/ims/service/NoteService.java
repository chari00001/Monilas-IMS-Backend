package com.ims.service;

import com.ims.model.Note;
import com.ims.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

  @Autowired
  private NoteRepository noteRepository;

  // Get all notes
  public List<Note> getAllNotes() {
    return noteRepository.findAll();
  }

  // Get a note by its ID
  public Optional<Note> getNoteById(Integer id) {
    return noteRepository.findById(id);
  }

  // Save or update a note
  public Note saveNote(Note note) {
    return noteRepository.save(note);
  }

  // Delete a note by its ID
  public void deleteNoteById(Integer id) {
    noteRepository.deleteById(id);
  }

  // Custom methods

  // Get notes by student ID
  public List<Note> getNotesByStudentId(int studentId) {
    return noteRepository.findByStudentId(studentId);
  }

  // Get notes by class ID
  public List<Note> getNotesByClassId(int classId) {
    return noteRepository.findByClassId(classId);
  }

  // Get notes by grade
  public List<Note> getNotesByGrade(String grade) {
    return noteRepository.findByGrade(grade);
  }

  // Get notes by type
  public List<Note> getNotesByType(String type) {
    return noteRepository.findByType(type);
  }

  // Get notes by points greater than or equal to a certain value
  public List<Note> getNotesByPointsGreaterThanEqual(int points) {
    return noteRepository.findByPointsGreaterThanEqual(points);
  }

  // Get notes with attendance greater than or equal to a certain value
  public List<Note> getNotesByAttendanceGreaterThanEqual(int attendance) {
    return noteRepository.findByAttendanceGreaterThanEqual(attendance);
  }

  // Get notes by student ID and class ID
  public List<Note> getNotesByStudentIdAndClassId(int studentId, int classId) {
    return noteRepository.findByStudentIdAndClassId(studentId, classId);
  }

  // Additional business logic methods can be added here if needed
}
