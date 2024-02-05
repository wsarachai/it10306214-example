package org.itsci.it10306214.lab.lab07;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "invoices")
public class Invoice {
  @Id
  @Column(name = "invoice_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer invoiceId;
  @Column(name = "invoice_number", nullable = false, length = 50)
  private String invoiceNumber;
  @Temporal(TemporalType.DATE)
  @Column(name = "invoice_date", nullable = false)
  private Date invoiceDate;
  @Column(name = "invoice_total", nullable = false, precision = 9, scale = 2)
  private Double invoiceTotal;
  @Column(name = "payment_total", nullable = false, precision = 9, scale = 2)
  private Double paymentTotal;
  @Column(name = "credit_total", nullable = false, precision = 9, scale = 2)
  private Double creditTotal;
  @Column(name = "invoice_due_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date invoiceDueDate;
  @Column(name = "payment_date")
  @Temporal(TemporalType.DATE)
  private Date paymentDate;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "vendor_id")
  private Vendor vendor;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "terms_id")
  private Term term;

  public Integer getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(Integer invoiceId) {
    this.invoiceId = invoiceId;
  }

  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public Date getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public Double getInvoiceTotal() {
    return invoiceTotal;
  }

  public void setInvoiceTotal(Double invoiceTotal) {
    this.invoiceTotal = invoiceTotal;
  }

  public Double getPaymentTotal() {
    return paymentTotal;
  }

  public void setPaymentTotal(Double paymentTotal) {
    this.paymentTotal = paymentTotal;
  }

  public Double getCreditTotal() {
    return creditTotal;
  }

  public void setCreditTotal(Double creditTotal) {
    this.creditTotal = creditTotal;
  }

  public Date getInvoiceDueDate() {
    return invoiceDueDate;
  }

  public void setInvoiceDueDate(Date invoiceDueDate) {
    this.invoiceDueDate = invoiceDueDate;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public Vendor getVendor() {
    return vendor;
  }

  public void setVendor(Vendor vendor) {
    this.vendor = vendor;
  }

  public Term getTerm() {
    return term;
  }

  public void setTerm(Term term) {
    this.term = term;
  }

  @Override
  public String toString() {
    return "Invoice [invoiceId=" + invoiceId + ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate
        + ", invoiceTotal=" + invoiceTotal + ", paymentTotal=" + paymentTotal + ", creditTotal=" + creditTotal
        + ", invoiceDueDate=" + invoiceDueDate + ", paymentDate=" + paymentDate + "]";
  }

}
