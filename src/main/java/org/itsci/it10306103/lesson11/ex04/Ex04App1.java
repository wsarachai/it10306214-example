package org.itsci.it10306103.lesson11.ex04;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306103.lesson11.HibernateConnection;
import org.itsci.it10306103.lesson11.Student;

public class Ex04App1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Double> criteria = builder.createQuery(Double.class);
        Root<Student> root = criteria.from(Student.class);

        Expression<Double> avgGPA = builder.function("round",
                Double.class,
                builder.avg(root.get("gpa").as(Double.class)),
                builder.literal(2));

        criteria.multiselect(avgGPA);

        Double result = session.createQuery(criteria).uniqueResult();
        System.out.println(result);
    }

}
