package com.neuSep17.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.neuSep17.dto.Dealer;
import com.neuSep17.service.DealerImpleService;
import com.neuSep17.validation.DealerValidation;

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
	private DealerValidation dealerValidation;
	
	public DealerImple() throws FileNotFoundException {
		dealerImpleService = new DealerImpleService();
		dealerValidation = new DealerValidation(new File("data\\dealers"));
	}
	@Override
	public ArrayList<Dealer>getDealers(){				
		return dealerImpleService.getDealers();
	}
	@Override
	public Dealer getADealer(String dealerID) {	
		return dealerImpleService.getADealer(dealerID);
	}
	/********************************************************************
	 * HashMap<String, String>: 
	 * 		First String: must be one of the fields in the Dealer class
	 * 					(id, name, url)	
	 * 		Second String: Corresponding value to update
	 * Exceptions:
	 * 		FileNotFoundExceptions: if the dealer file not found
	 * 		NullPointerException:	if the HashMap is null
	 * 		IllegalStateException:	if the HashMap is empty
	 */
	@Override
	public boolean updateDealer(String dealerID, HashMap<String, String> updateFieldsAndValues) {		
		DealerValidation.checkHashMap(updateFieldsAndValues);
		return dealerImpleService.updateDealer(dealerID, updateFieldsAndValues);
	}
	
	/********************************************************************
	 * Exceptions:
	 * 		IllegalArgumentException: if dealerID is already added
	 */
	@Override
	public boolean addDealer(Dealer dealer) throws IOException{
		dealerValidation.checkDealerID(dealer.getId());
		return dealerImpleService.addDealer(dealer);			
	}
	
	@Override
	public boolean deleteDealer(String dealerID) {	
		return dealerImpleService.deleteDealer(dealerID);
		
	}
}
