package com.entity;


import java.util.List;

public class Class {

  private long id;
  private String name;
  private String classCode;
  private Teacher teacher;
  private List<Student> studentList;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getClassCode() {
    return classCode;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }


  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }

  @Override
  public String toString() {
    return "Class{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", classCode='" + classCode + '\'' +
            ", teacher=" + teacher +
            ", studentList=" + studentList +
            '}';
  }
}
