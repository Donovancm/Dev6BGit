/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import controller.CSVReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Michel
 */
@Entity
public class Positions implements IReader {

    private String dateTime;
    private String unitID;
    private String rdx;
    private String rdy;
    private String speed;
    private String course;
    private String numSatellites;
    private String hdop;
    private String quality;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

    public String getRdx() {
        return rdx;
    }

    public void setRdx(String rdx) {
        this.rdx = rdx;
    }

    public String getRdy() {
        return rdy;
    }

    public void setRdy(String rdy) {
        this.rdy = rdy;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getNumSatellites() {
        return numSatellites;
    }

    public void setNumSatellites(String numSatellites) {
        this.numSatellites = numSatellites;
    }

    public String getHdop() {
        return hdop;
    }

    public void setHdop(String hdop) {
        this.hdop = hdop;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public ArrayList readFile(String csvFolderPath, String fileName) {
        // The settings object provides many configuration options
        CsvParserSettings parserSettings = new CsvParserSettings();

        //You can configure the parser to automatically detect what line separator sequence is in the input
        parserSettings.setLineSeparatorDetectionEnabled(true);

        // A RowListProcessor stores each parsed row in a List.
        RowListProcessor rowProcessor = new RowListProcessor();

        // You can configure the parser to use a RowProcessor to process the values of each parsed row.
        // You will find more RowProcessors in the 'com.univocity.parsers.common.processor' package, but you can also create your own.
        parserSettings.setRowProcessor(rowProcessor);

        // Let's consider the first parsed row as the headers of each column in the file.
        parserSettings.setHeaderExtractionEnabled(true);

        // creates a parser instance with the given settings
        CsvParser parser = new CsvParser(parserSettings);

        try {
            // the 'parse' method will parse the file and delegate each parsed row to the RowProcessor you defined
            parser.parse(getReader(csvFolderPath + "/" + fileName + ".csv"));
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        // get the parsed records from the RowListProcessor here.
        // Note that different implementations of RowProcessor will provide different sets of functionalities.
        String[] headers = rowProcessor.getHeaders();
        List<String[]> rows = rowProcessor.getRows();
        ArrayList<Positions> list = new ArrayList<>();

        IRijksdriehoekComponent converter = new RijksdriehoekComponent();

        rows.stream().forEach((String[] row) -> {

            list.add((Positions) setAndSplitRow(row, converter));
        });

//        System.out.println(Arrays.toString(headers));
//        System.out.println(rows.size());
        return list;
    }

    public Positions setAndSplitRow(String[] row, IRijksdriehoekComponent converter) {
        Positions position = new Positions();

        int index = 0;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setUnitID((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        double rdx = Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        double rdy = Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        ArrayList<String> result = converter.ConvertToLatLong(rdx, rdy);

        position.setRdx(result.get(0));
        position.setRdy(result.get(1));

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setSpeed((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setCourse((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setNumSatellites((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setHdop((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].length()));
        position.setQuality((String) row[0].subSequence(index, row[0].length()));

        return position;
    }

    public Reader getReader(String csvFolderPath) throws UnsupportedEncodingException, FileNotFoundException {
        return new InputStreamReader(new FileInputStream(new File(csvFolderPath)), "UTF-8");
    }
}
