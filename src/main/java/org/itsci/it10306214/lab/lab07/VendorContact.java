package org.itsci.it10306214.lab.lab07;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_contacts")
class VendorContact {

  @Id
  @Column(name = "vendor_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer vendorId;
  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;
  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String toString() {
    return "VendorContact [vendorId=" + vendorId + ", lastName=" + lastName + ", firstName=" + firstName + "]";
  }

}