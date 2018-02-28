package exceptionresource.accesscontrol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccessLog {
    private String fileName;

    public AccessLog(String fileName) {
        this.fileName = fileName;
    }

    public List<String> inAtTime(LocalDateTime ldt) {
        List<String> idListIn = new ArrayList<>();
        List<WorkLogs>worklogs=new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while ((line = reader.readLine()) != null) {
                String [] totalData=line.split(",");
                WorkLogs worklog=new WorkLogs(totalData[0], totalData[1],totalData[2]);
                worklogs.add(worklog);
            }

            for (WorkLogs w:worklogs) {
                if(w.getLdt().isBefore(ldt) && w.getInOut().getParam().equals(InOut.IN.getParam())){
                    idListIn.add(w.getUserId());
                }
                if(w.getLdt().isBefore(ldt)&& w.getInOut().getParam().equals("OUT")){
                    idListIn.remove(w.getUserId());
                }
            }

        } catch (IOException e) {
            throw new LogException();
        }
        return idListIn;
    }

    public List<LocalDateTime> loginsById(String personId) {
            List<LocalDateTime> entriesTime=new ArrayList<>();
            List<WorkLogs>totalWorklogs=new ArrayList<>();
            try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
                String line;
                while((line=reader.readLine())!=null){
                    String [] arrays=line.split(",");
                    WorkLogs worklog=new WorkLogs(arrays[0],arrays[1],arrays[2]);
                    totalWorklogs.add(worklog);

                }
                for (WorkLogs w: totalWorklogs) {
                    if(w.getUserId().equals(personId) && w.getInOut().getParam().equals("IN")){
                        entriesTime.add(w.getLdt());
                    }
                }
            } catch (FileNotFoundException e) {
               throw new LogException("FileNotFoundException ez");
            } catch (IOException e) {
                throw new LogException("IOException ez");
            }
            return entriesTime;
    }
}
