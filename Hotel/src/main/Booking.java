package main;

import java.time.LocalDateTime;

// Har skickat ett mail till alla som har all kod som behövs för de nya Datum/Tid fälten. - Lisa 

public abstract class Booking extends Room {
	
	protected LocalDateTime createdDT; //Dag och tid då bokningen skapades 
	protected LocalDateTime startDT; //Datum och tid då eventet börjar
	protected LocalDateTime stopDT; //Datum och tid då eventet slutar

	protected float price;
	
	protected enum BType {FOOD_DRINK,SPA,TRANSPORT,HOUSEKEEPING}
	protected BType type;
	
	protected Booking(String name, int roomNum){
		super(name, roomNum);
	}
	
	public Booking(String name, int roomNum,LocalDateTime createdDT, LocalDateTime startDT, LocalDateTime stopDT, float price, BType type) {
		this(name, roomNum);
		this.createdDT = createdDT;
		this.startDT = startDT;
		this.stopDT = stopDT;
		this.price = price;
		this.type = type;
	}

	protected Booking(String name, int roomNum, LocalDateTime createdDT, LocalDateTime startDT, BType type ) {
		this(name,roomNum);
		this.createdDT = createdDT;
		this.startDT = startDT;
		this.type = type;
	}

	public LocalDateTime getCreatedDT() {
		return createdDT;
	}
	
	public String getCreatedDtAsString(){
		String date = createdDT.getYear() + "-" + createdDT.getMonth() + "-" + createdDT.getDayOfMonth();
		String time = createdDT.getHour() + "." + createdDT.getMinute();
		return date + " " + time;
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

	public BType getType() {
		return type;
	}

	public void setType(BType type) {
		this.type = type;
	}
}
