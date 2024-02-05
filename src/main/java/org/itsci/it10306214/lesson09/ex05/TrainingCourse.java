package org.itsci.it10306214.lesson09.ex05;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "training_courses")
@IdClass(TrainingCourseId.class)
public class TrainingCourse {
  @Id
  private String course;
  @Id
  private Date day;

  private String courseName;
  private int capacity;
  private double fee;

  public TrainingCourse() {
  }

  public TrainingCourse(String course, Date day, String courseName, int capacity, int fee) {
    this.course = course;
    this.day = day;
    this.courseName = courseName;
    this.capacity = capacity;
    this.fee = fee;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public double getFee() {
    return fee;
  }

  public void setFee(double fee) {
    this.fee = fee;
  }

}
