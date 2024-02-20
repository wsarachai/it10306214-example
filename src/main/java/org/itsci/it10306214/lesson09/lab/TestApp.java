package org.itsci.it10306214.lesson09.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.DateUtils;

public class TestApp {

  public static void populateAccountType() {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      AccountType accountType1 = new AccountType("ออมทรัพย์");
      AccountType accountType2 = new AccountType("ประจำ");
      AccountType accountType3 = new AccountType("เผื่อเรียก");

      session.save(accountType1);
      session.save(accountType2);
      session.save(accountType3);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }

  public static void populateBranch() {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      Branch branch1 = new Branch("แม่โจ้");
      Branch branch2 = new Branch("ตลาดมีโชค");
      Branch branch3 = new Branch("ท่าแพ");

      session.save(branch1);
      session.save(branch2);
      session.save(branch3);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }

  public static void populateCustomer() {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      Customer customer1 = new Customer("สายัณห์ อุ่นนันกาศ", "92/69 ม.5 ต.สันทรายน้อย อ.สันทราย จ.เชียงใหม่ 50210",
          "sayan@itsci.com", "089-4333333");
      Customer customer2 = new Customer("นพรัตน์ สร้อยโพธิ์พันธ์", "43 ม.2 ต.หนองหาร อ.สันทราย จ.เชียงใหม่ 50290",
          "noprut@itsci.com", "087-4234039");
      Customer customer3 = new Customer("นุชนาถ เพ็งมาก", "112 ม.5 ต.หนองหาร อ.สันทราย จ.เชียงใหม่ 50290",
          "nuchanat@itsci.com", "084-2132334");
      Customer customer4 = new Customer("วรรณวิมล นาดี", "125 ต.ช้างคลาน อ.เมือง จ.เชียงใหม่ 50100",
          "wanwimon@itsci.com", "053-254345");

      session.save(customer1);
      session.save(customer2);
      session.save(customer3);
      session.save(customer4);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }

  public static void populateAccount() {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      AccountType accountType1 = session.get(AccountType.class, 1);
      Branch branch1 = session.get(Branch.class, 2);
      Customer customer1 = session.get(Customer.class, 1);
      Account account1 = new Account("6520000001", customer1.getName(), "15-03-2557", accountType1, branch1);

      AccountType accountType2 = session.get(AccountType.class, 1);
      Branch branch2 = session.get(Branch.class, 1);
      Customer customer2 = session.get(Customer.class, 2);
      Account account2 = new Account("6520000002", customer2.getName(), "15-04-2557", accountType2, branch2);

      AccountType accountType3 = session.get(AccountType.class, 1);
      Branch branch3 = session.get(Branch.class, 1);
      Customer customer3 = session.get(Customer.class, 3);
      Account account3 = new Account("6520000003", customer3.getName(), "25-04-2558", accountType3, branch3);

      AccountType accountType4 = session.get(AccountType.class, 2);
      Branch branch4 = session.get(Branch.class, 3);
      Customer customer4 = session.get(Customer.class, 4);
      Account account4 = new Account("6340000001", customer4.getName(), "25-04-2558", accountType4, branch4);

      AccountType accountType5 = session.get(AccountType.class, 1);
      Branch branch5 = session.get(Branch.class, 3);
      Account account5 = new Account("6340000002", customer1.getName(), "28-06-2558", accountType5, branch5);

      CustomerAccount customerAccount1 = new CustomerAccount(new CustomerAccountId(customer1, account1));
      CustomerAccount customerAccount2 = new CustomerAccount(new CustomerAccountId(customer2, account2));
      CustomerAccount customerAccount3 = new CustomerAccount(new CustomerAccountId(customer3, account3));
      CustomerAccount customerAccount4 = new CustomerAccount(new CustomerAccountId(customer4, account4));
      CustomerAccount customerAccount5 = new CustomerAccount(new CustomerAccountId(customer1, account5));
      CustomerAccount customerAccount6 = new CustomerAccount(new CustomerAccountId(customer3, account5));

      session.save(account1);
      session.save(account2);
      session.save(account3);
      session.save(account4);
      session.save(account5);

      session.save(customerAccount1);
      session.save(customerAccount2);
      session.save(customerAccount3);
      session.save(customerAccount4);
      session.save(customerAccount5);
      session.save(customerAccount6);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }

  public static void populateItemAccount() {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      URL path = ClassLoader.getSystemResource("ItemAccount.csv");
      if (path == null) {
        throw new FileNotFoundException("File not found");
      }
      File f = new File(path.toURI());
      BufferedReader reader = new BufferedReader(new FileReader(f));
      Scanner sc = new Scanner(reader);
      while (sc.hasNext()) {
        String line = sc.nextLine();
        String[] arr = line.split(",");
        Account account = session.get(Account.class, arr[0]);
        Branch branch = session.get(Branch.class, Integer.parseInt(arr[4]));
        Date itemDate = DateUtils.StringToDate(arr[1], "dd/MM/yyyy hh:mm:ss");
        ItemAccount itemAccount = new ItemAccount(itemDate, arr[2],
            Double.parseDouble(arr[3]), branch);
        // itemAccount.setAccount(account);
        account.getItemAccount().add(itemAccount);

        session.saveOrUpdate(itemAccount);
      }
      sc.close();

      session.getTransaction().commit();
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }

  }

  public static void createTables() {
    HibernateConnection.getSessionFactory();
  }

  public static void main(String[] args) {
    populateAccountType();
    populateBranch();
    populateCustomer();
    populateAccount();
    populateItemAccount();
    // createTables();
  }
}
