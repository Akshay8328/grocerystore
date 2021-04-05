package com.jiem.grocerystore.service;

import java.util.List;
import java.util.Map;

import com.jiem.grocerystore.model.Customer;
import com.jiem.grocerystore.model.Register;
import com.jiem.grocerystore.model.Type;
import com.jiem.grocerystore.util.CustomerTypeComparator;
import com.jiem.grocerystore.util.GroceryHelper;

public class CustomerRouter {
	/**
	 * Routing of all the customer through the register
	 * @param customerMapWithOffset
	 * @param registerList
	 */
	public void  routeCustomer (Map<Integer, List<Customer>> customerMapWithOffset ,List<Register> registerList ) {
		
		// Retrive the each customer and process it
		customerMapWithOffset.forEach((offset,customerList)->{
			 // Process the register queue
			 for (Register register : registerList) {
				 register.processQueue(offset);
			}
			 // Sort the customer object as per type
			 customerList.sort(new CustomerTypeComparator());
			 
			 for (Customer customer : customerList) {
		            if (customer.getType().equals(Type.A)) {
		                Register shortestRegister = GroceryHelper.getRegisterbySize();
		                shortestRegister.addCustomer(customer);
		            //  System.out.println("Register: "+shortestRegister.getName()+" Customer: "+customer.toString());
		            } else {
		                Register registerwithleastItems = GroceryHelper.getRegisterbyItem(offset);
		                registerwithleastItems.addCustomer(customer);
		             //  System.out.println("Register: "+registerwithleastItems.getName()+" Customer: "+customer.toString());
		            }
		        }
			
		});		 
		
	}
	
	

}
