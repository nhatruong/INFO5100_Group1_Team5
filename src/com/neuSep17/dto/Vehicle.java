package com.neuSep17.dto;

import java.net.URL;


public class Vehicle {

        private String id;
        private Integer year;
        private String make;
        private String model;
        private String trim;
        private Category category;
        private String bodyType;
        private Float price;
        private URL photoUrl;
        
        public Vehicle() {			
		}
        public Vehicle(String[] arr){
        	
        }
        public void setID(String id) {
        	this.id=id;
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
        public void setPrice(Float price) {
        	this.price=price;
        }
        public void setPhotoURL(URL url) {
        	this.photoUrl=url;
        }
        
        public String getID() {
        	return id;
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
        public float getPrice() {
        	return price;
        }
        public URL getPhotoURL() {
        	return photoUrl;
        }
        
        
}
