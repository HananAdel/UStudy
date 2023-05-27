package ustudy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author hebahturki
 */
public class Schedule {

    int LMID;
    String LMName;
    String Sdate;
    String Edate;
    ArrayList<Schedule> schedule = new ArrayList();

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String Edate) {
        this.Edate = Edate;
    }

    public Schedule(int LMID, String LMName, String date) {
        this.LMID = LMID;
        this.LMName = LMName;
        this.Sdate = date;
    }

    public Schedule(int LMID, String LMName, String Sdate, String Edate) {
        this.LMID = LMID;
        this.LMName = LMName;
        this.Sdate = Sdate;
        this.Edate = Edate;
    }

    public Schedule() {
    }

    public void CalcEndDate(String Sdate, int LM) throws ParseException
    {     
        // create instance of the SimpleDateFormat that matches the given date  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        //create instance of the Calendar class and set the date to the given date  
        Calendar cal = Calendar.getInstance();  
        try{  
           cal.setTime(sdf.parse(Sdate));  
        }catch(ParseException e){  
            e.printStackTrace();  
         }  
        // use add() method to add the days to the given date  
        cal.add(Calendar.DAY_OF_MONTH, LM);  
        String Edate = sdf.format(cal.getTime());
        setEdate(Edate);
    }

    public void SchedulePrint() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                              Study Schedule                            ");
        System.out.println("------------------------------------------------------------------------\n");
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println("ID: " + schedule.get(i).LMID
                    + "  Subject Name: " + schedule.get(i).getLMName()
                    + "  Start Date: " + schedule.get(i).getSdate()
                    + "  End Date: " + schedule.get(i).getEdate()+"\n");
        }
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

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String date) {
        this.Sdate = date;
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
