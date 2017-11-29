package com.neuSep17.service;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.neuSep17.dto.Dealer;
import com.neuSep17.io.DealerFileReading;
import com.neuSep17.io.DealerFileWriting;
//THIS CLASS IMPLEMENTS LOGIC TO ACCESS DEALER FILE

public class  DealerImpleService {
	Map<String, Dealer> map;
	
	public DealerImpleService() throws IOException {
		DealerFileReading reading = new DealerFileReading(new File("data/dealers"));
		map = reading.loading();
	}
	
	public ArrayList<Dealer> getDealers(){
		ArrayList<Dealer> arrDealer = null;
		arrDealer = new ArrayList<>(map.values());

		return arrDealer;
	}

	public Dealer getADealer(String dealerID) {
		Dealer dealer = null;
		dealer = map.get(dealerID);
		return dealer;
	}

	public boolean updateDealer(String dealerID, HashMap<String, String> updateFieldsAndValues) {
		boolean isSuccess =false;
		if (!dealerID.contains(dealerID)) {
			return isSuccess;
		}
		Dealer dealer = map.get(dealerID);
		for (String m : updateFieldsAndValues.keySet()) {

			if (m.equals("id")) {
				dealer.setId(updateFieldsAndValues.get(m));
				isSuccess = true;
				continue;
			}

			if (m.equals("name")) {
				dealer.setName(updateFieldsAndValues.get(m));
				isSuccess = true;
				continue;
			}

			if (m.equals("url")) {
				dealer.setUrl(updateFieldsAndValues.get(m));
				isSuccess = true;
			}

		}

		saveFile();
		return isSuccess;
	}

	public boolean addDealer(Dealer dealer) {
		boolean isSuccess =false;

		if (map.containsKey(dealer.getId())) {
			return isSuccess;
		}

		map.put(dealer.getId(), new Dealer(dealer.getId(), dealer.getName(), dealer.getUrl()));
		saveFile();
		return isSuccess;
	}

	public boolean deleteDealer(String dealerID) {
		boolean isSuccess = false;
		String str = "";
		for (String m : map.keySet()) {
			if (m.equals(dealerID)) {
				str = m;
				isSuccess = true;
			}
		}

		map.remove(str);
		saveFile();
		return isSuccess;
		
	}

	private void saveFile() {
		try {
			DealerFileWriting writing = new DealerFileWriting(new File("data/dealers"));
			writing.saveToFile(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
