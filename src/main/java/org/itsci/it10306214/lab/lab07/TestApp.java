package org.itsci.it10306214.lab.lab07;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      String hql = "FROM Vendor";
      Query<Vendor> query = session.createQuery(hql, Vendor.class);
      query.setFirstResult(0);
      query.setMaxResults(10);

      List<Vendor> vendors = query.getResultList();
      System.out.println("                       --- List of Vendor ---");
      System.out.println("--------------------------------------------------------------------------");
      System.out.printf("%-10s| %-32s| %s\n", "Vendor ID", "Name", "Address");
      System.out.println("--------------------------------------------------------------------------");
      for (Vendor vendor : vendors) {
        Integer vendorId = vendor.getVendorId();
        String vendorName = vendor.getVendorContact() == null ? vendor.getVendorName()
            : vendor.getVendorContact().getFirstName() + " " + vendor.getVendorContact().getLastName();
        System.out.printf("    %-6d| %-31s | %s\n", vendorId,
            vendorName,
            vendor.getVendorAddress1());
        GeneralLedgerAccount defaultAccount = vendor.getDefaultAccount();
        if (defaultAccount != null) {
          System.out.printf("    %-6s%s%10s { %s, %s }\n", "",
              "-->", "Account: ", "number=" + defaultAccount.getAccountNumber(),
              "description=" + defaultAccount.getAccountDescription());
        }
        Term defaultTerm = vendor.getDetaultTerm();
        if (defaultTerm != null) {
          System.out.printf("    %-6s%s%10s { %s, %s, %s }\n", "",
              "-->", "Term: ", "id=" + defaultTerm.getTermsId(),
              "description=" + defaultTerm.getTermsDescripton(),
              "due days=" + defaultTerm.getTermsDueDays());
        }
      }
      System.out.println("--------------------------------------------------------------------------");
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
