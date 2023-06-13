/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustudy;

import java.text.ParseException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Hebah Turki
 */
public class ScheduleTest {
    
    public ScheduleTest() {
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
     * Test of getEdate method, of class Schedule.
     */
     @Test(timeout = 20)
    public void testCalcEndDate() throws ParseException {
        String ExpectedEndDate = "14/12/2001";
        Schedule instance = new Schedule();
        instance.CalcEndDate("12/12/2001", 2);
        assertEquals(ExpectedEndDate, instance.Edate);
        
    }

    
}
