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
    @Test
    public void testStartTimer() {
        System.out.println("StartTimer");
        Session instance = new Session();
        long startTime=instance.StartTimer();
        assertTrue(startTime>0);
    }

    /**
     * Test of StopTimer method, of class Session.
     */
    @Test
    //A test that checks if there is any error with the end time of the seesion
    public void testStopTimer() {
        System.out.println("StopTimer");
        Session instance = new Session();
        long stopTime=instance.StartTimer();
        assertTrue(stopTime>0);
    }

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
     * Test of setTotalTimeInMillie method, of class Session.
     */
    @Test
    public void testSetTotalTimeInMillie() {
        System.out.println("setTotalTimeInMillie");
        Session instance = new Session();
        instance.setTotalTimeInMillie();
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
     * Test of setTotalTimeInSeconds method, of class Session.
     */
    @Test
    public void testSetTotalTimeInSeconds() {
        System.out.println("setTotalTimeInSeconds");
        long TotalTimeInSeconds = 0L;
        Session instance = new Session();
        instance.setTotalTimeInSeconds(TotalTimeInSeconds);

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
     * Test of setTotalTimeInMinutes method, of class Session.
     */
    @Test
    public void testSetTotalTimeInMinutes() {
        System.out.println("setTotalTimeInMinutes");
        long TotalTimeInMinutes = 0L;
        Session instance = new Session();
        instance.setTotalTimeInMinutes(TotalTimeInMinutes);
    
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

    /**
     * Test of setPagesReadInSession method, of class Session.
     */
    @Test
    public void testSetPagesReadInSession() {
        System.out.println("setPagesReadInSession");
        int pagesReadInSession = 0;
        Session instance = new Session();
        instance.setPagesReadInSession(pagesReadInSession);

    }
    
}
