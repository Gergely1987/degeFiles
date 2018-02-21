package sample;

import java.sql.*;

public class DB {

    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    Statement createStatement = null;

    public DB() {

        try {
            //  Connection conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //megpróbáljuk életre kelteni
            conn = DriverManager.getConnection(URL);


        } catch (SQLException e) {
            System.out.println("nem sikerült");
            System.out.println("" + e);
        }
    }

    public Connection getConn() {
        return conn;
    }
}