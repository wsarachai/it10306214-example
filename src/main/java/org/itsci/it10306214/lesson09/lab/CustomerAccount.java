package org.itsci.it10306214.lesson09.lab;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer_accounts")
public class CustomerAccount {
  @EmbeddedId
  private CustomerAccountId id = new CustomerAccountId();

  public CustomerAccount() {
  }

  public CustomerAccount(CustomerAccountId id) {
    this.id = id;
  }

  public CustomerAccountId getId() {
    return id;
  }

  public void setId(CustomerAccountId id) {
    this.id = id;
  }

}
