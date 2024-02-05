package org.itsci.it10306214.lesson11.ex06;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.it10306214.lesson11.Doctor;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Patient;

public class Ex06App3 {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    String hql = "SELECT d, p FROM Doctor d JOIN d.patients p WHERE p.sickness LIKE '%ache%'";

    Query<Object[]> query = session.createQuery(hql, Object[].class);
    List<Object[]> results = query.getResultList();

    for (Object[] objs : results) {
      Doctor doctor = (Doctor) objs[0];
      Patient patient = (Patient) objs[1];
      System.out.println(doctor);
      System.out.println("**** " + patient);
    }
  }
}
