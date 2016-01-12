/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Events;
import model.Positions;
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
public class DataConverterTest {
    
    public DataConverterTest() {
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
     * Test of convertEventsToObject method, of class DataConverter.
     */
    @Test
    public void testConvertEventsToObject() {
        System.out.println("convertEventsToObject");
        DataConverter instance = new DataConverter();
        instance.convertEventsToObject();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printEvtList method, of class DataConverter.
     */
    @Test
    public void testPrintEvtList() {
        System.out.println("printEvtList");
        List<Events> evtListToPrint = null;
        DataConverter instance = new DataConverter();
        //instance.printEvtList(evtListToPrint);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convertPositionsToObject method, of class DataConverter.
     */
    @Test
    public void testConvertPositionsToObject() {
        System.out.println("convertPositionsToObject");
        DataConverter instance = new DataConverter();
        instance.convertPositionsToObject();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printPosList method, of class DataConverter.
     */
    @Test
    public void testPrintPosList() {
        System.out.println("printPosList");
        List<Positions> posListToPrint = null;
        DataConverter instance = new DataConverter();
        //instance.printPosList(posListToPrint);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of splitRdxPositionData method, of class DataConverter.
     */
    @Test
    public void testSplitRdxPositionData() {
        System.out.println("splitRdxPositionData");
        DataConverter instance = new DataConverter();
        instance.splitRdxPositionData();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of splitRdyPositionData method, of class DataConverter.
     */
    @Test
    public void testSplitRdyPositionData() {
        System.out.println("splitRdyPositionData");
        DataConverter instance = new DataConverter();
        instance.splitRdyPositionData();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCoordinates method, of class DataConverter.
     */
    @Test
    public void testCalculateCoordinates() {
        System.out.println("calculateCoordinates");
        DataConverter instance = new DataConverter();
        instance.calculateCoordinates();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calcuteLongtitude method, of class DataConverter.
     */
    @Test
    public void testCalcuteLongtitude() {
        System.out.println("calcuteLongtitude");
        int rdxValue = 0;
        DataConverter instance = new DataConverter();
        instance.calcuteLongtitude(rdxValue);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateLatitude method, of class DataConverter.
     */
    @Test
    public void testCalculateLatitude() {
        System.out.println("calculateLatitude");
        int rdyValue = 0;
        DataConverter instance = new DataConverter();
        instance.calculateLatitude(rdyValue);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
