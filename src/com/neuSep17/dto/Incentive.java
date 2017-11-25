package com.neuSep17.dto;

import java.util.ArrayList;


public class Incentive {
	private String ID;
	private String title;
	private String startDate; //format should be "MM-DD-YYY"
	private String endDate;//format should be "MM-DD-YYY"
	private String description;
	private float cashValue;
	
	//NOTE: convert this to String using + sign as delimiter between criteria before save to the file
	private  ArrayList<String> discountCriteria = new ArrayList<>();
	
	public Incentive() {}
	public Incentive(String ID,String title, String startDate, String endDate, String description, 
			float cashValue, ArrayList<String> discountCriteria) {
		this.ID =ID; this.title =title; this.startDate=startDate; 
		this.endDate=endDate; this.description=description; this.cashValue=cashValue; 
		this.discountCriteria=discountCriteria;
	}
	
	public void setID(String id) {
		ID=id;
	}
	public void setTitle(String t) {
		title=t;
	}
	public void setStartDate(String sD) {
		startDate =sD;
	}
	public void setEndDate(String eD) {
		endDate =eD;
	}
	public void setDescription(String d) {
		description=d;
	}
	public void setCashValue(float cV) {
		cashValue=cV;
	}
	public void setDiscountCriteria(ArrayList<String> dC) {
		discountCriteria=dC;
	}
	
	public String getID() {
		return ID;
	}
	public String getTitle() {
		return title;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getDescription() {
		return description;
	}
	public float getCashValue() {
		return cashValue;
	}
	public ArrayList<String> getDiscountCriteria() {
		return discountCriteria;
	}
}
