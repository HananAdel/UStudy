package ustudy;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hebahturki
 */
public class Schedule 
{
    int LMID;
    String LMName;
    String date;
    ArrayList<Schedule> schedule = new ArrayList();

    public Schedule(int LMID, String LMName, String date) 
    {
        this.LMID = LMID;
        this.LMName = LMName;
        this.date = date;
    }

    public Schedule() {
    }
    
    public void SchedulePrint()
    {
        System.out.println("-------------------------------------------------");
        System.out.println("                Study Schedule                   ");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < schedule.size(); i++) {

            System.out.println("ID: " + schedule.get(i).LMID
                    + "  Subject Name: " + schedule.get(i).getLMName()
                    + "  Start Date: "+schedule.get(i).getDate());
        }
        System.out.println("-------------------------------------------------\n");
    }

    public int getLMID() {
        return LMID;
    }

    public void setLMID(int LMID) {
        this.LMID = LMID;
    }

    public String getLMName() {
        return LMName;
    }

    public void setLMName(String LMName) {
        this.LMName = LMName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }
    
    public void addSchedule(Schedule lm) {
        schedule.add(lm);
    }
}
