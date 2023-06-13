package ustudy;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class UStudy {

    public static void menu() {
        System.out.println("\n\n********************************************************************");
        System.out.println("****************************** UStudy ******************************");
        System.out.println("********************************************************************");
        System.out.println("1: Add Subject");
        System.out.println("2: View Subjects");
        System.out.println("3: Delete Subject");
        System.out.println("4: Edit Subject");
        System.out.println("5: Add material to a subject ");
        System.out.println("6: View Learning Material");
        System.out.println("7: Delete material of a subject ");
        System.out.println("8: Update progress for a learning material ");
        System.out.println("9: Start Schedule ");
        System.out.println("10: Start Session ");
        System.out.println("11: Quit");
        System.out.println(" -------------------------------------------------------------------");
        System.out.print("\nChoose from the menu: ");
    }

    //---------------------------------------------------------------------------
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        int selectedOption; //number by user
        int num = 0;//
        int numberOfLearningMaterials = 0;
        int subjectID = 0;
        int LM_ID;
        int materialPage;
        Subject instance = new Subject();
        Schedule schInstance = new Schedule();
        LearningMaterial lmInstance = new LearningMaterial();
        int pagesRead;
        int numberOFPages;
        do {
            menu();
            selectedOption = input.nextInt();

            switch (selectedOption) {
                case 1: {

                    System.out.print("Enter Subject Name: ");
                    subjectID++;
                    String subjectName = input.next();
                    Subject obj = new Subject(subjectID, subjectName);
                    instance.addSubject(obj);
                    break;
                }
                case 2: {
                    //calc progress
                    int idForSearch = 1;
                    for (int i = 0; i < instance.subjects.size(); i++) {
                        int pagesDone = lmInstance.pagesDoneforSubject(idForSearch);
                        int totalPages = lmInstance.totalPagesforSubject(idForSearch);
                        instance.calculateProgress(pagesDone, totalPages, idForSearch);
                        instance.calculateMinimumTime(idForSearch, lmInstance);
                        idForSearch++;
                    }

                    instance.viewSubject();
                    break;

                }
                case 3: {
                    instance.viewSubjectAndID();//so the user knows which id is related to which subject
                    System.out.print("Enter The Subject ID to Delete: ");

                    subjectID = input.nextInt();
                    instance.deleteSubject(subjectID);
                    break;

                }
                case 4: {
                    instance.viewSubjectAndID();//so the user knows which ID is related to which subject
                    System.out.print("Enter Subject ID to Edit: ");
                    subjectID = input.nextInt();
                    instance.editSubject(subjectID);
                    break;

                }
                case 5: {
                    instance.viewSubjectAndID();//so the user knows which ID is related to which subject
                    System.out.print("Enter the subject ID to add material: ");
                    subjectID = input.nextInt();
                    if (instance.existsSubject(subjectID)) {
                        LM_ID = subjectID * 50;
                        while (true) {
                            System.out.print("\nEnter the names of the Learning Materials... type \"stop\" to exit: ");
                            String MaterialName = input.next();

                            if (!MaterialName.equalsIgnoreCase("stop")) {
                                System.out.print("Number of page: ");
                                materialPage = input.nextInt();
                                LearningMaterial LM_obj = new LearningMaterial(instance.getSubjectById(subjectID), LM_ID++, MaterialName, materialPage);
                                lmInstance.addLearningMaterial(LM_obj);

                            } else {
                                System.out.println("");
                                break;
                            }
                        }

                    } else {
                        System.out.println("ID not found!");
                    }
                    break;

                }
                case 6: {
                    instance.viewSubjectAndID();//so the user knows which ID is related to which subject
                    System.out.print("Enter subject ID to view Learning Materials: ");
                    subjectID = input.nextInt();

                    if (instance.existsSubject(subjectID)) {
                        System.out.println("\n\n\t\t\tID: " + instance.getSubjectById(subjectID).getId()
                                + " Subject Name: "
                                + instance.getSubjectById(subjectID).getName());
                        lmInstance.viewMaterial(instance.getSubjectById(subjectID));
                    } else {
                        System.out.println("ID not found!");

                        System.out.println("###################################################################3\n");

                    }
                    break;
                }
                case 7: {
                    instance.viewSubjectAndID();//so the user knows which ID is related to which subject
                    System.out.print("Enter the subject ID: ");
                    subjectID = input.nextInt();

                    if (instance.existsSubject(subjectID)) {
                        lmInstance.viewMaterial(instance.getSubjectById(subjectID));//shows learning materials for specific subject
                        System.out.print("Enter the Learning Material ID to delete: ");
                        LM_ID = input.nextInt();

                        if (lmInstance.existMaterial(LM_ID)) {
                            if (LM_ID >= subjectID * 50 && LM_ID < subjectID + 1 * 50) {
                                lmInstance.deleteMaterial(LM_ID);
                            } else {
                                System.out.println("Learning Material ID is not for this subject!");
                            }
                        } else {
                            System.out.println("Learning Material ID not found!");
                        }

                    } else {
                        System.out.println("Subject ID not found!");
                    }
                    break;
                }

                case 8: {
                    System.out.print("Enter Subject ID: ");
                    subjectID = input.nextInt();
                    if (instance.existsSubject(subjectID)) {
                        System.out.print("Enter the Learning Material ID to Update Pages Done: ");
                        LM_ID = input.nextInt();
                        if (lmInstance.existMaterial(LM_ID)) {
                            LearningMaterial lm = lmInstance.getLMbyId(LM_ID);
                            System.out.print("Enter Number Pages Done in " + lm.getName() + ": ");
                            numberOFPages = input.nextInt();

                            lm.setPages_done(numberOFPages);
                            System.out.println("\nPages Done Updated Sucessfuly");

                        } else {
                            System.out.println("Learning Material not found");
                        }
                    } else {
                        System.out.println("Subject not found");
                    }
                    break;
                }
                case 9: {
                    instance.viewSubjectAndID();
                    System.out.print("\nSelect Subject ID: ");
                    subjectID = input.nextInt();
                    Subject subject = instance.getSubjectById(subjectID);
                    System.out.print("Enter Start Date(DD/MM/YYYY): ");
                    String date = input.next();
                    int numLM = lmInstance.NumOfLM(subjectID);

                    Schedule MLSchedule = new Schedule(subject.id, subject.getName(), date);
                    MLSchedule.CalcEndDate(date, numLM - 1);
                    schInstance.addSchedule(MLSchedule);

                    schInstance.SchedulePrint();
                    lmInstance.LMDays(date, subjectID);
                    break;
                }
                case 10: {
                    instance.viewSubjectAndID(); //so the user knows which ID is related to which subject
                    System.out.print("Enter Subject ID: ");
                    subjectID = input.nextInt();

                    if (instance.existsSubject(subjectID)) {
                        Session session = new Session(instance.getSubjectById(subjectID));
                        System.out.println("---------SESSION STARTED--------");
                        System.out.print("Enter 0 if you want to stop session for subject " + instance.getSubjectById(subjectID).getName() + ": ");
                        instance.getSubjectById(subjectID).setSession(session);
                        session.StartTimer();

                        do {
                            num = input.nextInt();
                        } while (num != 0);

                        session.StopTimer();
                        System.out.print("\nEnter how many learning material have you studied : ");
                        numberOfLearningMaterials = input.nextInt();
                        lmInstance.viewMaterial(instance.getSubjectById(subjectID));
                        System.out.print("\nEnter learning material number: ");
                        LM_ID = input.nextInt();

                        do {
                            if (lmInstance.existMaterial(LM_ID)) {
                                LearningMaterial lm = lmInstance.getLMbyId(LM_ID);
                                System.out.print("Enter Number Pages Done in " + lm.getName() + ": ");
                                int pagesDone = input.nextInt();

                                int overAllPages = lm.getPage_number();

                                if ((overAllPages - pagesDone) < 0) {
                                    System.out.println("Invalid input. That is more than the learning material's pages!");
                                } else {
                                    instance.getSubjectById(subjectID).getSession().setPagesReadInSession(pagesDone);
                                    lm.setPages_done(pagesDone);
                                    System.out.println("\nPages Done Updated Successfully");
                                }
                            } else {
                                System.out.println("Learning Material not found");
                            }

                            numberOfLearningMaterials--;
                        } while (numberOfLearningMaterials > 0);
                    } else {
                        System.out.println("Subject not found");
                    }
                    break;
                }

                case 11:
                    System.out.println(" > Exiting...");
                    System.out.println(" > Goodbye");
                    break;

                default:
                    System.out.println();
                    System.out.println(" > Invalid choice entered! Please try again.");
                    System.out.println();
                    break;
            }
        } while (selectedOption != 11);
    }

}
