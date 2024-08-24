package com.ims.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "student_id", nullable = false)
  private int studentId;

  @Column(name = "class_id", nullable = false)
  private int classId;

  @Column(name = "grade", length = 2)
  private String grade;

  @Column(name = "points")
  private int points;

  @Column(name = "attendance")
  private int attendance;

  @Column(name = "type", length = 50)
  private String type;

  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getClassId() {
    return classId;
  }

  public void setClassId(int classId) {
    this.classId = classId;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public int getAttendance() {
    return attendance;
  }

  public void setAttendance(int attendance) {
    this.attendance = attendance;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
