package classStructure;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private String name;
    private String date_s;

    private Date birthday;
    private String address;

    public Client(String name, Date birthday, String address) throws ParseException {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public void migrate(String address){
        this.address=address;
    }

    public static void main(String[] args) throws ParseException {
        Client np=new Client("Pisti", new Date(),"keszthely");
        System.out.println(np.getName());
        System.out.println(np.getAddress());
        np.migrate("zalaegerszeg");
        System.out.println(np.getAddress());
    }




}
