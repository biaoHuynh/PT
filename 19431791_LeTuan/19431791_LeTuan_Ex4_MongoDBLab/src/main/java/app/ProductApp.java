package app;

import java.util.Arrays;

import app.dao.ProductDAO;
import app.entity.Product;

public class ProductApp {
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		//Cau 1
//		 if(productDAO.addOneProduct(new Product(19431791L, "Dong Phong",
//		  "Quat", "Quat Gio", Arrays.asList("White", "black"), 2022, 150)))
//		  System.out.println("added"); else System.out.println("err");
		 

		//Cau 2
//		productDAO.addManyProduct(Arrays.asList(
//				new Product(19431792L, "Dong Phong", "Quat", "Quat Gio 1", Arrays.asList("White", "black"), 2022, 151),
//				new Product(19431793L, "Dong Phong", "Quat", "Quat Gio 2", Arrays.asList("White", "black"), 2022, 152)));
		
		//Cau 3
		//productDAO.updateOneProduct(19431792L, 155);
		
		//Cau 4:
		//productDAO.updateManyProduct("Quat", 2023);
		
		//Cau 5:
		Product product = new Product();
		product.setBrand("Truong Ha");
		productDAO.findOneUpdateProduct(19431791, product);
		
		//Cau 6:
		productDAO.getOrdersByCustomers().entrySet().forEach(en -> {
			System.out.println(en.getKey());
			System.out.println(en.getValue());
		});
	}
}
