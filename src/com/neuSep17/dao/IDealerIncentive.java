package com.neuSep17.dao;

import java.util.ArrayList;

import com.neuSep17.dto.DealerIncentive;
import com.neuSep17.dto.Incentive;

public interface IDealerIncentive {
	ArrayList<DealerIncentive> getAllIncentives();
	ArrayList<DealerIncentive> createIncentive();
	DealerIncentive getIncentive(String incentiveID);
	DealerIncentive updateIncentive(String incentiveID, String newValue, String updatingField);
	DealerIncentive udpateIncentiveCriteria(String incentiveID, ArrayList<String> cArrayList);
	void deleteIncentive(String incentiveID);
}
