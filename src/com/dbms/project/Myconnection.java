package com.dbms.project;
import java.sql.Connection;
import java.sql.DriverManager;

public class Myconnection {

    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dhanavandhana", "password");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }
}