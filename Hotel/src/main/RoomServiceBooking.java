 package main;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RoomServiceBooking extends Booking {
	private ArrayList<MenuItem> items = null;
	private float bookingPrice = 0f;
	
	
	public RoomServiceBooking(){
		super(LocalDateTime.now(),LocalDateTime.now(), BType.FOOD_DRINK);
	}
	
	public RoomServiceBooking(ArrayList<MenuItem> items,float price) {
		this();
		this.items = items;
		this.bookingPrice = price;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}

	public float getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(float bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

}
