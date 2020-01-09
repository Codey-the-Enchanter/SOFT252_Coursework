/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Patient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class PatientBuilderTest {
    
    private static Patient patient;
    
    public PatientBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        PatientBuilder builder = new PatientBuilder();
        
        builder.setAddress("TestLn");
        builder.setFirstName("Sally");
        builder.setSurname("Green");
        builder.setPassword("password");
        builder.setUserNum(17);
        builder.setGender("male");
        builder.setAge(12);
        patient = builder.build();
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

    @Test
    public void testSetUserNum() {
        assertEquals(17, (long) patient.getNum());
    }

    @Test
    public void testSetFirstName() {
        assertEquals("Sally", patient.getFirstName());
    }

    @Test
    public void testSetSurname() {
        assertEquals("Green", patient.getSurname());
    }

    @Test
    public void testSetAddress() {
        assertEquals("TestLn", patient.getAddress());
    }

    @Test
    public void testSetPassword() {
        assertEquals("password", patient.getPassword());
    }

    @Test
    public void testGetType() {
        assertEquals('P', patient.getType());
    }
    
    @Test
    public void testSetGender() {
        assertEquals("male", patient.getGender());
    }

    @Test
    public void testSetAge() {
        assertEquals(12, (long) patient.getAge());
    }
}
