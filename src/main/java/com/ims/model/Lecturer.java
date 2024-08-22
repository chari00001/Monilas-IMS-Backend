package com.ims.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "email", nullable = false, unique = false, length = 100)
  private String email;

  @Column(name = "qualification", nullable = false, length = 50)
  private String qualification;

  @Column(name = "department_id", nullable = false)
  private int departmentId;

  @Column(name = "isDepartmentHead", nullable = false)
  private boolean isDepartmentHead;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public boolean isDepartmentHead() {
    return isDepartmentHead;
  }

  public void setDepartmentHead(boolean isDepartmentHead) {
    this.isDepartmentHead = isDepartmentHead;
  }
}
