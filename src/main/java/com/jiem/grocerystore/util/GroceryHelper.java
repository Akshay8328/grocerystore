package com.jiem.grocerystore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jiem.grocerystore.model.Customer;
import com.jiem.grocerystore.model.Register;
import com.jiem.grocerystore.model.Type;

public class GroceryHelper {
	private static Map<Integer, List<Customer>> customerMapWithOffset = new LinkedHashMap<Integer, List<Customer>>();
	private static List<Register> registerList = new ArrayList<Register>();

	public static Map<Integer, List<Customer>> getCustomerMapWithOffset() {
		return customerMapWithOffset;
	}

	public static void setCustomerMapWithOffset(Map<Integer, List<Customer>> customerMapWithOffset) {
		GroceryHelper.customerMapWithOffset = customerMapWithOffset;
	}

	public static List<Register> getRegisterList() {
		return registerList;
	}

	public static void setRegisterList(List<Register> registerList) {
		GroceryHelper.registerList = registerList;
	}

	/**
	 * Created the register list with register objects
	 * 
	 * @param noofRegistar
	 */
	public static void createRegisterList(int noofRegistar) {

		Register traineeRegister = new Register();
		traineeRegister.setFinal_offset(0);
		traineeRegister.setTime_taken_per_item(2);
		traineeRegister.setAryList(new ArrayList<Customer>());
		traineeRegister.setName("traineeRegister");
		noofRegistar--;

		for (int j = 0; j < noofRegistar; j++) {
			Register regularRegister = new Register();
			regularRegister.setFinal_offset(0);
			regularRegister.setTime_taken_per_item(1);
			regularRegister.setAryList(new ArrayList<Customer>());
			regularRegister.setName("regularRegister_" + j);
			registerList.add(regularRegister);

		}
		registerList.add(traineeRegister);

	}

	/**
	 * Create the customer object and add in the list
	 * 
	 * @param line
	 */
	public static void createCustmerList(String line) {

		String[] items = line.split(" ");
		if (items.length != 3) {
			System.out.println("Error in Input-->" + line);
			// abnormal termination
			System.exit(-1);
		}

		Customer customer = new Customer(items[0].equals(Type.A.toString()) ? Type.A : Type.B,
				Integer.parseInt(items[1]), Integer.parseInt(items[2]));

		int offset = Integer.valueOf(items[1]);
		List<Customer> customerList = customerMapWithOffset.get(offset);

		if (customerList == null) {
			customerList = new ArrayList<Customer>();
		}
		customerList.add(customer);
		customerMapWithOffset.put(offset, customerList);

	}

	/**
	 * Read the Input file and create the register and customer object map with
	 * arrival offset
	 * 
	 * @param fileName
	 */
	public static void readFile(String fileName) {

		try {

			File file = new File(fileName); // creates a new file instance
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				if (i == 0) {
					GroceryHelper.createRegisterList(Integer.valueOf(line));
					i++;
					continue;
				}
				GroceryHelper.createCustmerList(line);
			}

		} catch (Exception e) {

		}

	}

	/**
	 * Return the register which is having less customer objects
	 * 
	 * @return
	 */
	public static Register getRegisterbySize() {

		Register register = null;
		for (Register r : registerList) {
			if (register == null) {
				register = r;
				continue;
			}

			if (r.getAryList().size() < register.getAryList().size()) {
				register = r;
			}

		}
		return register;
	}

	/**
	 * Return the register which is having less items in last customer
	 * 
	 * @return
	 */
	public static Register getRegisterbyItem( int offset) {

		Register register = null;
		int min_offset = 0;
		for (Register r : registerList) {
			if (register == null) {
				register = r;
				continue;
			}
		
			if (register.getAryList().size() == 0) {
				return register;
			}
			
					min_offset = (r.getFinal_offset()-offset) / r.getTime_taken_per_item();
		
			if (r.getAryList().size() == 0
					|| r.queueLastCustomer().getItems() < min_offset) {
				register = r;
			}

		}
		return register;
	}
}
