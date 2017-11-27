package com.neuSep17.dao;
import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public interface IVehicle {

	Inventory getAllVehicles();	
	Vehicle getAVehicle(String vehicleIdID);	
	ArrayList<Inventory> searchVechile(HashMap<String, String> searchCriteria);	
	boolean addVehicle(Vehicle v) throws FileNotFoundException, IOException;
	boolean updateVehicle(String vehicleID, HashMap<String, String>updateFieldsAndValues);
	boolean deleteVehicle(String vehicleID);
}
