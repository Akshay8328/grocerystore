package com.jiem.grocerystore.model;

public class Customer {
	
	String Type;
	int arrival_offset;
	int items;
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getArrival_offset() {
		return arrival_offset;
	}
	public void setArrival_offset(int arrival_offset) {
		this.arrival_offset = arrival_offset;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}

}
