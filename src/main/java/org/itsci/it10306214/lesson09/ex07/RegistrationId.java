package org.itsci.it10306103.lesson09.ex07;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RegistrationId implements Serializable {
  private static final long serialVersionUID = 1L;

  @ManyToOne
  private Student student;
  @ManyToOne
  private Course course;

  public RegistrationId() {
  }

  public RegistrationId(Student student, Course course) {
    this.student = student;
    this.course = course;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

}
