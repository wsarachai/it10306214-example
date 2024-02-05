package org.itsci.it10306214.lesson09.ex04;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private int age;
  private String major;
  @ElementCollection
  @CollectionTable(name = "certifications", joinColumns = @JoinColumn(name = "student_id"))
  private Collection<Certification> certificates = new ArrayList<Certification>();

  public Student() {
  }

  public Student(String name, int age, String major) {
    this.name = name;
    this.age = age;
    this.major = major;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public Collection<Certification> getCertificates() {
    return certificates;
  }

  public void setCertificates(Collection<Certification> certificates) {
    this.certificates = certificates;
  }

}
