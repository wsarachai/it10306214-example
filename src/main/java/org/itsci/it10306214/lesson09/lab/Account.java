package org.itsci.it10306214.lesson09.lab;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.itsci.it10306214.DateUtils;

@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @Column(name = "account_no", length = 10, nullable = false)
  private String accountNo;
  @Column(name = "account_name", length = 50, nullable = false)
  private String name;
  @Column(name = "account_open_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date openDate;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "type_id")
  private AccountType type;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "branch_id")
  private Branch branch;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "account_no")
  private Set<ItemAccount> itemAccount = new HashSet<ItemAccount>();

  public Account() {
  }

  public Account(String accountNo, String name, String openDate, AccountType accountType, Branch branch) {
    this.accountNo = accountNo;
    this.name = name;
    this.openDate = DateUtils.StringToDate(openDate);
    this.type = accountType;
    this.branch = branch;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AccountType getType() {
    return type;
  }

  public void setType(AccountType type) {
    this.type = type;
  }

  public Branch getBranch() {
    return branch;
  }

  public void setBranch(Branch branch) {
    this.branch = branch;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public Date getOpenDate() {
    return openDate;
  }

  public void setOpenDate(Date openDate) {
    this.openDate = openDate;
  }

  public Set<ItemAccount> getItemAccount() {
    return itemAccount;
  }

  public void setItemAccount(Set<ItemAccount> itemAccount) {
    this.itemAccount = itemAccount;
  }

}
