package com.neuSep17.dao;

import java.util.ArrayList;

import com.neuSep17.dto.Dealer;
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
	
	private Dealer dealer;
	private VehicleImpleService vehicleImpleService;
	
	public VehicleImple(Dealer d) {
		this.dealer =d;
		vehicleImpleService = new VehicleImpleService();
	}
	public ArrayList<Inventory> getAllVehicles(){		
		return vehicleImpleService.getAllVehicles(dealer.getId());		
	}
	public Vehicle getAVehicle(String vehicleIdID) {
		return vehicleImpleService.getAVehicle(dealer.getId(), vehicleIdID);
	}
	public ArrayList<Inventory> searchVechile(String valueToBeSearched, String searchBy){		
		return vehicleImpleService.searchVechile(dealer.getId(), valueToBeSearched, searchBy);
	}
	public boolean addVehicle(Vehicle v) {
		return vehicleImpleService.addVehicle(dealer.getId(), v);
	}
	public boolean updateVehicle(String vehicleID, String newValue, String updateType) {		
		return vehicleImpleService.updateVehicle(dealer.getId(), vehicleID, newValue, updateType);
	}
	public boolean deleteVehicle(String vehicleID) {
		return vehicleImpleService.deleteVehicle(dealer.getId(), vehicleID);
	}
}
