package com.neuSep17.dao;

import java.util.ArrayList;
import java.util.HashMap;
import com.neuSep17.dto.DealerIncentive;
import com.neuSep17.service.DealerIncentiveImpleService;

/*********************************************************
 * This class does not access the INCENTIVE file directly.
 * Hence, all the methods in this class must call the corresponding
 * methods provided in the IncentiveImpleService class (located in the com.neuSep17.service folder), 
 * which reads data from the dealer file, and returns them to the calling methods
 *
 *********************************************************/

public class DealerIncentiveImple implements IDealerIncentive {
		
		private DealerIncentive dealerIncentive;
		
		private DealerIncentiveImpleService impleService;
		
		public DealerIncentiveImple(DealerIncentive d) {
			this.dealerIncentive =d;
			impleService= new DealerIncentiveImpleService();
		}
		@Override
		public ArrayList<DealerIncentive> getAllIncentives(){
			return impleService.getAllIncentives(dealerIncentive.getDealerId());
		}
		// may have a list of incentive. Need to check the array list
		@Override
		public ArrayList<DealerIncentive> createIncentive() {
			return impleService.createIncentive(dealerIncentive.getDealerId(), dealerIncentive.getIncentives());
		}
		@Override
		public DealerIncentive getIncentive(String incentiveID) {
			return impleService.getIncentive(dealerIncentive.getDealerId(), incentiveID);
		}
		
		/********************************************************************
		 * HashMap<String, String>: 
		 * 		First String: must be one of the fields in the Incentive class
		 * 					(ID, title, startDate, endDate, description, cashvalue)	
		 * 		Second String: Corresponding value
		 */
		@Override
		public DealerIncentive updateIncentive(String incentiveID, HashMap<String, String> updateFieldsAndValues) {
			return impleService.updateIncentive(dealerIncentive.getDealerId(), updateFieldsAndValues);
		}
		/********************************************************************
		 * ArrayList<String>: 
		 * 		an list of criteria used for this incentive. Ok to create an list of 1 element
		 */
		@Override
		public DealerIncentive udpateIncentiveCriteria(String incentiveID, ArrayList<String> cArrayList) {
			return impleService.udpateIncentiveCriteria(dealerIncentive.getDealerId(),incentiveID, cArrayList);
		}
		@Override
		public void deleteIncentive(String incentiveID) {
			impleService.deleteIncentive(dealerIncentive.getDealerId(),incentiveID);
		}
		
	

}
