/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustudy;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class LearningMaterialTest {

    public LearningMaterialTest() {
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
     * Test of addLearningMaterial method, of class LearningMaterial.
     */
    @Test
    public void testAddLearningMaterial() {
        System.out.println("addLearningMaterial");

        Subject subject = new Subject(1, "CPCS251");
        LearningMaterial LM = new LearningMaterial(subject, 10, "chapter 1", 89);
        LearningMaterial instance = new LearningMaterial();

        instance.addLearningMaterial(LM);

        assertEquals(LM, instance.getLMbyId(10));

    }

    /**
     * Test of existMaterial method, of class LearningMaterial.
     */
    @Test
    public void testExistMaterial() {
        System.out.println("existMaterial");
        int id = 5;

        Subject subject = new Subject(1, "CPCS251");
        LearningMaterial LM = new LearningMaterial(subject, id, "chapter 1", 89);
        LearningMaterial instance = new LearningMaterial();

        instance.addLearningMaterial(LM);

        assertTrue(instance.existMaterial(id));

    }

    /**
     * Test of deleteMaterial method, of class LearningMaterial.
     */
    @Test
    public void testDeleteMaterial() {
        System.out.println("deleteMaterial");
        int id = 10;

        Subject subject = new Subject(1, "CPCS251");
        LearningMaterial LM = new LearningMaterial(subject, id, "chapter 1", 89);
        LearningMaterial instance = new LearningMaterial();

        instance.addLearningMaterial(LM);
        instance.deleteMaterial(id);

        assertNull(instance.getLMbyId(id));

    }

    /**
     * Test of getLMbyId method, of class LearningMaterial.
     */
    @Test
    public void testGetLMbyId() {
        System.out.println("getLMbyId");

        int id = 15;

        Subject subject = new Subject(1, "CPCS251");
        LearningMaterial LM = new LearningMaterial(subject, id, "chapter 2", 89);
        LearningMaterial instance = new LearningMaterial();

        instance.addLearningMaterial(LM);

        LearningMaterial expResult = LM;
        LearningMaterial result = instance.getLMbyId(id);

        assertEquals(expResult, result);

    }


    /**
     * Test of NumOfLM method, of class LearningMaterial.
     */
    @Test
    public void testNumOfLM() {
        System.out.println("NumOfLM");

        int id = 20;

        Subject subject = new Subject(1, "CPCS251");
        LearningMaterial LM = new LearningMaterial(subject, id, "chapter 2", 89);
        LearningMaterial instance = new LearningMaterial();

        instance.addLearningMaterial(LM);

        int expResult = 1;
        int result = instance.NumOfLM(1);
        assertEquals(expResult, result);

    }

}
