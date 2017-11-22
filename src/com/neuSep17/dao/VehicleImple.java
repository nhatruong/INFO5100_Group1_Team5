package com.neuSep17.dao;

import java.util.ArrayList;

import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;
import com.neuSep17.service.VehicleImpleService;

/*********************************************************
 * This class does not access gmps-**** files directly.
 * Hence, all the methods in this class must call the corresponding
 * methods provided in the VehicleImpleService class (located in the com.neuSep17.service folder),
 * which reads data from the gmps-***files, and returns them to the calling methods
 *
 *********************************************************/

//provide implementations for IVehicle interface
public class VehicleImple implements IVehicle {
	
	private VehicleImpleService vehicleImpleService;
	public VehicleImple() {
		vehicleImpleService = new VehicleImpleService();
	}
	public ArrayList<Inventory> getAllVehicles(String dealerID){		
		return vehicleImpleService.getAllVehicles(dealerID);		
	}
	public Vehicle getAVehicle(String dealerId, String vehicleIdID) {
		return vehicleImpleService.getAVehicle(dealerId, vehicleIdID);
	}
	public Inventory searchVechile(String dealerID, String valueToBeSearched, String searchBy){		
		return vehicleImpleService.searchVechile(dealerID, valueToBeSearched, searchBy);
	}
	public boolean addVehicle(Vehicle v) {
		return vehicleImpleService.addVehicle(v);
	}
	public boolean updateVehicle(String dealerID, String vehicleID, String newValue, String updateType) {		
		return vehicleImpleService.updateVehicle(dealerID, vehicleID, newValue, updateType);
	}
	public boolean deleteVehicle(String vehicleID) {
		return vehicleImpleService.deleteVehicle(vehicleID);
	}
}
