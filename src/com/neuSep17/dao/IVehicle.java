package com.neuSep17.dao;
import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;

import java.util.ArrayList;


public interface IVehicle {

	ArrayList<Inventory> getAllVehicles(String dealerID);	
	Vehicle getAVehicle(String dealerId, String vehicleIdID);
	//this method should return an Inventory array of length 1
	Inventory[] searchVechile(String dealerID, String valueToBeSearched, String searchBy);
	
	Boolean updateVehicle(String dealerID, String vehicleID, String newValue, String updateType);
}
