package com.jiem.grocerystore;

import com.jiem.grocerystore.model.Register;
import com.jiem.grocerystore.service.CustomerRouter;
import com.jiem.grocerystore.util.GroceryHelper;

public class GroceryMain {

	public static void main(String[] args) {

		String fileListArray[] = { "testingA.txt", "testingB.txt", "testingC.txt", "testingD.txt", "testingE.txt",
				"testingF.txt", "testingG.txt", "testingH.txt", "testingI.txt", "testingJ.txt", "testingK.txt" };

		for (int i = 0; i < fileListArray.length; i++) {

			GroceryHelper.readFile(fileListArray[i]);

			CustomerRouter customerRouter = new CustomerRouter();
			customerRouter.routeCustomer(GroceryHelper.getCustomerMapWithOffset(), GroceryHelper.getRegisterList());
			int finalSimulationTime = 0;
			for (Register r : GroceryHelper.getRegisterList()) {
				// System.out.println(" Register wise offset : " + r.getFinal_offset());

				if (r.getFinal_offset() > finalSimulationTime) {
					finalSimulationTime = r.getFinal_offset();
				}
			}
			System.out.println("Final offset " + fileListArray[i] + " : " + finalSimulationTime);
			GroceryHelper.getCustomerMapWithOffset().clear();
			GroceryHelper.getRegisterList().clear();
		}
	}

}
