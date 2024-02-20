package org.itsci.it10306214.lesson09.ex07;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((student == null) ? 0 : student.hashCode());
    result = prime * result + ((course == null) ? 0 : course.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RegistrationId other = (RegistrationId) obj;
    if (student == null) {
      if (other.student != null)
        return false;
    } else if (!student.equals(other.student))
      return false;
    if (course == null) {
      if (other.course != null)
        return false;
    } else if (!course.equals(other.course))
      return false;
    return true;
  }

}
