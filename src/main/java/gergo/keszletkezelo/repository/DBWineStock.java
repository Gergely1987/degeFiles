package gergo.keszletkezelo.repository;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gergo.keszletkezelo.domain.Wine;

public class DBWineStock {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

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

    public void addNewWine_OR_Insert(Wine wine) {
//        String sql =
//                "begin"+
//                "IF EXISTS (select * from wineStock where name="+"'" +wine.getName()+"' "+"years="+"'"+wine.getYear()+"' "+"price="+"'"+wine.getPrice()+"' "+
//                "shopID="+"'"+wine.getShopID()+"' "+
//                "update wineStock set piece="+"'"+wine.getPiece()+
//                "'; "+"else insert into wineStock (name,type,years,piece,price,shopID) values(?,?,?,?,?,?);"+
//                "END IF;";
//             String sql="IF EXISTS (SELECT * FROM wineStock WHERE name ="+"'"+wine.getName()+"') "+
//                     "begin "+
//                     "update wineStock set piece=piece+"+"'"+wine.getPiece()+"' "+
//                     "end "+
//                     "else"+
//                     "begin"+
//                     "else insert into wineStock (name,type,years,piece,price,shopID) values(?,?,?,?,?,?)"+
//                     "end";

      //  String sql="insert into wineStock (name,type,years,piece,price,shopID) values(name="+"'" +wine.getName()+"',type="+"'" +wine.getType()+"', years="+"'" +wine.getYear()+ "',piece="+ Integer.parseInt(wine.getPiece())+" ,price="+Integer.parseInt(wine.getPrice().replace(" Ft",""))+",shopID="+"'"+wine.getShopID()+"'"+ ")"+ "ON DUPLICATE KEY UPDATE piece=piece+"+Integer.parseInt(wine.getPiece());

        String sql="insert into wineStock (name) values("+"'"+wine.getName()+"'"+" on duplicate key update piece=piece"+Integer.parseInt(wine.getPiece());

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, wine.getName());//csekkolódik is automatikusan, hogy pl String kerüljön bele
            preparedStatement.setString(2, wine.getType());
            preparedStatement.setString(3, wine.getYear());
            preparedStatement.setInt(4, Integer.parseInt(wine.getPiece()));
            preparedStatement.setInt(5,Integer.parseInt(wine.getPrice()) );
            preparedStatement.setString(6, wine.getShopID());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("valami baj van a Wine hozzáadásnál a WineStockban");
            System.out.println("" + e);
        }

    }
}
