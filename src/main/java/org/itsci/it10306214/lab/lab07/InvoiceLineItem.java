package org.itsci.it10306214.lab.lab07;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_line_items")
public class InvoiceLineItem {
  @Id
  @Column(name = "terms_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer termsId;

}
