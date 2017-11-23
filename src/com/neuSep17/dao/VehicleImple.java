package com.neuSep17.dao;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	@Override	
	public ArrayList<Inventory> getAllVehicles(){	
			return vehicleImpleService.getAllVehicles(dealer.getId());					
	}
	@Override
	public Vehicle getAVehicle(String vehicleIdID) {
		return vehicleImpleService.getAVehicle(dealer.getId(), vehicleIdID);
	}
	@Override
	public ArrayList<Inventory> searchVechile(HashMap<String, String> searchCretiria){		
		return vehicleImpleService.searchVechile(dealer.getId(), searchCretiria);
	}
	@Override
	public boolean addVehicle(Vehicle v) {
		return vehicleImpleService.addVehicle(dealer.getId(), v);
	}
	@Override
	public boolean updateVehicle(String vehicleID, HashMap<String, String> updateFieldsAndValues) {		
		return vehicleImpleService.updateVehicle(dealer.getId(), vehicleID, updateFieldsAndValues);
	}
	@Override
	public boolean deleteVehicle(String vehicleID) {
		return vehicleImpleService.deleteVehicle(dealer.getId(), vehicleID);
	}
}
