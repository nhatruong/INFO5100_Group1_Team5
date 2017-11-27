package com.neuSep17.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;

import com.neuSep17.dto.Category;
import com.neuSep17.dto.Dealer;
import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;
import com.neuSep17.io.FileReading;
import com.neuSep17.service.VehicleImpleService;
import com.neuSep17.validation.DealerValidation;
import com.neuSep17.validation.VehicleValidation;

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
	
	/********************************************************************
	 * HashMap<String, String>: 
	 * 		First String: must be one of the fields in the Vehicle class
	 * 					(model, make, year etc..)	
	 * 		Second String: Corresponding value to update
	 * Exceptions:
	 * 		FileNotFoundExceptions: if the dealer file not found
	 * 		NullPointerException:	if the HashMap is null
	 * 		IllegalStateException:	if the HashMap is empty
	 */
	@Override	
	public ArrayList<Inventory> searchVechile(HashMap<String, String> searchCretiria){	
		VehicleValidation.checkHashMap(searchCretiria);
		return vehicleImpleService.searchVechile(dealer.getId(),searchCretiria);
	}
	/********************************************************************
	 * Exceptions:
	 * 		FileNotFoundExceptions: if the dealer file not found
	 * 		IllegalArgumentException : if id is already added
	 */	
	@Override
	public boolean addVehicle(Vehicle v) throws IOException {		 
		validateVehicleID("data\\"+v.getWebID(), v.getID());//vehicle file and vehicle id
		return vehicleImpleService.addVehicle(dealer.getId(), v);
	}
	//validate dealer name and vehicleID
	private void validateVehicleID(String fileName, String vehicleID) throws IOException {
		FileReading fileReading = new FileReading(new File(fileName));
		fileReading.checkID(vehicleID);
	}
	
	/********************************************************************
	 * Exceptions:
	 * 		NullPointerException:	if the HashMap is null
	 * 		IllegalStateException:	if the HashMap is empty
	 */
	@Override
	public boolean updateVehicle(String vehicleID, HashMap<String, String> updateFieldsAndValues) {
		DealerValidation.checkHashMap(updateFieldsAndValues);
		return vehicleImpleService.updateVehicle(dealer.getId(), vehicleID, updateFieldsAndValues);
	}
	@Override
	public boolean deleteVehicle(String vehicleID) {
		return vehicleImpleService.deleteVehicle(dealer.getId(), vehicleID);
	}
	
}
