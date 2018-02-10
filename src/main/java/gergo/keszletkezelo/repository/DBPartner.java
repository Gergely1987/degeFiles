package gergo.keszletkezelo.repository;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gergo.keszletkezelo.domain.Partner;

public class DBPartner {
    final String JDBC_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    //létrehozzuk a kapcsolatot
    Connection conn = null;

    Statement createStatement=null;
    public DBPartner() {

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
            ResultSet rs=dbmd.getTables(null, "APP","PARTNERS",null);
            if(!rs.next()){
                createStatement.execute("create table partners(id INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), name varchar(20), taxNumber INT, contact varchar(20), areaCode INT, city varchar(20), street varchar(20), streetNum INT, phoneNumber varchar(20), email varchar(20), discount INT)");
                //beállítunk a ID primery keyt- ami automatikusan növekedik

            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public ArrayList<Partner>getAllPartners(){
        String sql="select * from partners";
        ArrayList<Partner>partners=null;

        try {
            ResultSet rs=createStatement.executeQuery(sql);
            partners=new ArrayList<>();
            while (rs.next()){
                Partner acutalPartner=new Partner(rs.getInt("id"), rs.getString("name"), rs.getString(String.valueOf("taxNumber")),rs.getString("contact"),rs.getString(String.valueOf("areaCode")), rs.getString("city"), rs.getString("street"),rs.getString(String.valueOf("streetNum")),rs.getString("phoneNumber"),rs.getString("email"),rs.getString(String.valueOf("discount")));
                partners.add(acutalPartner);
            }
        } catch (SQLException e) {
            System.out.println("valami baj van a PARTNER adatbázis kiolvasásakor");
            System.out.println(e);
        }
        return partners;
    }
   public void addPartner(Partner partner){
        String sql="insert into partners(name,taxNumber,contact,areaCode,city,street,streetNum,phoneNumber,email,discount) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;

       try {
           ps=conn.prepareStatement(sql);
           ps.setString(1, partner.getName());
           ps.setInt(2, Integer.parseInt(partner.getTaxNumber()));
           ps.setString(3, partner.getContact());
           ps.setInt(4, Integer.parseInt(partner.getAreaCode()));
           ps.setString(5, partner.getCity());
           ps.setString(6, partner.getStreet());
           ps.setInt(7, Integer.parseInt(partner.getStreetNum()));
           ps.setString(8, partner.getPhoneNumber());
           ps.setString(9, partner.getEmail());
           ps.setInt(10, Integer.parseInt(partner.getDiscountPercent()));
           ps.execute();
       } catch (SQLException e) {
           System.out.println("valami baj van a Partner hozzáadásnál");
           System.out.println(""+e);
       }
   }

   public void updatePartner(Partner partner){
        String sql="update partners set name=?, taxNumber=?, contact=?, areaCode=?, city=?, street=?, streetNum=?, phoneNumber=?, email=?,discount=? where id=?";
        PreparedStatement ps=null;

       try {
           ps=conn.prepareStatement(sql);
           ps.setString(1,partner.getName());
           ps.setInt(2,Integer.parseInt(partner.getTaxNumber()));
           ps.setString(3,partner.getContact());
           ps.setInt(4,Integer.parseInt(partner.getAreaCode()));
           ps.setString(5,partner.getCity());
           ps.setString(6,partner.getStreet());
           ps.setInt(7,Integer.parseInt(partner.getStreetNum()));
           ps.setString(8,partner.getPhoneNumber());
           ps.setString(9,partner.getEmail());
           ps.setInt(10,Integer.parseInt(partner.getDiscountPercent()));
           ps.setInt(11,Integer.parseInt(partner.getId()));
           ps.execute();
       } catch (SQLException e) {
           System.out.println("valami baj van a user frissítésénél");
           System.out.println(""+e);
       }
   }

   public void removePartner(Partner partner){
        String sql="delete from partners where id=?";
        PreparedStatement ps=null;

       try {
           ps=conn.prepareStatement(sql);
           ps.setInt(1,Integer.parseInt(partner.getId()));
           ps.execute();

       } catch (SQLException e) {
           System.out.println("valami baj van a Partner törlésekor");
           System.out.println(""+e);
       }
   }
}


