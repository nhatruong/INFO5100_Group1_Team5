package com.neuSep17.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

import com.neuSep17.dto.Dealer;
import com.neuSep17.io.FileReading;
import com.neuSep17.io.FileWriting;

//THIS CLASS IMPLEMENTS LOGIC TO ACCESS DEALER FILE

public class DealerImpleService {
	Map<String, Dealer> map;

	public static void main(String[] args) {

		try {
			DealerImpleService test = new DealerImpleService();
			//Dealer dealer = new Dealer("HAHA", "Haha", );
			HashMap<String, String> map = new HashMap<>();
			map.put("url", "haha");
			test.updateDealer("haha", map);
			//test.addDealer(new Dealer("gmps-haha","gmps-haha", "www.4399.com"));


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DealerImpleService() throws IOException {
		map = new LinkedHashMap<>();
		BufferedReader reader = null;
		FileReading reading = new FileReading(new File("data/dealers"));
		reader = reading.getBufferedReader();
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}

			String[] strs = line.split("\t");
			reading.checkID(strs[0]);
			map.put(strs[0], new Dealer(strs[0], strs[0], strs[2]));
		}
		reader.close();
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
		Dealer dealer = map.get(dealerID);
		for (String m : updateFieldsAndValues.keySet()) {
			if (!dealerID.equals(m)) {
				continue;
			}

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

		saveToFile("data/dealers");
		return isSuccess;
	}

	public boolean addDealer(Dealer dealer) {
		boolean isSuccess =false;
		for (String m : map.keySet()) {
			if (m.equals(dealer.getId())) {
				return isSuccess;
			}
		}

		map.put(dealer.getId(), new Dealer(dealer.getId(), dealer.getName(), dealer.getUrl()));
		saveToFile("data/dealers");
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
		saveToFile("data/dealers");
		return isSuccess;
		
	}

	private void saveToFile(String pathName)  {
		BufferedWriter writer = null;
		try {
			FileWriting writing = new FileWriting(new File(pathName));
			writer = writing.getBufferedWriter();
			for (String m : map.keySet()) {
				writer.write(map.get(m).getId() + "\t" +
						"en_US" + "\t" + map.get(m).getUrl());
				writer.newLine();
			}
		} catch (Exception e) {

		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
