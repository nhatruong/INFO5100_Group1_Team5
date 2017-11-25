package com.neuSep17.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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