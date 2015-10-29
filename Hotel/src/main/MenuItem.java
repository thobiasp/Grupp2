package main;

public class MenuItem {

	enum Types {
		FOOD, DRINK
	}
	private Types type;
	private String name;
	private String description;
	private float price;
	
	public MenuItem(){
		this.type = null;
		this.name = "";
		this.description = "";
		this.price = 0f;
	}
	public MenuItem(Types type,String name, String description, float price) {
		this.type = type;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
