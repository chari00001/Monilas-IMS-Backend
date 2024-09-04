package com.ims.controller;

import com.ims.model.Note;
import com.ims.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notes")
public class NoteController {

  @Autowired
  private NoteService noteService;

  // Get all notes
  @GetMapping
  public List<Note> getAllNotes() {
    return noteService.getAllNotes();
  }

  // Get a note by ID
  @GetMapping("/{id}")
  public ResponseEntity<Note> getNoteById(@PathVariable Integer id) {
    Optional<Note> note = noteService.getNoteById(id);
    return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Get notes by student ID
  @GetMapping("/student/{studentId}")
  public List<Note> getNotesByStudentId(@PathVariable int studentId) {
    return noteService.getNotesByStudentId(studentId);
  }

  // Get notes by class ID
  @GetMapping("/class/{classId}")
  public List<Note> getNotesByClassId(@PathVariable int classId) {
    return noteService.getNotesByClassId(classId);
  }

  // Get notes by grade
  @GetMapping("/grade/{grade}")
  public List<Note> getNotesByGrade(@PathVariable String grade) {
    return noteService.getNotesByGrade(grade);
  }

  // Get notes by type
  @GetMapping("/type/{type}")
  public List<Note> getNotesByType(@PathVariable String type) {
    return noteService.getNotesByType(type);
  }

  // Get notes by points greater than or equal to a certain value
  @GetMapping("/points")
  public List<Note> getNotesByPointsGreaterThanEqual(@RequestParam int points) {
    return noteService.getNotesByPointsGreaterThanEqual(points);
  }

  // Get notes with attendance greater than or equal to a certain value
  @GetMapping("/attendance")
  public List<Note> getNotesByAttendanceGreaterThanEqual(@RequestParam int attendance) {
    return noteService.getNotesByAttendanceGreaterThanEqual(attendance);
  }

  // Get notes by student ID and class ID
  @GetMapping("/student/{studentId}/class/{classId}")
  public List<Note> getNotesByStudentIdAndClassId(@PathVariable int studentId, @PathVariable int classId) {
    return noteService.getNotesByStudentIdAndClassId(studentId, classId);
  }

  // Create or update a note
  @PostMapping
  public Note createOrUpdateNote(@RequestBody Note note) {
    return noteService.saveNote(note);
  }

  // Delete a note by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNoteById(@PathVariable Integer id) {
    if (noteService.getNoteById(id).isPresent()) {
      noteService.deleteNoteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
