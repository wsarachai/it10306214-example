package org.itsci.it10306214.lesson10.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLApp {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    // STEP 1: Register JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // STEP 2: Open a connection
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/it214db", "root", "1234");

    // STEP 3: Execute a query
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM students");

    // STEP 4: Process the result set
    while (rs.next()) {
      // Retrieve by column name
      int id = rs.getInt("id");
      String name = rs.getString("name");
      int age = rs.getInt("age");
      String major = rs.getString("major");
      double gpa = rs.getDouble("gpa");

      // Display values
      System.out.print("ID: " + id);
      System.out.print(", Name: " + name);
      System.out.print(", Age: " + age);
      System.out.print(", Major: " + major);
      System.out.println(", GPA: " + gpa);
    }

    // STEP 5: Clean-up environment
    rs.close();
    stmt.close();
    conn.close();
  }
}
