package com.neuSep17.service;

import java.util.ArrayList;
import java.util.Collection;

import com.neuSep17.dto.*;


public interface IService {
	//methods for Dealers
	ArrayList<Dealer>getDealers();
	Dealer getADealer(String dealerID);
	Boolean updateDealer(String dealerID, String oldValue, String newValue);
	Boolean addDealer(Dealer dealer);
	Boolean deleteDealer(String dealerID);

	//methods for Vehicles
	ArrayList<Vehicle> getVehicleList(String dealerID);	
	Vehicle getVehicleAtADealer(String dealerId, String cardID);
	Boolean updateVehicle(String dealerId, String vehicleId, String oldValue, String newValue);

	//methods for Inventory
	Inventory getInventory(String dealerID);
	Boolean updateInventory(String dealerID, Collection<Vehicle> vehicles);
}
