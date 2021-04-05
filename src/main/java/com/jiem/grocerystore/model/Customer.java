package com.jiem.grocerystore.model;

public class Customer {
	
	@Override
	public String toString() {
		return "Customer [type=" + type + ", arrival_offset=" + arrival_offset + ", items=" + items
				+ ", processing_time=" + processing_time + "]";
	}
	private Type type;
	private int arrival_offset;
	private int items;
	private int processing_time;

	public int getProcessing_time() {
		return processing_time;
	}

	public void setProcessing_time(int processing_time) {
		this.processing_time = processing_time;
	}

	public Customer(Type type, int arrival_offset, int items) {
		super();
		this.type = type;
		this.arrival_offset = arrival_offset;
		this.items = items;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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
