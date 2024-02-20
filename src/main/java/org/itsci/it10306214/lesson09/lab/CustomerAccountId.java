package org.itsci.it10306214.lesson09.lab;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CustomerAccountId implements Serializable {
  private static final long serialVersionUID = 1L;

  @ManyToOne
  private Customer customer;
  @ManyToOne
  private Account account;

  public CustomerAccountId() {
  }

  public CustomerAccountId(Customer customer, Account account) {
    this.customer = customer;
    this.account = account;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((customer == null) ? 0 : customer.hashCode());
    result = prime * result + ((account == null) ? 0 : account.hashCode());
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
    CustomerAccountId other = (CustomerAccountId) obj;
    if (customer == null) {
      if (other.customer != null)
        return false;
    } else if (!customer.equals(other.customer))
      return false;
    if (account == null) {
      if (other.account != null)
        return false;
    } else if (!account.equals(other.account))
      return false;
    return true;
  }

}
