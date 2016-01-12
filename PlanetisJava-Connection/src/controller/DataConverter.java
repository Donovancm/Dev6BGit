/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Events;
import model.Positions;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michel
 */
public class DataConverter {
    
    public void convertEventsToObject() {
        String csvFileToRead = "csvFiles/Events.csv";
        BufferedReader br = null;
        String line = "";
        String splitBy = ";";
        List<Events> evtList = new ArrayList<Events>();

        try {

            br = new BufferedReader(new FileReader(csvFileToRead));
            while ((line = br.readLine()) != null) {

                // split on comma(';')
                String[] eventjes = line.split(splitBy);

                // create evt object to store values
                Events evtObject = new Events();

                // add values from csv to evt object
                evtObject.setDateTime(eventjes[0]);
                evtObject.setUnitID(eventjes[1]);
                evtObject.setPort(eventjes[2]);
                evtObject.setValue(eventjes[3]);

                // adding evt objects to a list
                evtList.add(evtObject);

            }
            // print values stored in evtList
            printEvtList(evtList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    //Een check om te kijken of alle data er goed uit komt.
    public void printEvtList(List<Events> evtListToPrint) {
        for (int i = 0; i < evtListToPrint.size(); i++) {
            System.out.println("Event [Date Time= " + evtListToPrint.get(i).getDateTime()
                    + " , UnitID=" + evtListToPrint.get(i).getUnitID()
                    + " , Port=" + evtListToPrint.get(i).getPort()
                    + " , Value=" + evtListToPrint.get(i).getValue() + "]");
        }
    }
    
    
    protected void convertPositionsToObject() {
        String csvFileToRead = "home/donovan/csvFiles/Positions.csv";
        BufferedReader br = null;
        String line = "";
        String splitBy = ";";
        List<Positions> posList = new ArrayList<Positions>();

        try {

            br = new BufferedReader(new FileReader(csvFileToRead));
            while ((line = br.readLine()) != null) {

                // split on comma(';')
                String[] positionation = line.split(splitBy);

                // create evt object to store values
                Positions posObject = new Positions();

                // add values from csv to evt object
                posObject.setDateTime(positionation[0]);
                posObject.setUnitID(positionation[1]);
                posObject.setRdx(positionation[2]);
                posObject.setRdy(positionation[3]);
                posObject.setSpeed(positionation[4]);
                posObject.setCourse(positionation[5]);
                posObject.setNumSatellites(positionation[6]);
                posObject.setHdop(positionation[7]);
                posObject.setQuality(positionation[8]);

                // adding evt objects to a list
                posList.add(posObject);

            }
            // print values stored in evtList
            printPosList(posList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    //Een check om te kijken of alle data er goed uit komt.
    public void printPosList(List<Positions> posListToPrint) {
        for (int i = 0; i < posListToPrint.size(); i++) {
            System.out.println("Event [Date Time= " + posListToPrint.get(i).getDateTime()
                    + " , UnitID=" + posListToPrint.get(i).getUnitID()
                    + " , Rdx=" + posListToPrint.get(i).getRdx()
                    + " , Rdy=" + posListToPrint.get(i).getRdy() 
                    + " , Speed=" + posListToPrint.get(i).getSpeed() 
                    + " , Course=" + posListToPrint.get(i).getCourse()
                    + " , NumSatellites=" + posListToPrint.get(i).getNumSatellites()
                    + " , HDOP=" + posListToPrint.get(i).getHdop()
                    + " , Quality=" + posListToPrint.get(i).getQuality() + "]");
            
        }
    }
    
    
    public void splitRdxPositionData() {
        //TO DO: De rdx moet alleen de waarde voor de . bevatten. Deze moet dus
        // gesplit worden
    }
    
    
    public void splitRdyPositionData() {
        //TO DO: De rdy moet alleen de waarde voor de . bevatten. Deze moet dus
        // gesplit worden
    }
    
    
    public void calculateCoordinates() {
        //Ingevoerde RDX en RDY waarden
        double rdxValue = 158126;
        double rdyValue = 380446;

        // The city "Amsterfoort" is used as reference "Rijksdriehoek" coordinate.
        int referenceRdX = 155000;
        int referenceRdY = 463000;

        double dX = (rdxValue - referenceRdX) * (Math.pow(10, -5));
        double dY = (rdyValue - referenceRdY) * (Math.pow(10, -5));

        double sumN =
                (3235.65389 * dY) +
                        (-32.58297 * Math.pow(dX, 2)) +
                        (-0.2475 * Math.pow(dY, 2)) +
                        (-0.84978 * Math.pow(dX, 2) * dY) +
                        (-0.0655 * Math.pow(dY, 3)) +
                        (-0.01709 * Math.pow(dX, 2) * Math.pow(dY, 2)) +
                        (-0.00738 * dX) +
                        (0.0053 * Math.pow(dX, 4)) +
                        (-0.00039 * Math.pow(dX, 2) * Math.pow(dY, 3)) +
                        (0.00033 * Math.pow(dX, 4) * dY) +
                        (-0.00012 * dX * dY);
        double sumE =
                (5260.52916 * dX) +
                        (105.94684 * dX * dY) +
                        (2.45656 * dX * Math.pow(dY, 2)) +
                        (-0.81885 * Math.pow(dX, 3)) +
                        (0.05594 * dX * Math.pow(dY, 3)) +
                        (-0.05607 * Math.pow(dX, 3) * dY) +
                        (0.01199 * dY) +
                        (-0.00256 * Math.pow(dX, 3) * Math.pow(dY, 2)) +
                        (0.00128 * dX * Math.pow(dY, 4)) +
                        (0.00022 * Math.pow(dY, 2)) +
                        (-0.00022 * Math.pow(dX, 2)) +
                        (0.00026 * Math.pow(dX, 5));


        // The city "Amsterfoort" is used as reference "WGS84" coordinate.
        double referenceWgs84X = 52.15517;
        double referenceWgs84Y = 5.387206;

        double latitude = referenceWgs84X + (sumN / 3600);
        double longitude = referenceWgs84Y + (sumE / 3600);

        //Check
        System.out.println(latitude +", "+ longitude);
    }
    
    
    public void calcuteLongtitude (int rdxValue) {
        //TO DO: Automatisch rdx naar longtitude veranderen
        
        // The city "Amsterfoort" is used as reference "Rijksdriehoek" coordinate.
        int referenceRdX = 155000;
        
        double dX = (rdxValue - referenceRdX) * (Math.pow(10, -5));
    }
    
    
    public void calculateLatitude(int rdyValue) {
        //TO DO: Automatisch rdy naar latitude veranderen
        
        // The city "Amsterfoort" is used as reference "Rijksdriehoek" coordinate.
        int referenceRdY = 463000;
        
        double dY = (rdyValue - referenceRdY) * (Math.pow(10, -5));
    }
    
}
