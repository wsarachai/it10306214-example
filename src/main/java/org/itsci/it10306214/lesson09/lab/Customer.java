package org.itsci.it10306214.lesson09.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private int id;
  @Column(name = "customer_name", length = 50, nullable = false)
  private String name;
  @Column(name = "customer_address", length = 100, nullable = false)
  private String address;
  @Column(name = "customer_email", length = 50, nullable = false)
  private String email;
  @Column(name = "customer_tel", length = 50, nullable = false)
  private String tel;

  public Customer() {
  }

  public Customer(String name, String address, String email, String tel) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.tel = tel;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

}
