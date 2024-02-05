package org.itsci.it10306103.lesson09.ex05;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class TrainingCourseId implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(length = 10)
  private String course;
  private Date day;

  public TrainingCourseId() {
  }

  public TrainingCourseId(String course, Date day) {
    this.course = course;
    this.day = day;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((course == null) ? 0 : course.hashCode());
    result = prime * result + ((day == null) ? 0 : day.hashCode());
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
    TrainingCourseId other = (TrainingCourseId) obj;
    if (course == null) {
      if (other.course != null)
        return false;
    } else if (!course.equals(other.course))
      return false;
    if (day == null) {
      if (other.day != null)
        return false;
    } else if (!day.equals(other.day))
      return false;
    return true;
  }

}
