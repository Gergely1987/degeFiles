package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBEmployee {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
        final String URL = "jdbc:derby:sampleDB;create=true";
        final String USERNAME = "";
        final String PASSWORD = "";

        //létrehozzuk a kapcsolatot
        Connection conn = null;

        Statement createStatement=null;
    public DBEmployee(Connection conn) {

            this.conn = conn;

        //ha életre kelt, csinálunk egy megpakolható teherautót
        if (conn != null) {
            try {
                createStatement = conn.createStatement();
            } catch (SQLException e) {
                System.out.println("valami baj van");
                System.out.println(e);
            }
        }

        //megnézzük, hogy üres-e az adatbázis, megnézzük, hogy létezik-e az adott adattábla
        DatabaseMetaData dbmd = null;
        try {
            dbmd = conn.getMetaData();
            System.out.println("sikerült az Employee adatbázishoz való csatlakozás");
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        //kérünk metaAdatot, amellyel azt vizsgáljuk, hogy van-e benne EMPLOYEE nevű tábla
        try {
            ResultSet rs=dbmd.getTables(null, "APP","EMPLOYEE",null);
            if(!rs.next()){
                createStatement.execute("create table employee(id INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), name varchar(20), level INT, birthDate varchar(10), birthPlace varchar(15), idCard varchar(10), address varchar(20), phoneNumber varchar(20), shopID INT)");
                //beállítunk a ID primery keyt- ami automatikusan növekedik

            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public ArrayList<Employee>getAllEmployee(){
        String sql="select*from employee";
        ArrayList<Employee> employees=null;

        try {
            ResultSet rs=createStatement.executeQuery(sql);
            employees=new ArrayList<>();
            while(rs.next()){
              Employee actualEmployee=new Employee(rs.getInt("id"), rs.getString("name"), rs.getString(String.valueOf("level")), rs.getString("birthDate"), rs.getString("birthPlace"), rs.getString("idCard"), rs.getString("address"), rs.getString("phoneNumber"), rs.getString(String.valueOf("shopID")));
                employees.add(actualEmployee);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van az EMPLOYEE kiolvasásakor");
            System.out.println(e);
        }

        return employees;
    }


    public void addNewEmployee(Employee employee){
        String sql="insert into employee (name,level,birthDate,birthPlace,IDCard,address,phoneNumber,shopID)values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,employee.getName());
            ps.setInt(2, Integer.parseInt(employee.getLevel()));
            ps.setString(3, (employee.getBirthDate()));
            ps.setString(4,employee.getBirthPlace());
            ps.setString(5,employee.getIDCard());
            ps.setString(6,employee.getAddress());
            ps.setString(7, employee.getPhoneNumber());
            ps.setInt(8, Integer.parseInt(employee.getIdShop()));
            ps.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van az employee hozzáadásnál");
            System.out.println(""+e);
        }
    }

    public void updateEmployee(Employee employee){
        String sql="update employee set name=?,level=?,birthDate=?,birthPlace=?,IDCard=?,address=?,phoneNumber=?, shopID=? where id=?";
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,employee.getName());
            ps.setInt(2, Integer.parseInt(employee.getLevel()));
            ps.setString(3, (employee.getBirthDate()));
            ps.setString(4,employee.getBirthPlace());
            ps.setString(5, employee.getIDCard());
            ps.setString(6,employee.getAddress());
            ps.setString(7, employee.getPhoneNumber());
            ps.setInt(8, Integer.parseInt(employee.getIdShop()));
            ps.setInt(9, Integer.parseInt(employee.getId()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("valami baj van az Employee frissítésénél");
            System.out.println(""+e);
        }

    }

    public void removeEmployee(Employee employee){
        String sql="delete from employee where id=?";
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(employee.getId()));
            ps.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van az Employee törlésekor");
            System.out.println(""+e);
        }

    }

    public Employee checkEmployeeIdValid(String name){
        String sql="select * from employee where name="+"'"+name+"'";
        Employee emp=null;
        try {
            ResultSet rs=createStatement.executeQuery(sql);
            while (rs.next()){
                emp=new Employee(rs.getInt("id"), rs.getString("name"), rs.getString(String.valueOf("level")), rs.getString("birthDate"), rs.getString("birthPlace"), rs.getString("idCard"), rs.getString("address"), rs.getString("phoneNumber"), rs.getString(String.valueOf("shopID")));
            }

        } catch (SQLException e) {
            System.out.println("hiba van az Employee lekérdezésekor!");
            e.printStackTrace();
        }
        return emp;
    }

    public Employee loggedInEmployee(String id){

        int realId=Integer.parseInt(id);
        String sql="select * from employee where id="+realId;
        Employee emp=null;
        try {
            ResultSet rs=createStatement.executeQuery(sql);
            while (rs.next()){
                emp=new Employee(rs.getInt("id"), rs.getString("name"), rs.getString(String.valueOf("level")), rs.getString("birthDate"), rs.getString("birthPlace"), rs.getString("idCard"), rs.getString("address"), rs.getString("phoneNumber"), rs.getString(String.valueOf("shopID")));
            }

        } catch (SQLException e) {
            System.out.println("hiba van az Employee lekérdezésekor!");
            e.printStackTrace();
        }
        return emp;
    }



}
