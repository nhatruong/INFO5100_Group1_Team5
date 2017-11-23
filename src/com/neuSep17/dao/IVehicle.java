package com.neuSep17.dao;
import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;


import java.util.ArrayList;
import java.util.HashMap;


public interface IVehicle {

/*	ArrayList<Inventory> getAllVehicles(String dealerID);
	ArrayList<Inventory> getAllVehicles();
	Vehicle getAVehicle(String dealerId, String vehicleIdID);	
	ArrayList<Inventory> searchVechile(String dealerID, String valueToBeSearched, String searchBy);	
	boolean addVehicle(String dealerID, Vehicle v);
	boolean updateVehicle(String dealerID, String vehicleID, String newValue, String updatingField);
	boolean deleteVehicle(String dealerID, String vehicleID);
	*/
	ArrayList<Inventory> getAllVehicles();	
	Vehicle getAVehicle(String vehicleIdID);	
	ArrayList<Inventory> searchVechile(HashMap<String, String> searchCriteria);	
	boolean addVehicle(Vehicle v);
	boolean updateVehicle(String vehicleID, String newValue, String updatingField);
	boolean deleteVehicle(String vehicleID);
}
