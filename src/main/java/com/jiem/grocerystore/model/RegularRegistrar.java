package com.jiem.grocerystore.model;

import java.util.List;

public class RegularRegistrar implements Registrar{
	
	int final_offset;

	int time_taken_per_item ;
	
	 List<Customer> aryList = null;
	
	
	 public void addCustomer(Customer c) {
		 aryList.add(c);
	 }
	
	public void calculateTime() {
		// TODO Auto-generated method stub
		
	}

	public int processQueue() {
		
		int size;
		//aryList.remove(arg0)
		size = aryList.size();
		return size;
	}

 	public Customer queueLastCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
