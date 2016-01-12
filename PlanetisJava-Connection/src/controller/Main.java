/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import static com.oracle.jrockit.jfr.ContentType.Address;
import com.sun.jndi.cosnaming.IiopUrl.Address;
import model.IReader;
import model.Config;
import java.io.IOException;
import java.util.ArrayList;
import model.Connections;
import model.Events;
import model.Monitoring;
import model.Positions;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Michel
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

       Config readConfig = new Config();
        String csvFolderPath = readConfig.getCSVFolderPath();
        IReader posReader = new Positions();
        IReader eveReader = new Events();
        IReader monReader = new Monitoring();
        IReader conReader = new Connections();
/*
        posReader.readFile(csvFolderPath, "Positions");
        eveReader.readFile(csvFolderPath, "Events");
        monReader.readFile(csvFolderPath, "Monitoring");
        ArrayList<Connections> conList = conReader.readFile(csvFolderPath, "Connections");
        ArrayList<Events> evList = eveReader.readFile(csvFolderPath, "Events");
        ArrayList<Monitoring> monList = monReader.readFile(csvFolderPath, "Monitoring");
        ArrayList<Positions> posList = posReader.readFile(csvFolderPath, "Positions");
        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("testdb");
        //Can only apply on of the methods below because if we turn on all the methods it cause 
        //an out of memory leak error for me
        
        
        conList.stream().forEach((Connections connection) -> {
          
            // map the blog entry to a Mongo DBObject
            DBObject connectionsEntryDbObj = morphia.toDBObject(connection);

            // and then save that DBObject in a Mongo collection
            db.getCollection("Connection").save(connectionsEntryDbObj);
        
        });
        
        
        evList.stream().forEach((Events events) -> {    
            DBObject connectionsEntryDbObj = morphia.toDBObject(events);
            db.getCollection("Events").save(connectionsEntryDbObj);
        });
        
        monList.stream().forEach((Monitoring monitoring) -> {    
            DBObject connectionsEntryDbObj = morphia.toDBObject(monitoring);
            db.getCollection("Monitoring").save(connectionsEntryDbObj);
        });
        
        
        posList.stream().forEach((Positions positions) -> {    
            DBObject connectionsEntryDbObj = morphia.toDBObject(positions);
            db.getCollection("Positions").save(connectionsEntryDbObj);
        });
      */           
    }

}
