
package ustudy;




public class Session {

    private long FTime;
    private long STime;
    private long TotalTimeInMillie;
    private long TotalTimeInSeconds;
    private long TotalTimeInMinutes;
    private Subject subject;
    private int pagesReadInSession;

    public Session() {
    }

    public Session(Subject subject) {
        this.subject = subject;
        this.pagesReadInSession = 0;
    }

    public long StartTimer() {
        FTime = System.currentTimeMillis();
        return FTime;
    }

    public long StopTimer() {
        STime = System.currentTimeMillis();
        return STime;
    }

    public long getTotalTimeInMillie() {
        setTotalTimeInMillie();
        return TotalTimeInMillie;
    }

    public void setTotalTimeInMillie() {
        this.TotalTimeInMillie = STime - FTime;
    }

    public long getTotalTimeInSeconds() {
        setTotalTimeInSeconds(getTotalTimeInMillie()/1000);
        return TotalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(long TotalTimeInSeconds) {
        this.TotalTimeInSeconds = TotalTimeInSeconds;
    }

    public long getTotalTimeInMinutes() {
        setTotalTimeInMinutes(getTotalTimeInSeconds()/60);
        return TotalTimeInMinutes;
    }

    public void setTotalTimeInMinutes(long TotalTimeInMinutes) {
        this.TotalTimeInMinutes = TotalTimeInMinutes;
    }



    public void TimeForSubject(int ID) {
        subject = subject.getSubjectById(ID);
    }

    public int getPagesReadInSession() {
        return pagesReadInSession;
    }

    public void setPagesReadInSession(int pagesReadInSession) {
        this.pagesReadInSession = pagesReadInSession;
    }

    

}
