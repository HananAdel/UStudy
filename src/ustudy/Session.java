package ustudy;

import java.util.*;

public class Session {

    private long FTime;
    private long STime;
    private long TotalTimeInMillie;
    private long TotalTimeInSeconds;
    private long TotalTimeInMinutes;
    private Subject subject;

    public void StartTimer() {
        FTime = System.currentTimeMillis();
    }

    public void StopTimer() {
        STime = System.currentTimeMillis();
    }

    public void TimeInMillieseconds() {
        TotalTimeInMillie = STime - FTime;
    }

    public void TimeInMinutes() {
        TotalTimeInSeconds = TotalTimeInMillie * 60;
    }

    public void TimeInSeconds() {
        TotalTimeInMinutes = TotalTimeInMillie * 60000;
    }

    public void TimeForSubject(int ID) {
        subject = subject.getSubjectById(ID);
    }
}
