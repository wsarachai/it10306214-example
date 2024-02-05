package org.itsci.it10306214.lesson11.ex01;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Student;

public class Ex01App2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Student> root = criteria.from(Student.class);

        criteria.multiselect(root.get("name"));
        criteria.where(builder.equal(root.get("name"), "Somchai Jaidee"));

        List<String> results = session.createQuery(criteria).getResultList();
        for (String stu : results) {
            System.out.println(stu);
        }

    }
}
