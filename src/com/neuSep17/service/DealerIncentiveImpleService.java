package com.neuSep17.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.neuSep17.dao.DealerIncentiveImple;
import com.neuSep17.dto.DealerIncentive;
import com.neuSep17.dto.Incentive;


//THIS CLASS IMPLEMENTS LOGIC TO ACCESS INCENTIVE FILE
public class DealerIncentiveImpleService {

	Map<String, DealerIncentive> map;

	//main function is created for testing
	public static void main(String[] args){
		DealerIncentiveImpleService test = new DealerIncentiveImpleService();
		



	}
	public ArrayList<DealerIncentive> getAllIncentives(String dealerID){
		ArrayList<DealerIncentive> dealerIncentives=null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return dealerIncentives;
	}
	// may have a list of incentive. Need to check the array list. Most likely there is only
	//one incentive in the array list
	public ArrayList<DealerIncentive> createIncentive(String dealerID, ArrayList<Incentive> incentives) {
		ArrayList<DealerIncentive> incent = null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return incent;		
	}
	public DealerIncentive getIncentive(String dealerID, String incentiveID) {
		DealerIncentive incent =null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return incent;
	}
	public DealerIncentive updateIncentive(String dealerID, HashMap<String, String> updatesFieldAndValues) {
		DealerIncentive incent =null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return incent;
	}
	public DealerIncentive udpateIncentiveCriteria(String dealerID, String incentiveID, ArrayList<String> cArrayList) {
		DealerIncentive incent =null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return incent;
	}
	public void deleteIncentive(String dealerID, String incentiveID) {
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
	}

}
