/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Secretary;
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
public class SecretaryBuilderTest {
    
    private static Secretary secretary;
    
    public SecretaryBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SecretaryBuilder builder = new SecretaryBuilder();
        
        builder.setAddress("TestLn");
        builder.setFirstName("Sally");
        builder.setSurname("Green");
        builder.setPassword("password");
        builder.setUserNum(17);
        secretary = builder.build();
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
        assertEquals(17, (long) secretary.getNum());
    }

    @Test
    public void testSetFirstName() {
        assertEquals("Sally", secretary.getFirstName());
    }

    @Test
    public void testSetSurname() {
        assertEquals("Green", secretary.getSurname());
    }

    @Test
    public void testSetAddress() {
        assertEquals("TestLn", secretary.getAddress());
    }

    @Test
    public void testSetPassword() {
        assertEquals("password", secretary.getPassword());
    }

    @Test
    public void testGetType() {
        assertEquals('S', secretary.getType());
    }
}
