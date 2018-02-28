package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;

public class NameServer {
    private List<DnsEntry> servers = new ArrayList<>();

    private static class DnsEntry {
        private String hostname;
        private String hostIp;

        public DnsEntry(String hostname, String hostIp) {
            this.hostname = hostname;
            this.hostIp = hostIp;
        }

        public String getHostname() {
            return hostname;
        }

        public String getHostIp() {
            return hostIp;
        }
    }


    public void addEntry(String hostname, String hostIp) {
        for (DnsEntry n : servers) {
            if (n.getHostname().equals(hostname) || n.getHostIp().equals(hostIp)) {
                throw new IllegalArgumentException("Already exists");
            }
        }
        servers.add(new NameServer.DnsEntry(hostname, hostIp));
    }

    public void removeEntryByName(String hostname){
        for (DnsEntry n: servers) {
            if(n.getHostname().equals(hostname)){
                servers.remove(n);
                return;
            }
        }
    }

    public void removeEntryByIp(String hostIp){
        for (DnsEntry n: servers) {
            if(n.getHostIp().equals(hostIp)){
                servers.remove(n);
                return;
            }
        }
    }

    public String getIpByName(String hostname){
      String ip="";
        for (DnsEntry n:servers) {
            if(n.getHostname().equals(hostname)){
              return  ip+=n.getHostIp();
            }

        }
        throw new IllegalArgumentException("Element not found");
    }

    public String getNameByIp(String hostIp){
        String name="";
        for (DnsEntry n:servers) {
            if(n.getHostIp().equals(hostIp)){
                name+=n.getHostname();
                return name;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }
}
