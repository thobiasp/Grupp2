package main;

public abstract class Room {

	protected String name;
	protected int roomNum;
	
	protected Room() {
		this.name = "Light Yagami";
		this.roomNum=123;
	}
	
	protected Room(String name, int roomNum) {
		this();
		this.name = name;
		this.roomNum = roomNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
}
