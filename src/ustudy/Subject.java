package ustudy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hanan Adel
 */
public class Subject {

    int id;
    String name;
    int minimumTime; //time in mintues or hours
    int progress; // progress "%" compeltion
    LearningMaterial lm; //instance to call lm
    ArrayList<Subject> subjects = new ArrayList<>();
    Session session;
    

    public Subject() 
    {
        
    }

    public Subject(int id, String name, int minimumTime, int progress) {
        this.id = id;
        this.name = name;
        this.minimumTime = minimumTime;
        this.progress = progress;
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
        this.minimumTime = 0;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumTime() {
        return minimumTime;
    }

    public void setMinimumTime(int minimumTime) {
        this.minimumTime = minimumTime;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void viewSubject() {
        System.out.println("Subjects List: ");
        for (int i = 0; i < subjects.size(); i++) {

            System.out.println("ID: " + subjects.get(i).getId()
                    + " Subject Name: " + subjects.get(i).getName()
                    + " Subject Progress: "
                    + subjects.get(i).getProgress() +"%"
                    +" Approximate Time to Finish a Subject:  "+ subjects.get(i).getMinimumTime() + " mintues");
        }
    }
    
    public void viewSubjectAndID() {
        System.out.println("Subjects List: ");
        for (int i = 0; i < subjects.size(); i++) {

            System.out.println("ID: " + subjects.get(i).getId()
                    + " Subject Name: " + subjects.get(i).getName()
                    );
        }
    }

    public void deleteSubject(int id) {
        boolean found = false;
        for (int i = 0; i < subjects.size(); i++) {
            if (id == subjects.get(i).getId()) {
                found = true;
                subjects.remove(i);
                System.out.println("Subject Deleted Sucessfuly");
            }
        }
        if (!found) {
            System.out.println("ID not found!");
        }
    }

    public void editSubject(int id) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < subjects.size(); i++) {
            if (id == subjects.get(i).getId()) {
                System.out.print("Enter New Subject Name: ");
                String name = input.next();
                subjects.get(i).setName(name);
            }
        }
    }

    public boolean existsSubject(int id) {
        boolean found = false;
        for (int i = 0; i < subjects.size(); i++) {
            if (id == subjects.get(i).getId()) {
                return found = true;
            }
        }
        return found;
    }

    public Subject getSubjectById(int id) {

        for (int i = 0; i < subjects.size(); i++) {
            if (id == subjects.get(i).getId()) {
                return subjects.get(i);
            }
        }
        return null;
    }
    
    public void calculateProgress(int pagesDone, int totalPages, int id) {
        double percent = 0;
        for (int i = 0; i < subjects.size(); i++) {
            if (id == subjects.get(i).getId()) {
                if (totalPages != 0) {
                    percent =(double) pagesDone / totalPages * 100;
                    subjects.get(i).setProgress((int)percent);
                }

            }

        }

    }
    public void setSession(Session session){
        this.session=session;
    }

    public Session getSession() {
        return session;
    }
    public void calculateMinimumTime(int id, LearningMaterial instance){
        if(existsSubject(id)){
          if(getSubjectById(id).getSession() != null){
            int pages = getSubjectById(id).getSession().getPagesReadInSession();
            double time =  getSubjectById(id).getSession().getTotalTimeInMinutes();
            if(time !=0 ){
                double speed = pages / time;
                int remainingPages = instance.totalPagesforSubject(id) - instance.pagesDoneforSubject(id);
                if(speed != 0){
                    int minimumTime = (int)(remainingPages/speed);
                    getSubjectById(id).setMinimumTime(minimumTime);
                }
                else
                    System.out.println("speed is zero");
            }
            else
                  System.out.println("time is zero");
        }  
        }
        
    }


}
