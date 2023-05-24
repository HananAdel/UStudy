package ustudy;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class LearningMaterial {

    int ID;
    String name;
    String status;
    int page_number;
    Subject subject;
    ArrayList<LearningMaterial> LM = new ArrayList<>();

    public LearningMaterial() {
    }

    public LearningMaterial(Subject subject, int ID, String name, String status, int page_number) {
        this.subject = subject;
        this.ID = ID;
        this.name = name;
        this.status = status;
        this.page_number = page_number;
    }

    public LearningMaterial(Subject subject, int ID, String name, int page_number) {
        this.subject = subject;
        this.ID = ID;
        this.name = name;
        this.page_number = page_number;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void addLearningMaterial(LearningMaterial lm) {
        LM.add(lm);
    }

    public void viewMaterial(Subject subject) {
        int numOfM = 0;
        for (int i = 0; i < LM.size(); i++) {
            if (subject == LM.get(i).subject) {
                System.out.println((++numOfM) + "\t\tMaterial ID: mc" + LM.get(i).getID() + " Material Name: " + LM.get(i).getName());
            }
        }

    }
    public boolean existMaterial(int id){
        boolean found = false;
        for (int i = 0; i < LM.size(); i++) {
            if (id == LM.get(i).getID()) {
                return found = true;
            }
        }
        return found;
    }
    
    public void deleteMaterial(int id){
        boolean found = false;
        for (int i = 0; i < LM.size(); i++) {
            if (id == LM.get(i).getID()) {
                found = true;
                LM.remove(i);
                System.out.println("Learning Material Deleted Sucessfuly\n");
            }
        }
        if (!found) {
            System.out.println("Learning Material ID is not found!\n");
        }
    }
}
