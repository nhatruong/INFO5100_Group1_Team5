package com.neuSep17.validation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import com.neuSep17.io.FileReading;

public class VehicleValidation {
	private FileReading fileReading;

	public VehicleValidation(File file) throws FileNotFoundException {
		fileReading = new FileReading(file);		
	}
	//for add
	public void checkVehicleID(String vehicleID) throws IOException {
		fileReading.checkID(vehicleID);			
	}
	//update
	public static void checkHashMap(HashMap<String, String> hashMap) {
		if(hashMap == null) {
			throw new NullPointerException("List is null");
		}
		if(hashMap.isEmpty()) {
			throw new IllegalStateException("Empty list");
		}		
	}
}
