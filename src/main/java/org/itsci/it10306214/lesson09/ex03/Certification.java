package org.itsci.it10306214.lesson09.ex03;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Certification {
  private String cerName;
  private String level;
  private Date issueDate;

  public Certification() {
  }

  public Certification(String cerName, String level, Date issueDate) {
    this.cerName = cerName;
    this.level = level;
    this.issueDate = issueDate;
  }

  public String getCerName() {
    return cerName;
  }

  public void setCerName(String cerName) {
    this.cerName = cerName;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public Date getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }

}
