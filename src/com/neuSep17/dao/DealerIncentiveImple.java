package com.neuSep17.dao;

import java.util.ArrayList;

import com.neuSep17.dto.DealerIncentive;
import com.neuSep17.dto.Incentive;
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
		public ArrayList<DealerIncentive> getAllIncentives(){
			return impleService.getAllIncentives(dealerIncentive.getDealerId());
		}
		// may have a list of incentive. Need to check the array list
		public ArrayList<DealerIncentive> createIncentive() {
			return impleService.createIncentive(dealerIncentive.getDealerId(), dealerIncentive.getIncentives());
		}
		public DealerIncentive getIncentive(String incentiveID) {
			return impleService.getIncentive(dealerIncentive.getDealerId(), incentiveID);
		}
		public DealerIncentive updateIncentive(String incentiveID, String newValue, String updatingField) {
			return impleService.updateIncentive(dealerIncentive.getDealerId(), incentiveID, newValue, updatingField);
		}
		public DealerIncentive udpateIncentiveCriteria(String incentiveID, ArrayList<String> cArrayList) {
			return impleService.udpateIncentiveCriteria(dealerIncentive.getDealerId(),incentiveID, cArrayList);
		}
		public void deleteIncentive(String incentiveID) {
			impleService.deleteIncentive(dealerIncentive.getDealerId(),incentiveID);
		}
		
	

}
