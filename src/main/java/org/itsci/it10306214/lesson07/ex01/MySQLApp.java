package org.itsci.it10306103.lesson07.ex01;

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

      // Display values
      System.out.println("ID: " + id);
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
    }

    // STEP 5: Clean-up environment
    rs.close();
    stmt.close();
    conn.close();
  }
}
