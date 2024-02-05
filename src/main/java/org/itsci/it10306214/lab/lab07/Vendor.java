package org.itsci.it10306214.lab.lab07;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {

  @Id
  @Column(name = "vendor_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer vendorId;
  @Column(name = "vendor_name", nullable = false, length = 50)
  private String vendorName;
  @Column(name = "vendor_address1", length = 50)
  private String vendorAddress1;
  @Column(name = "vendor_address2", length = 50)
  private String vendorAddress2;
  @Column(name = "vendor_city", nullable = false, length = 50)
  private String vendorCity;
  @Column(name = "vendor_state", nullable = false, length = 2)
  private String vendorState;
  @Column(name = "vendor_zip_code", nullable = false, length = 20)
  private String vendorZipCode;
  @Column(name = "vendor_phone", length = 50)
  private String vendorPhone;
  @Column(name = "vendor_contact_last_name", length = 50)
  private String vendorContactLastName;
  @Column(name = "vendor_contact_first_name", length = 50)
  private String vendorContactFirstName;
  @OneToOne(cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private VendorContact vendorContact;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "default_terms_id")
  private Term detaultTerm;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "default_account_number")
  private GeneralLedgerAccount defaultAccount;

  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public String getVendorAddress1() {
    return vendorAddress1;
  }

  public void setVendorAddress1(String vendorAddress1) {
    this.vendorAddress1 = vendorAddress1;
  }

  public String getVendorAddress2() {
    return vendorAddress2;
  }

  public void setVendorAddress2(String vendorAddress2) {
    this.vendorAddress2 = vendorAddress2;
  }

  public String getVendorCity() {
    return vendorCity;
  }

  public void setVendorCity(String vendorCity) {
    this.vendorCity = vendorCity;
  }

  public String getVendorState() {
    return vendorState;
  }

  public void setVendorState(String vendorState) {
    this.vendorState = vendorState;
  }

  public String getVendorZipCode() {
    return vendorZipCode;
  }

  public void setVendorZipCode(String vendorZipCode) {
    this.vendorZipCode = vendorZipCode;
  }

  public String getVendorPhone() {
    return vendorPhone;
  }

  public void setVendorPhone(String vendorPhone) {
    this.vendorPhone = vendorPhone;
  }

  public String getVendorContactLastName() {
    return vendorContactLastName;
  }

  public void setVendorContactLastName(String vendorContactLastName) {
    this.vendorContactLastName = vendorContactLastName;
  }

  public String getVendorContactFirstName() {
    return vendorContactFirstName;
  }

  public void setVendorContactFirstName(String vendorContactFirstName) {
    this.vendorContactFirstName = vendorContactFirstName;
  }

  public VendorContact getVendorContact() {
    return vendorContact;
  }

  public void setVendorContact(VendorContact vendorContact) {
    this.vendorContact = vendorContact;
  }

  public Term getDetaultTerm() {
    return detaultTerm;
  }

  public void setDetaultTerm(Term detaultTerm) {
    this.detaultTerm = detaultTerm;
  }

  public GeneralLedgerAccount getDefaultAccount() {
    return defaultAccount;
  }

  public void setDefaultAccount(GeneralLedgerAccount defaultAccount) {
    this.defaultAccount = defaultAccount;
  }

  @Override
  public String toString() {
    return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorAddress1=" + vendorAddress1
        + ", vendorAddress2=" + vendorAddress2 + ", vendorCity=" + vendorCity + ", vendorState=" + vendorState
        + ", vendorZipCode=" + vendorZipCode + ", vendorPhone=" + vendorPhone + ", vendorContactLastName="
        + vendorContactLastName + ", vendorContactFirstName=" + vendorContactFirstName + ", vendorContact="
        + vendorContact + "]";
  }

}
