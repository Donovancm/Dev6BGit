/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author donovan
 */
public class ConfigTest {
    
    public ConfigTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("SetupClass Config is executing");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass Config is executing");
    }
    
    @Before
    public void setUp() {
        System.out.println("setUp Config is executing");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCSVFolderPath method, of class Config.
     */
    @Test
    public void testGetCSVFolderPath() throws Exception {
        System.out.println("getCSVFolderPath");
        Config instance = new Config();
        String expResult = "/home/donovan/csvFiles";
        String result = instance.getCSVFolderPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
