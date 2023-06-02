/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustudy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author hananadel
 */
public class SubjectTest {
    
    public SubjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addSubject method, of class Subject.
     */

    @Test
    public void testAddSubject() {
        System.out.println("addSubject");
        Subject subject = new Subject(1,"CPCS251");
        Subject instance = new Subject();
        instance.addSubject(subject);
        assertEquals(subject, instance.getSubjectById(1));

    }


    /**
     * Test of deleteSubject method, of class Subject.
     */
    @Test
    public void testDeleteSubject() {
        System.out.println("deleteSubject");
        int id = 1;
        Subject subject = new Subject(id,"CPCS251");
        Subject instance = new Subject();
        instance.addSubject(subject);
        instance.deleteSubject(id);
        assertNull(instance.getSubjectById(id));
    }


    /**
     * Test of existsSubject method, of class Subject.
     */
    @Test
    public void testExistsSubject() {
        System.out.println("existsSubject");
        int id = 1;
        
        Subject subject = new Subject(id,"CPCS251");
        Subject instance = new Subject();
        instance.addSubject(subject);
        
        assertTrue(instance.existsSubject(id));

    }

    /**
     * Test of getSubjectById method, of class Subject.
     */
    @Test
    public void testGetSubjectById() {
        System.out.println("getSubjectById");
        int id = 1;
        Subject subject = new Subject(id,"CPCS251");
        Subject instance = new Subject();
        instance.addSubject(subject);
        
        Subject expResult = subject;
        Subject result = instance.getSubjectById(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateProgress method, of class Subject.
     */
    @Test
    public void testCalculateProgress() {
        System.out.println("calculateProgress");
        
        int pagesDone = 50;
        int totalPages = 100;
        int id = 1;
        
        Subject instance = new Subject();
        Subject obj = new Subject(1,"CPCS251");
        instance.addSubject(obj);
        
        instance.calculateProgress(pagesDone, totalPages, id);
        int expResult = 50;
        int result = instance.getSubjectById(id).getProgress();
        
        assertEquals(expResult,result);

    }

    /**
     * Test of calculateMinimumTime method, of class Subject.
     */
    @Test
    public void testCalculateMinimumTime() {
        System.out.println("calculateMinimumTime");
        int id = 1;
        
        //add subject to arraylist
        Subject obj = new Subject(id,"CPCS251");
        Subject instance = new Subject();
        instance.addSubject(obj);
        
        //fill necessary info to calculate
        LearningMaterial obj2 = new LearningMaterial(instance.getSubjectById(id),50,"chapter1",200);
        LearningMaterial instance_2 = new LearningMaterial();
        instance_2.addLearningMaterial(obj2);
        
        Session instance3 = new Session(instance.getSubjectById(id));
        instance.getSubjectById(id).setSession(instance3);
        instance.getSubjectById(id).getSession().setTotalTimeInSeconds(240);
        instance.getSubjectById(id).getSession().setPagesReadInSession(12);

        //set session and calc
        instance.calculateMinimumTime(id, instance_2);
        
        int expResult = 66;
        int result = instance.getSubjectById(id).getMinimumTime();
        
        assertEquals(expResult, result);

    }
    
}
