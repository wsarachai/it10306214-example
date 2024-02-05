package org.itsci.it10306103.lesson11;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String specialist;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
  private Set<Patient> patients = new HashSet<Patient>();

  public Doctor() {
  }

  public Doctor(String name, String specialist) {
    this.name = name;
    this.specialist = specialist;
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

  public String getSpecialist() {
    return specialist;
  }

  public void setSpecialist(String specialist) {
    this.specialist = specialist;
  }

  public Set<Patient> getPatients() {
    return patients;
  }

  public void setPatients(Set<Patient> patients) {
    this.patients = patients;
  }

  @Override
  public String toString() {
    return "Doctor [id=" + id + ", name=" + name + ", specialist=" + specialist + "]";
  }

}
