package org.itsci.it10306214.lesson09.ex01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
