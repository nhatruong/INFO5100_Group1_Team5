package com.neuSep17.service;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

import com.neuSep17.dao.DealerIncentiveImple;
import com.neuSep17.dto.DealerIncentive;
import com.neuSep17.dto.Incentive;
import com.neuSep17.io.FileReading;
import com.neuSep17.io.FileWriting;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.omg.PortableInterceptor.INACTIVE;

/*
	Author: ZJ
	Last Modified: Nov 28, 2017
 */

//THIS CLASS IMPLEMENTS LOGIC TO ACCESS INCENTIVE FILE
public class DealerIncentiveImpleService {

    private FileReading fileReading;
    private FileWriting fileWriting;
	protected ArrayList<Incentive> allIncentives;
    File incentiveFile = new File("data/incentive");

	//initialize the instance of the Dealer Incentive

	public DealerIncentiveImpleService(){
        allIncentives = fileReading.readAndGetIncentives(incentiveFile);
	}

	//main function is created for testing
	public static void main(String[] args){
		DealerIncentiveImpleService test = new DealerIncentiveImpleService();

		for(Incentive i : test.getDealerIncentives("unknown")){
		    System.out.println(i);
        }


	}

	public ArrayList<Incentive> getDealerIncentives(String dealerID){
        ArrayList<Incentive> dealerIncentive = new ArrayList<>();
	    for(Incentive i : allIncentives){
            if(i.getDealerID().equals(dealerID))
                dealerIncentive.add(i);
        }

        return dealerIncentive;
	}
	// may have a list of incentive. Need to check the array list. Most likely there is only
	//one incentive in the array list
	public boolean createIncentive(String dealerID, Incentive incentive) {
		boolean isSuccess = false;

		try{
		    fileReading = new FileReading(incentiveFile);
		    fileReading.checkID(incentive.getID());

		    fileWriting = new FileWriting(incentiveFile, true);
		    BufferedWriter bw = fileWriting.getBufferedWriter();

		    StringBuilder sb = new StringBuilder();
		    sb.append(incentive.getDealerID()).append("~");
            sb.append(incentive.getID()).append("~");
            sb.append(incentive.getTitle()).append("~");
            sb.append(incentive.getStartDate()).append("~");
            sb.append(incentive.getEndDate()).append("~");
            sb.append(incentive.getDescription()).append("~");
            sb.append(incentive.getCashValue()).append("~");
            sb.append(incentive.getDiscountCriteria());

            bw.write(sb.toString()+ "\n" );

            bw.close();
            isSuccess = true;

        } catch (IOException e){
		    e.printStackTrace();
        }

		return isSuccess;
	}

	//Get A Specific Incentive
	public Incentive getAIncentive(String dealerID, String incentiveID) {
		DealerIncentive incent =null;
		Incentive inc = new Incentive();
		ArrayList<Incentive> incents = getDealerIncentives(dealerID);
		for(Incentive i : incents){
		    if(i.getID().equals(incentiveID)){
                inc = i;
                break;
            }
        }
		return inc;
	}


	public boolean updateIncentive(String dealerID, String incentiveID, HashMap<String, String> updatesFieldAndValues) {
        Boolean isSuccess = false;

        List<Integer> indices = new ArrayList<>();
        String[] titles = {"dealerid", "id", "title", "startdate", "endate", "description", "cashvalue", "criteria"};

        for(int i = 0; i < titles.length; i++){
            String title = titles[i];
            for (String type : updatesFieldAndValues.keySet()){
                if(title.equals(type)){
                    indices.add(i);
                }
            }
        }

        try{
            fileReading = new FileReading(incentiveFile);

            //read from incentive file to hashmap
            HashMap<DealerIncentivePair, String> tmpMap = new HashMap<>();
            BufferedReader br = fileReading.getBufferedReader();
            String line = br.readLine(); //skip the first line
            while((line = br.readLine()) != null){
                String[] words = line.split("~");

                if(words[0].equals(dealerID) && words[1].equals(incentiveID)){
                    for (int index : indices){
                        words[index] = updatesFieldAndValues.get(titles[index]);
                    }

                    line = "";
                    for (int i = 0; i < words.length; i++){
                        if(i == words.length - 1){
                            line += words[i];
                        } else{
                            line += words[i] + "~";
                        }
                    }
                }

                tmpMap.put(new DealerIncentivePair(words[0], words[1]), line);
            }
            br.close();

            //write from HashMap to incentive file
            fileWriting = new FileWriting(incentiveFile, false);
            writeToFile(tmpMap);

            isSuccess = true;

        } catch (IOException e){
            e.printStackTrace();
        }

        return isSuccess;
	}


	public Boolean udpateIncentiveCriteria(String dealerID, String incentiveID, ArrayList<String> cArrayList) {
        boolean isSuccess = false;
		try{
		    fileReading = new FileReading(incentiveFile);
            HashMap<DealerIncentive, String> tmpMap = new HashMap<>();
            BufferedReader br = fileReading.getBufferedReader();
            String line = br.readLine(); //skip the first line
            while((line = br.readLine()) != null){
                String[] words = line.split("~");
                if(words[0].equals(dealerID) && words[0].equals(incentiveID)){
                    String newCriteria = cArrayList.get(0) + "\\u002B" + cArrayList.get(1);
                    words[7] = newCriteria;
                }
                line = "";
                for(int i =0; i < words.length; i++){
                    if (i == words.length - 1){
                         line += words[i];
                        } else{
                        line += words[i] + "~";
                    }
                }
            }
		} catch (IOException e){
		    e.printStackTrace();
        }
		return isSuccess;
	}
	public boolean deleteIncentivesByDealerID(String dealerID, String incentiveID) {
        boolean isSuccess = false;

        try{
            fileReading = new FileReading(incentiveFile);
            HashMap<DealerIncentivePair, String> tmpMap = new HashMap<>();
            BufferedReader br = fileReading.getBufferedReader();
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] words = line.split("~");
                if(words[0].equals(incentiveID)) continue;
                tmpMap.put(new DealerIncentivePair(words[0], words[1]), line);
            }

            br.close();

            //write from HashMap to Incentive file
            fileWriting = new FileWriting(incentiveFile, false);
            writeToFile(tmpMap);

            isSuccess = true;

        }catch (IOException e){
            e.printStackTrace();
        }

        return isSuccess;
	}

	private void writeToFile(HashMap<DealerIncentivePair, String> tmpMap) throws IOException{
		BufferedWriter bw = fileWriting.getBufferedWriter();
		StringBuilder sb = new StringBuilder("dealerid~id~title~startdate~endate~description~cashvalue~criteria");
		sb.append("\n");
		for(String s : tmpMap.values()){
			sb.append(s).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

	private class  DealerIncentivePair{
		String dealerID;
		String incentiveID;

		DealerIncentivePair(String dealerID, String incentiveID){
			this.dealerID = dealerID;
			this.incentiveID = incentiveID;
		}
	}




}
