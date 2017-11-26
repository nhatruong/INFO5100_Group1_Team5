package com.neuSep17.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;

//THIS CLASS IMPLEMENTS LOGIC TO ACCESS gmps-****-*** files

public class VehicleImpleService {
	//private Vehicle vehicle;
	public VehicleImpleService() {}
	

	public ArrayList<Inventory> getAllVehicles(String dealerID){
		ArrayList<Inventory> arrInventory =null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return arrInventory;
		
	}
	public Vehicle getAVehicle(String dealerId, String vehicleIdID) {		
		Vehicle vehicle =null;
		
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return vehicle;
	}
	public ArrayList<Inventory> searchVechile(String dealerID, String vehicleID, HashMap<String, String> searchCretiria){
		ArrayList<Inventory> inventory=null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return inventory;
	}
	public boolean addVehicle(String dealerId, Vehicle v) {
		boolean isSuccess =false;
		
		return isSuccess;
	}
	public Boolean updateVehicle(String dealerID, String vehicleID, HashMap<String, String> updateFieldsAndValues) {
		boolean isSuccess=false;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return isSuccess;
	}
	public boolean deleteVehicle(String dealerID, String vehicleID) {
		boolean isSuccess=false;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return isSuccess;
	}
	
}
