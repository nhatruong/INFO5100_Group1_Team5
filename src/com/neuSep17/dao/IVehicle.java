package com.neuSep17.dao;
import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;

import java.util.ArrayList;


public interface IVehicle {

	ArrayList<Inventory> getAllVehicles(String dealerID);	
	Vehicle getAVehicle(String dealerId, String vehicleIdID);	
	Inventory searchVechile(String dealerID, String valueToBeSearched, String searchBy);	
	boolean addVehicle(Vehicle v);
	boolean updateVehicle(String dealerID, String vehicleID, String newValue, String updatingField);
	boolean deleteVehicle(String vehicleID);
}
