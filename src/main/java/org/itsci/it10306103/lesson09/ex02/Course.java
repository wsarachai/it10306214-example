package org.itsci.it10306103.lesson09.ex02;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
  @Id
  // @Column(name = "course_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private int credit;
  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
  private Set<Student> students = new HashSet<Student>();

  public Course() {
  }

  public Course(String name, int credit) {
    this.name = name;
    this.credit = credit;
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

  public int getCredit() {
    return credit;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }

  public Set<Student> getStudents() {
    return students;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
  }

}
