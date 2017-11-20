package com.neuSep17.service;

import java.util.ArrayList;

import com.neuSep17.dto.Dealer;
import com.neuSep17.dto.Vehicle;

public interface IService {
	ArrayList<Dealer>getDealers();
	Dealer getADealer(String dealerID);
	Boolean updateDealer(String dealerID, String oldValue, String newValue);
	Boolean addDealer(Dealer dealer);
	Boolean deleteDealer(String dealerID);
	
	ArrayList<Vehicle> getVehicleList(String dealerID);	
	Vehicle getVehicleAtADealer(String dealerId, String cardID);
	Boolean updateVehicle(String dealerId, String vehicleId, String oldValue, String newValue);
	
	
}
