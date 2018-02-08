package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBWine {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    Statement createStatement = null;

    public DBWine() {

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
                System.out.println("sikerült a csatlakozás a Wine adatbázishoz");
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

        //kérünk metaAdatot, amellyel azt vizsgáljuk, hogy van-e benne WINE nevű tábla
        try {
            ResultSet rs = dbmd.getTables(null, "APP", "WINE", null);
            if (!rs.next()) {
                createStatement.execute("create table wine(id INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), name varchar(20), type varchar(10), years varchar(10), piece INT, price varchar(10), date varchar(20), shopID varchar(10), fixingDate varchar(30))");
                //beállítunk a ID primery keyt- ami automatikusan növekedik
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public ArrayList<Wine> getAllWine() {
        String sql = "select * from wine";
        ArrayList<Wine> wines = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            wines = new ArrayList<Wine>();
            while (rs.next()) {
                Wine actualWine = new Wine(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getString(String.valueOf("piece")), rs.getString("years"), rs.getString("price"), rs.getString("shopID"), rs.getString("fixingDate"));
                wines.add(actualWine);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van a a WINE tábla kiolvasásakor");
            System.out.println(e);
        }
        return wines;
    }


//    public ArrayList<Wine>getWineShopPerShop(String shopid){
//        String sql = "select * from wine where shopID="+"'"+shopid+"'";
//        ArrayList<Wine> wines = null;
//
//        try {
//            ResultSet rs = createStatement.executeQuery(sql);
//            wines = new ArrayList<Wine>();
//            while (rs.next()) {
//                Wine actualWine = new Wine(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getString(String.valueOf("piece")), rs.getString("years"), rs.getString("price"), rs.getString("shopID"), rs.getString("fixingDate"));
//                wines.add(actualWine);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("valami baj van a a WINE tábla kiolvasásakor");
//            System.out.println(e);
//        }
//        return wines;
//    }

    public void updateWine(List<Wine> wines){
        String sql="update wine set name=?,type=?,years=?,piece=?,price=?,shopID=?,fixingDate where id=?";
        PreparedStatement ps=null;

    }



    public ArrayList<Wine> getAllWineByNameShopIDPrice() {
        String sql = "select sum(piece) as newPiece,name,type,years,price,shopID from wine group by name,type,years,price,shopID";
        ArrayList<Wine> wines = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            wines = new ArrayList<Wine>();
            while (rs.next()) {
                Wine actualWine = new Wine(rs.getString("name"), rs.getString("type"),rs.getString("years"), rs.getString(String.valueOf("newPiece")),  rs.getString("price"), rs.getString("shopID"));
                wines.add(actualWine);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van a a WINE tábla kiolvasásakor");
            System.out.println(e);
        }
        return wines;
    }

    public ArrayList<Wine> getAllWineByNameShopIDPrice_PerShop(String shopid) {
        String sql = "select sum(piece) as newPiece,name,type,years,price,shopID from wine where shopID="+"'"+shopid+"'"+ "group by name,type,years,price,shopID";
        ArrayList<Wine> wines = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            wines = new ArrayList<Wine>();
            while (rs.next()) {
                Wine actualWine = new Wine(rs.getString("name"), rs.getString("type"),rs.getString("years"), rs.getString(String.valueOf("newPiece")),  rs.getString("price"), rs.getString("shopID"));
                wines.add(actualWine);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van a a WINE tábla kiolvasásakor");
            System.out.println(e);
        }
        return wines;
    }


    public void addNewWine(Wine wine1) {
        String sql = "insert into wine (name,type,years,piece,price,shopID,fixingDate) values(?,?,?,?,?,?,?)";//ahány kérdőjel, annyi preparedStatement.setString/setInt kell
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, wine1.getName());//csekkolódik is automatikusan, hogy pl String kerüljön bele
            preparedStatement.setString(2, wine1.getType());
            preparedStatement.setString(3, wine1.getYear());
            preparedStatement.setInt(4, Integer.parseInt(wine1.getPiece()));
            preparedStatement.setString(5, wine1.getPrice());
            preparedStatement.setString(6, wine1.getShopID());
            preparedStatement.setString(7, wine1.getDate());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van a Wine hozzáadásnál");
            System.out.println("" + e);
        }

    }


    public void removeWine(Wine wine) {
        String sql = "delete from wine where id=?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(wine.getId()));
            ps.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van a Bor törlésekor");
            System.out.println("" + e);
        }

    }

}

