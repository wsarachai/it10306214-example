package org.itsci.it10306214.lesson09.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
public class Branch {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "branch_id")
  private int id;
  @Column(name = "branch_name", length = 50, nullable = false)
  private String name;

  public Branch() {
  }

  public Branch(String branchName) {
    this.name = branchName;
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
}
