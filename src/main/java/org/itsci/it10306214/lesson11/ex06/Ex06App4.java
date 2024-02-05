package org.itsci.it10306214.lesson11.ex06;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson11.Doctor;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Patient;

public class Ex06App4 {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Tuple> cq = cb.createTupleQuery();
    Root<Doctor> root = cq.from(Doctor.class);
    Join<Object, Object> patientJoin = root.join("patients", JoinType.INNER);

    cq.multiselect(root, patientJoin);

    ParameterExpression<String> sickness = cb.parameter(String.class);
    cq.where(cb.like(patientJoin.get("sickness").as(String.class), sickness));

    TypedQuery<Tuple> q = session.createQuery(cq);
    q.setParameter(sickness, "%ache%");
    List<Tuple> tuples = q.getResultList();

    for (Tuple tuple : tuples) {
      Doctor doctor = (Doctor) tuple.get(0);
      Patient patient = (Patient) tuple.get(1);
      System.out.println(doctor);
      System.out.println("**** " + patient);
    }

  }
}
