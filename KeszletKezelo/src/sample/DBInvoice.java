package sample;

import java.sql.*;

public class DBInvoice {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    Statement createStatement=null;
    public DBInvoice() {

        try {
            //  Connection conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //megpróbáljuk életre kelteni
            conn = DriverManager.getConnection(URL);


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
            System.out.println("sikerült a csatlakozás a Partner adatbázishoz");
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        //kérünk metaAdatot, amellyel azt vizsgáljuk, hogy van-e benne PARTNER nevű tábla
        try {
            ResultSet rs=dbmd.getTables(null, "APP","INVOICE",null);
            if(!rs.next()){
                createStatement.execute("create table invoice(id INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), name varchar(50), type varchar(50), years varchar(80),piece varchar(20), price varchar(80), shopID varchar(20), finalPrice varchar(20), partnerID varchar(20))");
                //beállítunk a ID primery keyt- ami automatikusan növekedik

            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void addInvoice(Invoice invoice){
        String sql="insert into invoice (name,type,years,piece,price,shopID, finalPrice, partnerID) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,invoice.getName());
            ps.setString(2, invoice.getType());
            ps.setString(3, invoice.getYear());
            ps.setString(4, invoice.getPiece());
            ps.setString(5, invoice.getPrice());
            ps.setString(6, invoice.getShopID());
            ps.setString(7,invoice.getFinalPrice());
            ps.setString(8,invoice.getPartnerID());
        } catch (SQLException e) {
            System.out.println("valami baj van a Számla hozzáadásnál");
            System.out.println(""+e);
        }
    }
}
