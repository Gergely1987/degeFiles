package sample;

import java.sql.*;
import java.util.List;

public class DBEmployeePassword {

    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    Statement createStatement = null;

    public DBEmployeePassword() {

        try {
            //  Connection conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //megpróbáljuk életre kelteni
            conn = DriverManager.getConnection(URL);
            System.out.println("sikerült");

        } catch (SQLException e) {
            System.out.println("nem sikerült");
            System.out.println("" + e);
        }

        //ha életre kelt, csinálunk egy megpakolható teherautót
        if (conn != null) {
            try {
                createStatement = conn.createStatement();
                System.out.println("sikerült a csatlakozás az EmployeePassword adatbázishoz");
            } catch (SQLException e) {
                System.out.println("valami baj van az Employepassword adatbázishoz való csatlakozáskor");
                System.out.println(e);
            }
        }

        //megnézzük, hogy üres-e az adatbázis, megnézzük, hogy létezik-e az adott adattábla
        DatabaseMetaData dbmd = null;
        try {
            dbmd = conn.getMetaData();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        //kérünk metaAdatot, amellyel azt vizsgáljuk, hogy van-e benne WINE nevű tábla
        try {
            ResultSet rs = dbmd.getTables(null, "APP", "EMPLOYEEPASSWORD", null);
            if (!rs.next()) {
                createStatement.execute("create table employeePassword(id INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), employeeID varchar(20), password varchar(20))");
                //beállítunk a ID primery keyt- ami automatikusan növekedik
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void addEmployeePassword(String id, String pass) {
        String sql = "insert into employeePassword (employeeID,password) values(?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            System.out.println(2);
            preparedStatement.setString(2, pass);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("baj van az ID- Jelszó átadásnál");
            e.printStackTrace();
        }
    }

    public String checkEmployeePassword(String id) {
        String sql = "select * from employeePassword where employeeID=" + "'"+id+"'";

        EmployeePassword ep = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            while ((rs.next())) {
                ep = new EmployeePassword(rs.getString("employeeID"), rs.getString("password"));
            }

        } catch (SQLException e) {
            System.out.println("Valami probéma van a Jelszó ellenőrzésekor");
            e.printStackTrace();
        }
        if (ep==null){
            return "";
        }
        return ep.getPassword();
    }
}
