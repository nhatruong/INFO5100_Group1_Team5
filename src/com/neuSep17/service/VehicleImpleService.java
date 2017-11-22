package com.neuSep17.service;

import java.util.ArrayList;

import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;

//THIS CLASS IMPLEMENTS LOGIC TO ACCESS gmps-****-*** files

public class VehicleImpleService {
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
	public Inventory searchVechile(String dealerID, String valueToBeSearched, String searchBy){
		Inventory inventory=null; //return an array of length 1
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return inventory;
	}
	public boolean addVehicle(Vehicle v) {
		boolean isSuccess =false;
		
		return isSuccess;
	}
	public Boolean updateVehicle(String dealerID, String vehicleID, String newValue, String updateType) {
		boolean isSuccess=false;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return isSuccess;
	}
	public boolean deleteVehicle(String vehicleID) {
		boolean isSuccess=false;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return isSuccess;
	}
	
}
