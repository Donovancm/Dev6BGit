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
 */
public interface IReader {

    /**
     *
     * @param csvFolderPath
     * @param fileName
     * @return 
     */
    public ArrayList readFile(String csvFolderPath, String fileName);
}
