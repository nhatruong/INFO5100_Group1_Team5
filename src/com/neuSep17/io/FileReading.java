package com.neuSep17.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.regex.Pattern;
import com.neuSep17.dto.*;


public class FileReading {
	//private FileReading fileReading;
	//private BufferedReader bufferedReader;
	private String currentLine;
	private String[] words;
	
	
	private BufferedReader bufferedReader;
	public FileReading(File file) throws FileNotFoundException {
		bufferedReader= new BufferedReader(new FileReader(file));
	}
	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}
	//validate dealerID and vehicleID
	public void checkID(String ID) throws IOException {
		while ((currentLine = bufferedReader.readLine()) != null)
		{
			currentLine =currentLine.trim();
			//split vehicle info
			if(currentLine.contains("~")) {
				words=currentLine.split("~+");
			}
			//split dealer
			else {
				words=currentLine.split("\\s+"); 
			}
		
			if(words[0].equalsIgnoreCase(ID)) {				
				throw new IllegalArgumentException("The id "+"\""+ID +"\"" +" is already added.");
			}	
		}	
	}
	
	
// This function is used by the Inventory constructor to populate vehicle data --Zhongfei
    public static ArrayList<Vehicle> readAndGetVehicles(File file) {
        ArrayList<Vehicle> vs = new ArrayList<>();
        Pattern pattern = Pattern.compile("~");
        try (BufferedReader in = new BufferedReader(new FileReader(file));) {
            String line = in.readLine(); // skip first line
            while ((line = in.readLine()) != null) {
                String[] x = pattern.split(line);
                Vehicle v = new Vehicle(x);
                vs.add(v);
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return vs;
    }

}

/*
public void read(File file) throws IOException {
 * private BufferedReader buffReader;
		buffReader = new BufferedReader(new FileReader(file));
		while ((currentLine = buffReader.readLine()) != null) {
			if(currentLine.length()==0) continue;
			currentLine =currentLine.trim();
			words=currentLine.split(" +"); 
			
			
			for(int i=0; i<words.length; i++) {
				add(words[i], i);					
			}
			
			//keep only previous line length after the first line
			previousLineLength+= words.length;					
		}			
	}
*/
