package org.itsci.it10306103.lesson09.ex07;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "registrations")
public class Registration {
  @EmbeddedId
  private RegistrationId id = new RegistrationId();
  private String grade;

  public Registration() {
  }

  public Registration(RegistrationId id, String grade) {
    this.id = id;
    this.grade = grade;
  }

  public RegistrationId getId() {
    return id;
  }

  public void setId(RegistrationId id) {
    this.id = id;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

}
