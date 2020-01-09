/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Doctor;
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
public class DoctorBuilderTest {
    private static Doctor doc;
    
    public DoctorBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        DoctorBuilder builder = new DoctorBuilder();
        
        builder.setAddress("TestLn");
        builder.setFirstName("Sally");
        builder.setSurname("Green");
        builder.setPassword("password");
        builder.setUserNum(17);
        doc = builder.build();
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
        assertEquals(17, (long) doc.getNum());
    }

    @Test
    public void testSetFirstName() {
        assertEquals("Sally", doc.getFirstName());
    }

    @Test
    public void testSetSurname() {
        assertEquals("Green", doc.getSurname());
    }

    @Test
    public void testSetAddress() {
        assertEquals("TestLn", doc.getAddress());
    }

    @Test
    public void testSetPassword() {
        assertEquals("password", doc.getPassword());
    }

    @Test
    public void testGetType() {
        assertEquals('D', doc.getType());
    }
}
