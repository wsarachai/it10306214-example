package org.itsci.it10306214.lesson09.ex06;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
  static String url = "jdbc:mysql://localhost:3306/it214db";
  static String uname = "root";
  static String pwd = "1234";

  public static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    Properties database = new Properties();

    database.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
    database.setProperty("hibernate.connection.username", uname);
    database.setProperty("hibernate.connection.password", pwd);
    database.setProperty("hibernate.connection.url", url);
    database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
    database.setProperty("hibernate.dialect.storage_engine", "innodb");
    database.setProperty("hibernate.hbm2ddl.auto", "update");
    Configuration cfg = new Configuration().setProperties(database)
        .addPackage("bean")
        .addAnnotatedClass(TrainingCourse.class);
    StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
    sessionFactory = cfg.buildSessionFactory(ssrb.build());

    return sessionFactory;
  }
}
