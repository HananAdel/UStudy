/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
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
 * @author sama7
 */
public class SessionTest {
    
    public SessionTest() {
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
     * Test of StartTimer method, of class Session.
     */
//    @Ignore
//    @Test
//    public void testStartTimer() {
//        System.out.println("StartTimer");
//        Session instance = new Session();
//        long startTime = instance.StartTimer();
//        assertTrue(startTime>0);
//    }

    /**
     * Test of StopTimer method, of class Session.
     */
//    @Ignore
//    @Test
//    //A test that checks if there is any error with the end time of the seesion
//    public void testStopTimer() {
//        System.out.println("StopTimer");
//        Session instance = new Session();
//        long stopTime = instance.StartTimer();
//        assertTrue(stopTime>0);
//    }

    /**
     * Test of getTotalTimeInMillie method, of class Session.
     */
    @Test
    
    /*since there cant be a fixed value to curretTimeMillis we will just test it
    if it will work with value 0
    */
    public void testGetTotalTimeInMillie() {
        System.out.println("getTotalTimeInMillie");
        Session instance = new Session();
        long expResult = 0L;
        long result = instance.getTotalTimeInMillie();
        assertEquals(expResult, result);
    }



    /**
     * Test of getTotalTimeInSeconds method, of class Session.
     */
    @Test
    public void testGetTotalTimeInSeconds() {
        System.out.println("getTotalTimeInSeconds");
        Session instance = new Session();
        long expResult = 0L;
        long result = instance.getTotalTimeInSeconds();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getTotalTimeInMinutes method, of class Session.
     */
    @Test
    public void testGetTotalTimeInMinutes() {
        System.out.println("getTotalTimeInMinutes");
        Session instance = new Session();
        long expResult = 0L;
        long result = instance.getTotalTimeInMinutes();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of getPagesReadInSession method, of class Session.
     */
    @Test
    public void testGetPagesReadInSession() {
        System.out.println("getPagesReadInSession");
        Session instance = new Session();
        int expResult = 0;
        int result = instance.getPagesReadInSession();
        assertEquals(expResult, result);
       
    }

    
}