package org.itsci.it10306214.lesson10.ex03;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CompanyManager {

    public void addCompany(Company company) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public Company getCompany(int id) {
        Company company = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            company = session.get(Company.class, id);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return company;
    }

    public List<Company> listAllCompanies() {
        List<Company> companies = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query<Company> query = session.createQuery("from Company", Company.class);
            companies = query.getResultList();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return companies;
    }

    public List<Company> listCompaniesByAddress(String address) {
        List<Company> companies = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query<Company> query = session.createQuery("from Company where address = :address", Company.class);
            query.setParameter("address", address);
            companies = query.getResultList();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return companies;
    }

    public List<Company> listCompaniesByAddressAndName(String address, String name) {
        List<Company> companies = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query<Company> query = session.createQuery("from Company where address = :address and name = :name",
                    Company.class);
            query.setParameter("address", address);
            query.setParameter("name", name);
            companies = query.getResultList();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return companies;
    }

    public void updateCompany(Company company) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.saveOrUpdate(company);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public void deleteCompanyById(int id) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Company company = session.get(Company.class, id);
            session.delete(company);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }
}
