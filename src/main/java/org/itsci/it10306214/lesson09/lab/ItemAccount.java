package org.itsci.it10306214.lesson09.lab;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "item_accounts")
public class ItemAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "item_id")
  private int id;
  @Column(name = "item_date", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date itemDate;
  @Column(name = "item_type", length = 4, nullable = false)
  private String type;
  @Column(name = "item_amount", nullable = false)
  private double amount;
  @ManyToOne
  @JoinColumn(name = "branch_id")
  private Branch branch;
  // @ManyToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name = "account_no")
  // private Account account;

  public ItemAccount() {
  }

  public ItemAccount(Date itemDate, String type, double amount, Branch branch) {
    this.itemDate = itemDate;
    this.type = type;
    this.amount = amount;
    this.branch = branch;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getItemDate() {
    return itemDate;
  }

  public void setItemDate(Date itemDate) {
    this.itemDate = itemDate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Branch getBranch() {
    return branch;
  }

  public void setBranch(Branch branch) {
    this.branch = branch;
  }

  // public Account getAccount() {
  // return account;
  // }

  // public void setAccount(Account account) {
  // this.account = account;
  // }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ItemAccount other = (ItemAccount) obj;
    if (id != other.id)
      return false;
    return true;
  }

}
