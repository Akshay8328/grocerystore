package com.jiem.grocerystore.model;

import java.util.ArrayList;
import java.util.List;

public class Register { 

	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	int final_offset;

	int time_taken_per_item ;
	
	private List<Customer> aryList = null;
	 
	public int getFinal_offset() {
		return final_offset;
	}

	public void setFinal_offset(int final_offset) {
		this.final_offset = final_offset;
	}

	public int getTime_taken_per_item() {
		return time_taken_per_item;
	}

	public void setTime_taken_per_item(int time_taken_per_item) {
		this.time_taken_per_item = time_taken_per_item;
	}

	public List<Customer> getAryList() {
		return aryList;
	}

	public void setAryList(List<Customer> aryList) {
		this.aryList = aryList;
	}

	 public void addCustomer(Customer c) {
		 if(final_offset<c.getArrival_offset()) {
			 final_offset= c.getArrival_offset();
		 }
		 c.setProcessing_time(final_offset+time_taken_per_item*c.getItems());
		 final_offset= final_offset+time_taken_per_item*c.getItems();
		 aryList.add(c);
	 }

	 // Remove the customer object who processing is done.
	public void processQueue(int currentOffset) {
		ArrayList<Customer> customerList = new ArrayList();
	for (Customer customer : aryList) {
		if(currentOffset>=customer.getProcessing_time()) {
			customerList.add(customer);
		}
	}
	
	for (Customer customer :  customerList) {
		aryList.remove(customer);
	}
	
	
}
	public Customer queueLastCustomer() {
		return aryList.get(aryList.size()-1);
	}

	 

 
}
