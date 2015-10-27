package main;

import java.util.Date;

public abstract class Booking extends Room {
	
	protected Date date; 
	protected Date startTime;
	protected Date stopTime;
	protected float price;
	protected Date bookingTime;
	protected enum BType {FOOD_DRINK,SPA,TRANSPORT,HOUSEKEEPING}
	protected BType type;
	
	protected Booking(String name, int roomNum){
		super(name, roomNum);
		// change in file
	}
	
	protected Booking(String name, int roomNum, Date date, Date startTime, Date stopTime, float price, BType type) {
		this(name,roomNum);
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.price = price;
		this.type = type;
	}
	
	protected Booking(String name, int roomNum, Date date, Date startTime, BType type ) {
		this(name,roomNum);
		this.date = date;
		this.startTime = startTime;
		this.price = 0f;
		this.stopTime = null;
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public BType getType() {
		return type;
	}

	public void setType(BType type) {
		this.type = type;
	}
	
	
	
	
}
