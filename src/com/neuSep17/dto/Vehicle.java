package com.neuSep17.dto;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;


public class Vehicle {

        private String id;
        String webId;
        private Category category;
        private int year;
        private String make;
        private String model;
        private String trim;
       
        private String bodyType;
        private Double price;
        private URL photoUrl;
        
        public Vehicle() {
		}
        public Vehicle(String[] arr){
        	this.id = arr[0];
            this.webId = arr[1];
            this.category = Category.getCategory(arr[2].toLowerCase());
            this.year = Integer.parseInt(arr[3]);
            this.make = arr[4];
            this.model = arr[5];
            this.trim = arr[6];
            this.bodyType = arr[7];
            this.price = Double.parseDouble(arr[8]);
            try {
                this.photoUrl = new URL(arr[9]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        public void setID(String id) {
        	this.id=id;
        }
        public void setWebID(String webId) {
        	this.webId=webId;
        }
        public void setYear(int year) {
        	this.year=year;
        }
        public void setMake(String make) {
        	this.make=make;
        }
        public void setModle(String model) {
        	this.model=model;
        }
        public void setTrim(String trim) {
        	this.trim=trim;
        }
        public void setCategory(Category c) {
        	category =c;
        }
        public void setBodyType(String type) {
        	this.bodyType=type;
        }
        public void setPrice(Double price) {
        	this.price=price;
        }
        public void setPhotoURL(URL url) {
        	this.photoUrl=url;
        }
        
        public String getID() {
        	return id;
        }
        public String getWebID() {
        	return webId;
        }
        public int getYear() {
        	return year;
        }
        public String getMake() {
        	return make;
        }
        public String getModle() {
        	return model;
        }
        public String getTrim() {
        	return trim;
        }
        public Category getCategory() {
        	return category;
        }
        public String getBodyType() {
        	return bodyType;
        }
        public double getPrice() {
        	return price;
        }
        public URL getPhotoURL() {
        	return photoUrl;
        }
        
        
}
