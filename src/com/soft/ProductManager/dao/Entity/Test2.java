package com.soft.ProductManager.dao.Entity;

import com.soft.ProductManager.service.PoductServices;
import com.soft.ProductManager.service.ProductServicesImp;







public class Test2 {
	private static PoductServices productServices = new ProductServicesImp();
	public static void main(String[] args) {

		productServices.findAll();
	
	}

}
