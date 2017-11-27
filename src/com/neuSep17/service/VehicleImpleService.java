package com.neuSep17.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.neuSep17.dto.Inventory;
import com.neuSep17.dto.Vehicle;
import com.neuSep17.io.FileReading;
import com.neuSep17.io.FileWriting;

//THIS CLASS IMPLEMENTS LOGIC TO ACCESS gmps-****-*** files

public class VehicleImpleService {
	FileReading fileReading;
	FileWriting fileWriting;
	String prefix = "data/"; // directory path


	//private Vehicle vehicle;
	public VehicleImpleService() {}
	

	public ArrayList<Inventory> getAllVehicles(String dealerID){
		ArrayList<Inventory> arrInventory =null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return arrInventory;
		
	}
	public Vehicle getAVehicle(String dealerId, String vehicleIdID) {		
		Vehicle vehicle =null;
		
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return vehicle;
	}
	public ArrayList<Inventory> searchVechile(String dealerID, HashMap<String, String> searchCretiria){
		ArrayList<Inventory> inventory=null;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return inventory;
	}
	public boolean addVehicle(String dealerID, Vehicle v) {
		boolean isSuccess =false;

		try {
			File file = new File(prefix); // directory path
			String[] files = file.list();
			for (String f : files) {
				if (f.contains(dealerID)) {
					fileReading = new FileReading(new File(prefix + f));
					fileReading.checkID(v.getID());

					fileWriting = new FileWriting(new File(prefix + f), true);
					BufferedWriter bw = fileWriting.getBufferedWriter();

					StringBuilder sb = new StringBuilder();
					sb.append(v.getID()).append("~");
					sb.append(v.getWebID()).append("~");
					sb.append(v.getCategory()).append("~");
					sb.append(v.getYear()).append("~");
					sb.append(v.getMake()).append("~");
					sb.append(v.getModle()).append("~");
					sb.append(v.getTrim()).append("~");
					sb.append(v.getBodyType()).append("~");
					sb.append(v.getPrice()).append("~");
					sb.append(v.getPhotoURL());

					bw.write(sb.toString() + "\n");

					bw.close();
					isSuccess = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	public Boolean updateVehicle(String dealerID, String vehicleID, HashMap<String, String> updateFieldsAndValues) {
		boolean isSuccess=false;
		List<Integer> indices = new ArrayList<>();
		String[] titles = {"id", "webID", "category", "year", "make", "model", "trim", "type", "price", "photo"};
		for (int i = 0; i < titles.length; i++) {
			String title = titles[i];
			for (String type : updateFieldsAndValues.keySet()) {
				if (title.equals(type)) {
					indices.add(i);
				}
			}
		}

		try {
			File file = new File(prefix); // directory path
			String[] files = file.list();
			for (String f : files) {
				if (f.contains(dealerID)) {
					fileReading = new FileReading(new File(prefix + f));

					// read from vehicle files to HashMap
					HashMap<DealerVehiclePair, String> tmpMap = new HashMap<>();
					BufferedReader br = fileReading.getBufferedReader();
					String line = br.readLine(); // ignore the first line of vehicle txt files
					while ((line = br.readLine()) != null) {
						String[] words = line.split("~");

						if (words[0].equals(vehicleID)) {
							for (int index : indices) {
								words[index] = updateFieldsAndValues.get(titles[index]);
							}
							line = "";
							for (int i = 0; i < words.length; i++) {
								if (i == words.length - 1) {
									line += words[i];
								}else {
									line += words[i] + "~";
								}
							}
						}
						tmpMap.put(new DealerVehiclePair(words[1], words[0]), line);
					}
					br.close();

					// write from HashMap to vehicle files
					fileWriting = new FileWriting(new File(prefix + f), false);
					writeToFiles(tmpMap);

					isSuccess = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	public boolean deleteVehicle(String dealerID, String vehicleID) {
		boolean isSuccess=false;

		try {
			File file = new File(prefix); // directory path
			String[] files = file.list();
			for (String f : files) {
				if (f.contains(dealerID)) {
					fileReading = new FileReading(new File(prefix + f));

					// read from vehicle files to HashMap
					HashMap<DealerVehiclePair, String> tmpMap = new HashMap<>();
					BufferedReader br = fileReading.getBufferedReader();
					String line = br.readLine(); // ignore the first line of vehicle txt files
					while ((line = br.readLine()) != null) {
						String[] words = line.split("~");
						if (words[0].equals(vehicleID)) continue;
						tmpMap.put(new DealerVehiclePair(words[1], words[0]), line);
					}
					br.close();

					// write from HashMap to vehicle files
					fileWriting = new FileWriting(new File(prefix + f), false);
					writeToFiles(tmpMap);

					isSuccess = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	private void writeToFiles(HashMap<DealerVehiclePair, String> tmpMap) throws IOException {
		BufferedWriter bw = fileWriting.getBufferedWriter();
		StringBuilder sb = new StringBuilder("id~webId~category~year~make~model~trim~type~price~photo");
		sb.append("\n");
		for (String s : tmpMap.values()) {
			sb.append(s).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

	private class DealerVehiclePair {
		String dealerID;
		String vehicleID;

		DealerVehiclePair(String dealerID, String vehicleID) {
			this.dealerID = dealerID;
			this.vehicleID = vehicleID;
		}
	}
}
