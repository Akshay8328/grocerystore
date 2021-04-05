package com.jiem.grocerystore.util;

import java.util.Comparator;

import com.jiem.grocerystore.model.Customer;



public class CustomerTypeComparator implements Comparator<Customer> {

	/**
	 * Sort the customer if arrival time is same 
	 */
	public int compare(Customer o1, Customer o2) {
	
		String  custType1 = o1.getType().toString();
	       String custType2 = o2.getType().toString();
	       return custType1.compareTo(custType2);
	   
	}

}
