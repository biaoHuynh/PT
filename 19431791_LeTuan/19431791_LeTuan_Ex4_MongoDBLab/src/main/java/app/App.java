package app;

import java.util.Arrays;
import java.util.Date;

import app.dao.CustomerDAO;
import app.entity.Address;
import app.entity.Customer;
import app.entity.Phone;

public class App {
	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer("19431791", "Tuấn", "Lê", "letuan19431791.iuh@gmail.com", new Date(),
				new Address("HCMC", "Gò Vấp", "Quang Trung", 700000),
				Arrays.asList(new Phone("Personal", "0343221234")));
		
//		boolean isCustomerAdded = customerDAO.addCustomer(customer);
//		if (isCustomerAdded)
//			System.out.println("Thêm khách hàng thành công!");

		boolean isPhoneAdded = customerDAO.addNewPhone2Customer(customer.getCustomerId(),
				new Phone("company", "01653220597"));
		if (isPhoneAdded)
			System.out.println("Thêm số điện thoại thành công!");
		else
			System.out.println("Thêm số điện thoại thất bại!");
	}
}
