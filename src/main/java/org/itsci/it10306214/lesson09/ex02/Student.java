package org.itsci.it10306214.lesson09.ex02;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "student_id")
  private int id;
  private String name;
  private int age;
  private String major;
  @ManyToMany(cascade = { CascadeType.ALL })
  // @JoinTable(name = "students_courses", joinColumns = { @JoinColumn(name =
  // "student_id") }, inverseJoinColumns = {
  // @JoinColumn(name = "course_id") })
  private Set<Course> courses = new HashSet<Course>();

  public Student() {
  }

  public Student(String name, int age, String major) {
    this.name = name;
    this.age = age;
    this.major = major;
  }

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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Set<Course> getCourses() {
    return courses;
  }

  public void setCourses(Set<Course> courses) {
    this.courses = courses;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

}
