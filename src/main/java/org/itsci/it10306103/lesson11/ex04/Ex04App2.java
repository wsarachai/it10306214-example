package org.itsci.it10306103.lesson11.ex04;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306103.lesson11.HibernateConnection;
import org.itsci.it10306103.lesson11.Student;

public class Ex04App2 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Student> root = criteria.from(Student.class);

        criteria.multiselect(builder.min(root.get("gpa").as(Double.class)),
                builder.max(root.get("gpa").as(Double.class)));
        criteria.where(builder.greaterThan(root.get("age").as(Double.class), 21.0));

        Object[] results = session.createQuery(criteria).getSingleResult();
        System.out.printf("GPA min: %.2f, GPA max: %.2f", results[0], results[1]);

    }
}
