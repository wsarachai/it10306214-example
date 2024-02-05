package org.itsci.it10306103.lesson09.ex06;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "training_courses")
public class TrainingCourse {
  @EmbeddedId
  private TrainingCourseId trainingCourseId;
  private String courseName;
  private int capacity;
  private double fee;

  public TrainingCourse() {
  }

  public TrainingCourse(TrainingCourseId trainingCourseId, String courseName, int capacity, int fee) {
    this.trainingCourseId = trainingCourseId;
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
