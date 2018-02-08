package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBShop {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    Statement createStatement = null;

    public DBShop() {

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
                System.out.println("sikerült a csatlakozás a SHOP adatbázishoz");
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
            ResultSet rs = dbmd.getTables(null, "APP", "SHOP", null);
            if (!rs.next()) {
                createStatement.execute("create table shop(id INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), shopName varchar(20), areaCode INT, city varchar(20), street varchar(20), streetNum INT)");
                //beállítunk a ID primery keyt- ami automatikusan növekedik
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public ArrayList<Shop> getAllShops() {
        String sql = "select*from shop";
        ArrayList<Shop> shops = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            shops = new ArrayList<>();
            while (rs.next()) {
                Shop actualShop = new Shop(rs.getInt("id"), rs.getString("shopName"), rs.getString(String.valueOf("areaCode")), rs.getString("city"), rs.getString("street"), rs.getString(String.valueOf("streetNum")));
                shops.add(actualShop);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van a Shop kiolvasásakor");
            System.out.println(e);
        }
        return shops;
    }

    public void addNewShop(Shop shop){
        String sql="insert into shop(shopName,areaCode,city, street, streetNum) values (?,?,?,?,?)";
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, shop.getShopName());
            ps.setInt(2, Integer.parseInt(shop.getAreaCode()));
            ps.setString(3, shop.getCity());
            ps.setString(4, shop.getStreet());
            ps.setInt(5, Integer.parseInt(shop.getStreetNum()));
            ps.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van a SHOP hozzáadásnál");
            System.out.println(""+e);
        }
    }

    public void updateShop(Shop shop){
        String sql="update shop set shopName=?,areaCode=?,city=?, street=?, streetNum=? where id=?";
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, shop.getShopName());
            ps.setInt(2, Integer.parseInt(shop.getAreaCode()));
            ps.setString(3, shop.getCity());
            ps.setString(4, shop.getStreet());
            ps.setInt(5, Integer.parseInt(shop.getStreetNum()));
            ps.setInt(6, Integer.parseInt(shop.getId()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("valami baj van a Shop frissítésénél");
            System.out.println(""+e);
        }

    }

    public void removeShop(Shop shop){
        String sql="delete from shop where id=?";
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(shop.getId()));
            ps.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van a Shop törlésekor");
            System.out.println(""+e);
        }

    }

}

