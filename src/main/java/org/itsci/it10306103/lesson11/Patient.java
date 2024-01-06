package org.itsci.it10306103.lesson11;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String sickness;
  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  public Patient() {
  }

  public Patient(String name, String sickness) {
    this.name = name;
    this.sickness = sickness;
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

  public String getSickness() {
    return sickness;
  }

  public void setSickness(String sickness) {
    this.sickness = sickness;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  @Override
  public String toString() {
    return "Patient [id=" + id + ", name=" + name + ", sickness=" + sickness + "]";
  }

}
