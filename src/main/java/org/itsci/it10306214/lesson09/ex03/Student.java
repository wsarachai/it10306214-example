package org.itsci.it10306103.lesson09.ex03;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Embedded
  private Certification certification;

  public Student() {
  }

  public Student(String name, int age, String major, Certification cer) {
    this.name = name;
    this.age = age;
    this.major = major;
    this.certification = cer;
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

  public Certification getCertification() {
    return certification;
  }

  public void setCertification(Certification certification) {
    this.certification = certification;
  }

}
