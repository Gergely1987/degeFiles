package references;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    List<Member> connections=new ArrayList<>();

    public List<Member> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        String connection="";
        for (Member m:connections){
            connection+=m.getName();
        }
        return name+" connections= "+connection;
    }

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void connectMember(Member member){
        connections.add(member);
    }

}
