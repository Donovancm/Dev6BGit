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
public class Monitoring implements IReader{
    
    private String unitID;
    private String beginTime;
    private String endTime;
    private String type;
    private String min;
    private String max;
    private String sum;
    
    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }
    
    public String getBeginTime() {
        return beginTime;
    }
    
    public void setDateTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
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
        ArrayList<Monitoring> list = new ArrayList<>();

        rows.stream().forEach((String[] row) -> {
            list.add((Monitoring) setAndSplitRow(row));
        });

//        System.out.println(Arrays.toString(headers));
//        System.out.println(rows.size());
        return list;
    }

    public Monitoring setAndSplitRow(String[] row) {
        Monitoring monitor = new Monitoring();

        int index = 0;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setUnitID((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setEndTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;
        
        //            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setType((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;
        
        //            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setMin((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;
        
        //            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setMax((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].length()));
        monitor.setSum((String) row[0].subSequence(index, row[0].length()));

        return monitor;
    }

    public Reader getReader(String csvFolderPath) throws UnsupportedEncodingException, FileNotFoundException {
        return new InputStreamReader(new FileInputStream(new File(csvFolderPath)), "UTF-8");
    }
}
