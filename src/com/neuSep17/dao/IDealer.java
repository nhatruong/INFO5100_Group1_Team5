package com.neuSep17.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.neuSep17.dto.Dealer;

public interface IDealer {
	ArrayList<Dealer>getDealers();
	Dealer getADealer(String dealerID);
	boolean updateDealer(String dealerID, HashMap<String, String> updateFieldsAndValues);
	boolean addDealer(Dealer dealer);
	boolean deleteDealer(String dealerID);
}
