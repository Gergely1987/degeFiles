package Phonebook;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    Statement createStatement=null;
    public DB() {

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
            } catch (SQLException e) {
                System.out.println("valami baj van");
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

        //kérünk metaAdatot, amellyel azt vizsgáljuk, hogy van-e benne USERS nevű tábla
        try {
            ResultSet rs=dbmd.getTables(null, "APP","CONTACTS",null);
            if(!rs.next()){
                createStatement.execute("create table contacts( id INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), lastname varchar(20), firstname varchar(20), email varchar(30))");
            //beállítunk a ID primery keyt- ami automatikusan növekedik
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public ArrayList<Person> getAllContacts(){

        String sql="select * from contacts";
        ArrayList<Person>persons=null;
        try {
            ResultSet rs=createStatement.executeQuery(sql);
            persons=new ArrayList<Person>();
            while (rs.next()){
                Person actualPerson=new Person(rs.getInt("id"),rs.getString("lastname"),rs.getString("firstname"),rs.getString("email"));
                persons.add(actualPerson);

            }
        } catch (SQLException e) {
            System.out.println("valami baj van a kiolvasáskor");
            System.out.println(e);
        }
        return persons;
    }

    public void addContact(Person person){
        String sql="insert into contacts (lastname,firstname,email) values(?,?,?)"; //ahány kérdőjel, annyi preparedStatement.setString/setInt kell
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,person.getLastName());
            preparedStatement.setString(2,person.getFirstName()); //csekkolódik is automatikusan, hogy pl String kerüljön bele
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.execute();


        } catch (SQLException e) {
            System.out.println("valami baj van a user hozzáadásnál");
            System.out.println(""+e);
        }
    }

    public void updateContact (Person person){
        String sql="update contacts set lastname=?, firstname=?, email=? where id=?"; //ahány kérdőjel, annyi preparedStatement.setString/setInt kell
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,person.getLastName());
            preparedStatement.setString(2,person.getFirstName()); //csekkolódik is automatikusan, hogy pl String kerüljön bele
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.setInt(4,Integer.parseInt(person.getId()));
            preparedStatement.execute();


        } catch (SQLException e) {
            System.out.println("valami baj van a user frissítésénél");
            System.out.println(""+e);
        }
    }

    public void removeContact (Person person){
        String sql="delete from contacts where id=?"; //ahány kérdőjel, annyi preparedStatement.setString/setInt kell
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.parseInt(person.getId()));
            preparedStatement.execute();


        } catch (SQLException e) {
            System.out.println("valami baj van a contect törlésekor");
            System.out.println(""+e);
        }
    }
}
