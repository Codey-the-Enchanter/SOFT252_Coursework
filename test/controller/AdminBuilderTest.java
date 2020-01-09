/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Administrator;
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
public class AdminBuilderTest {
    
    private static Administrator admin;
    
    public AdminBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        AdminBuilder builder = new AdminBuilder();
        
        builder.setAddress("TestLn");
        builder.setFirstName("Sally");
        builder.setSurname("Green");
        builder.setPassword("password");
        builder.setUserNum(17);
        admin = builder.build();
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
        assertEquals(17, (long) admin.getNum());
    }

    @Test
    public void testSetFirstName() {
        assertEquals("Sally", admin.getFirstName());
    }

    @Test
    public void testSetSurname() {
        assertEquals("Green", admin.getSurname());
    }

    @Test
    public void testSetAddress() {
        assertEquals("TestLn", admin.getAddress());
    }

    @Test
    public void testSetPassword() {
        assertEquals("password", admin.getPassword());
    }

    @Test
    public void testGetType() {
        assertEquals('A', admin.getType());
    }
}
