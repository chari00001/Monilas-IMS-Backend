package com.ims.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "faculty", nullable = false, length = 255)
  private String faculty;

  @Column(name = "department_head_id", nullable = false)
  private int departmentHead;

  // Getters and Setters
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

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public int getDepartmentHead() {
    return departmentHead;
  }

  public void setDepartmentHead(int departmentHead) {
    this.departmentHead = departmentHead;
  }

}
