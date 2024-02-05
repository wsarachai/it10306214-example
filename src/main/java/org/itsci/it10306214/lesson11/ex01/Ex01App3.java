package org.itsci.it10306103.lesson11.ex01;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306103.lesson11.HibernateConnection;
import org.itsci.it10306103.lesson11.Student;

public class Ex01App3 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Student> root = criteria.from(Student.class);

        Path<Long> idPath = root.get("id");
        Path<String> namePath = root.get("name");

        criteria.select(builder.array(idPath, namePath));
        criteria.where(builder.equal(root.get("name"), "Somchai Jaidee"));

        List<Object[]> results = session.createQuery(criteria).getResultList();
        for (Object[] objs : results) {
            System.out.println("ID: " + objs[0]);
            System.out.println("Name: " + objs[1]);
        }

    }
}
