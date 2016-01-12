/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Koen
 * @author http://www.roelvanlisdonk.nl/?p=2950
 */
public interface IRijksdriehoekComponent {

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public ArrayList<String> ConvertToLatLong(double x, double y);

}


