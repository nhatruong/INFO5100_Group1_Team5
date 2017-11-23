package com.neuSep17.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.neuSep17.dto.DealerIncentive;


public interface IDealerIncentive {
	ArrayList<DealerIncentive> getAllIncentives();
	ArrayList<DealerIncentive> createIncentive();
	DealerIncentive getIncentive(String incentiveID);
	DealerIncentive updateIncentive(String incentiveID, HashMap<String, String> updateFieldsAndValues);
	DealerIncentive udpateIncentiveCriteria(String incentiveID, ArrayList<String> criteria);
	void deleteIncentive(String incentiveID);
}
