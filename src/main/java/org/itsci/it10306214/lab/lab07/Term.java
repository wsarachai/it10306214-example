package org.itsci.it10306214.lab.lab07;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terms")
public class Term {
  @Id
  @Column(name = "terms_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer termsId;
  @Column(name = "terms_description", nullable = false, length = 50)
  private String termsDescripton;
  @Column(name = "terms_due_days")
  private Integer termsDueDays;

  public Integer getTermsId() {
    return termsId;
  }

  public void setTermsId(Integer termsId) {
    this.termsId = termsId;
  }

  public String getTermsDescripton() {
    return termsDescripton;
  }

  public void setTermsDescripton(String termsDescripton) {
    this.termsDescripton = termsDescripton;
  }

  public Integer getTermsDueDays() {
    return termsDueDays;
  }

  public void setTermsDueDays(Integer termsDueDays) {
    this.termsDueDays = termsDueDays;
  }

  @Override
  public String toString() {
    return "Term [termsId=" + termsId + ", termsDescripton=" + termsDescripton + ", termsDueDays=" + termsDueDays + "]";
  }

}
