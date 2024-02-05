package org.itsci.it10306103.lesson11.ex06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.it10306103.lesson11.Doctor;
import org.itsci.it10306103.lesson11.HibernateConnection;
import org.itsci.it10306103.lesson11.Patient;

public class Ex06App7 {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    String hql = "select D, P from Doctor as D right outer join D.patients as P";
    Query<Object[]> query = session.createQuery(hql, Object[].class);
    List<Object[]> list = query.getResultList();

    for (Object[] row : list) {
      Doctor doctor = (Doctor) row[0];
      Patient patient = (Patient) row[1];
      System.out.println(doctor);
      if (patient != null)
        System.out.println(" ==> " + patient);
    }

  }
}
