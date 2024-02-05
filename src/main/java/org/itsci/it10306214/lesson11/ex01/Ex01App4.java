package org.itsci.it10306214.lesson11.ex01;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Student;

public class Ex01App4 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
        Root<Student> root = criteria.from(Student.class);

        Path<Integer> idPath = root.get("id");
        Path<String> studentNamePath = root.get("name");

        criteria.multiselect(idPath, studentNamePath);
        criteria.where(builder.equal(root.get("name"), "Somchai Jaidee"));

        List<Tuple> results = session.createQuery(criteria).getResultList();

        for (Tuple tuple : results) {
            Integer id = tuple.get(idPath);
            String studentName = tuple.get(studentNamePath);
            System.out.println("ID: " + id + ", Name: " + studentName);
        }
    }
}
