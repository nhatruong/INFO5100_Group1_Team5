package com.neuSep17.dao;

import java.util.ArrayList;

import com.neuSep17.dto.Dealer;

public interface IDealer {
	ArrayList<Dealer>getDealers();
	Dealer getADealer(String dealerID);
	Boolean updateDealer(String dealerID, String newValue, String updatingField);
	Boolean addDealer(Dealer dealer);
	Boolean deleteDealer(String dealerID);
}
