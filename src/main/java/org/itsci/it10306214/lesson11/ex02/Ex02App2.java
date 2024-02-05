package org.itsci.it10306214.lesson11.ex02;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Student;

public class Ex02App2 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("name"), "Somchai Jaidee"));

        List<Student> results = session.createQuery(criteria).getResultList();

        for (Student stu : results) {
            System.out.println(stu);
        }

    }
}
