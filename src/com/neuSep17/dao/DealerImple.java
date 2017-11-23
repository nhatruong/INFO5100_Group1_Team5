package com.neuSep17.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.neuSep17.dto.Dealer;
import com.neuSep17.service.DealerImpleService;

/*********************************************************
 * This class does not access the dealer file directly.
 * Hence, all the methods in this class must call the corresponding
 * methods provided in the DealerImpleService class (located in the com.neuSep17.service folder), 
 * which reads data from the dealer file, and returns them to the calling methods
 *
 *********************************************************/

//provide implementations for IDealer interface
public class DealerImple implements IDealer {
	private DealerImpleService dealerImpleService;
	public DealerImple() {
		dealerImpleService = new DealerImpleService();
	}
	@Override
	public ArrayList<Dealer>getDealers(){				
		return dealerImpleService.getDealers();
	}
	@Override
	public Dealer getADealer(String dealerID) {		
		return dealerImpleService.getADealer(dealerID);
	}
	@Override
	public boolean updateDealer(String dealerID, HashMap<String, String> updateFieldsAndValues) {		
		return dealerImpleService.updateDealer(dealerID, updateFieldsAndValues);
	}
	@Override
	public boolean addDealer(Dealer dealer) {	
		return dealerImpleService.addDealer(dealer);
	}
	@Override
	public boolean deleteDealer(String dealerID) {	
		return dealerImpleService.deleteDealer(dealerID);
		
	}
}
