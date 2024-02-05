package org.itsci.it10306214.lab.lab07;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "general_ledger_accounts")
public class GeneralLedgerAccount {

  @Id
  @Column(name = "account_number")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer accountNumber;
  @Column(name = "account_description", nullable = false, length = 50)
  private String accountDescription;

  public Integer getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountDescription() {
    return accountDescription;
  }

  public void setAccountDescription(String accountDescription) {
    this.accountDescription = accountDescription;
  }

  @Override
  public String toString() {
    return "GeneralLedgerAccount [accountNumber=" + accountNumber + ", accountDescription=" + accountDescription + "]";
  }

}
