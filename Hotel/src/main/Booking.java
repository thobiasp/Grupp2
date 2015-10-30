package main;

import java.time.LocalDateTime;

// Har skickat ett mail till alla som har all kod som behövs för de nya Datum/Tid fälten. - Lisa 

public class Booking extends Room {
	
	protected LocalDateTime createdDT; //Dag och tid då bokningen skapades 
	protected LocalDateTime startDT; //Datum och tid då eventet börjar
	protected LocalDateTime stopDT; //Datum och tid då eventet slutar

	protected float price;
	protected enum Type {FOOD_DRINK,TREATMENT,SAUNA,JACUZZI,TAXI,HOUSEKEEPING}
	protected Type type;
	
	//PONTUS
	int month;
	int day;
	int hour;
	int minute;
	String specification;
	//////////////////////
	
	public Booking(){
		super();
	}
	
	
	public Booking(float price, Type type){
		createdDT= LocalDateTime.now();
		this.price = price;
		this.type = type;
	}
	
	
	public Booking(LocalDateTime createdDT, LocalDateTime startDT, LocalDateTime stopDT, float price, Type type) {
		this();
		this.createdDT = createdDT;
		this.startDT = startDT;
		this.stopDT = stopDT;
		this.price = price;
		this.type = type;
	}
	
	// PONTUS
	public Booking(int month, int day, int hour, int minute, float price, String specification, Type type){
		createdDT= LocalDateTime.now();
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.price = price;
		this.specification = specification;
		this.type = type;
	}
	
	public Booking(int month, int day, int hour, int minute, String specification, Type type){
		createdDT= LocalDateTime.now();
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.specification = specification;
		this.type = type;
	}
	///////////////////////

	public Booking(LocalDateTime createdDT, LocalDateTime startDT, Type type ) {
		this();
		this.createdDT = createdDT;
		this.startDT = startDT;
		this.type = type;
	}

	public LocalDateTime getCreatedDT() {
		return createdDT;
	}
	
	public String getCreatedDtAsString(){
		String date = createdDT.getYear() + "-" + createdDT.getMonth() + "-" + createdDT.getDayOfMonth();
		String time = createdDT.getHour() + "." + createdDT.getMinute()+"."+createdDT.getSecond();
		return date + " " + time;
	}
	
	public String getTypeAsString(){
		String typeToString = type.toString() ;
		return typeToString;
	}

	public void setCreatedDT(LocalDateTime createdDT) {
		this.createdDT = createdDT;
	}

	public LocalDateTime getStartDT() {
		return startDT;
	}
	
	public String getStartDtAsString(){
		String date = startDT.getYear() + "-" + startDT.getMonth() + "-" + startDT.getDayOfMonth();
		String time = startDT.getHour() + "." + startDT.getMinute();
		return date + " " + time;
	}

	public void setStartDT(LocalDateTime startDT) {
		this.startDT = startDT;
	}

	public LocalDateTime getStopDT() {
		return stopDT;
	}
	
	public String getStopDtAsString(){
		String date = stopDT.getYear() + "-" + stopDT.getMonth() + "-" + stopDT.getDayOfMonth();
		String time = stopDT.getHour() + "." + stopDT.getMinute();
		return date + " " + time;
	}

	public void setStopDT(LocalDateTime stopDT) {
		this.stopDT = stopDT;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getPriceAsString(){
		String priceString = Float.toString(price);
		return priceString;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
