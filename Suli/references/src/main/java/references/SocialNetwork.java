package references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocialNetwork {
    List<Member> members = new ArrayList<>();

    @Override
    public String toString() {
        return "members=" + members.toString();
    }

    public void addMember(String name) {
        Member m = new Member(name);
        members.add(m);
    }

    public void connect(String name, String anotherName) {
        Member m1 = new Member(name);
        Member m2 = new Member(anotherName);

        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getName().equals(name)) {
                m1 = members.get(i);
            }

        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getName().equals(anotherName)) {
                m2 = members.get(i);
            }

        m1.connectMember(m2);


    }

    public Member findByName(String name) {
        Member m = new Member();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(name)) {
                m = members.get(i);
            }
        }
        return m;
    }

    public List<String> bidirectionalConnections() {
        List<String> newList = new ArrayList<>();
        for (Member me: members){
            for (Member con: me.getConnections()){
                if(me.getConnections().contains(con)){
                newList.add( me.toString()+" ");
                }
            }
        }
        System.out.println(newList);
        return newList;
    }

    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();
        sn.addMember("Hella");
        sn.addMember("Aleksz");
        sn.addMember("Peti");
        sn.addMember("Marci");
        sn.addMember("Andor");
        sn.addMember("Zoli");
        sn.addMember("Gergely");
        sn.addMember("Misi");

        System.out.println(sn);
        sn.connect("Hella", "Aleksz");
        sn.connect("Aleksz", "Hella");
        System.out.println(sn);
        System.out.println(sn.findByName("Hella"));
        System.out.println();
        //System.out.println(sn.bidirectionalConnections());
        sn.bidirectionalConnections();
    }
}

