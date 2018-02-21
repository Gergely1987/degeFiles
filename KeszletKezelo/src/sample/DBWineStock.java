package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBWineStock {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    public DBWineStock(Connection conn) {
        this.conn = conn;
    }

    Statement createStatement = null;

    public DBWineStock() {

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
            ResultSet rs = dbmd.getTables(null, "APP", "WINESTOCK", null);
            if (!rs.next()) {
                createStatement.execute("create table wineStock(name varchar(20), type varchar(10), years varchar(10), piece INT, price INT, shopID varchar(10))");
                //beállítunk a ID primery keyt- ami automatikusan növekedik
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public ArrayList<Wine> getAllWine() {
        String sql = "select * from wineStock";
        ArrayList<Wine> wines = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            wines = new ArrayList<Wine>();
            while (rs.next()) {
                Wine actualWine = new Wine(rs.getString("name"), rs.getString("type"), rs.getString("years"), rs.getString(String.valueOf("piece")), rs.getString("price"), rs.getString("shopID"));
                wines.add(actualWine);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van a a WINEStock tábla kiolvasásakor");
            System.out.println(e);
        }
        return wines;
    }

    public ArrayList<Wine> getAllWinePerShop(String shopID) {
        String sql = "select * from wineStock where shopID=" + "'" + shopID + "'";
        ArrayList<Wine> wines = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            wines = new ArrayList<Wine>();
            while (rs.next()) {
                Wine actualWine = new Wine(rs.getString("name"), rs.getString("type"), rs.getString("years"), rs.getString(String.valueOf("piece")), rs.getString("price"), rs.getString("shopID"));
                wines.add(actualWine);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van a a wineStock tábla kiolvasásakor üzletenként");
            System.out.println(e);
        }
        return wines;
    }

    public ArrayList<Wine> checkIfExist(Wine wine) {
        String sql = "select * from wineStock where name=" + "'" + wine.getName() + "' " + "and type=" + "'" + wine.getType() + "' " + "and years=" +
                "'" + wine.getYear() + "' " + " and price=" + wine.getPrice() +
                " and shopID=" + "'" + wine.getShopID() + "'";
        ArrayList<Wine> wines = null;

        try {
            ResultSet rs = createStatement.executeQuery(sql);
            wines = new ArrayList<Wine>();
            while (rs.next()) {
                Wine actualWine = new Wine(rs.getString("name"), rs.getString("type"), rs.getString("years"),
                        rs.getString(String.valueOf("piece")), rs.getString(String.valueOf("price")), rs.getString("shopID"));

                wines.add(actualWine);
            }

        } catch (SQLException e) {
            System.out.println("valami baj van a a WINE tábla kiolvasásakor, hogy létezik-e");
            System.out.println(e);
        }
        return wines;
    }

    public void addNewWine(Wine wine) {
        String sql = "insert into wineStock (name,type,years,piece,price,shopID) values(?,?,?,?,?,?)";//ahány kérdőjel, annyi preparedStatement.setString/setInt kell
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, wine.getName());//csekkolódik is automatikusan, hogy pl String kerüljön bele
            preparedStatement.setString(2, wine.getType());
            preparedStatement.setString(3, wine.getYear());
            preparedStatement.setInt(4, Integer.parseInt(wine.getPiece()));
            preparedStatement.setInt(5, Integer.parseInt(wine.getPrice()));
            preparedStatement.setString(6, wine.getShopID());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van a wineStock hozzáadásnál");
            System.out.println("" + e);
        }

    }

    public void updateWine(Wine wine) {
        String sql = "update wineStock set piece=piece+" + Integer.parseInt(wine.getPiece()) + " where name=" + "'" + wine.getName() + "'"
                + " and type=" + "'" + wine.getType() + "'" + " and years=" + "'" + wine.getYear() + "'" + " and price=" + Integer.parseInt(wine.getPrice()) + " and shopID=" + "'" + wine.getShopID() + "'";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("valami baj van a wineStock frissítésénél");
            System.out.println("" + e);
        }
    }

    public void removeWine(Wine wine) {
        String sql = "update wineStock set piece=piece-" + Integer.parseInt(wine.getPiece()) + " where name=" + "'" + wine.getName() + "'"
                + " and type=" + "'" + wine.getType() + "'" + " and years=" + "'" + wine.getYear() + "'" + " and price=" + Integer.parseInt(wine.getPrice()) + " and shopID=" + "'" + wine.getShopID() + "'";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("valami baj van a wineStock frissítésénél");
            System.out.println("" + e);
        }
    }


}
