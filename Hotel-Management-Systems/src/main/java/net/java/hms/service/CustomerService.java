package net.java.hms.service;

import java.util.List;

import net.java.hms.model.Customer;

public interface CustomerService 
{
	List<Customer> getAllCustomer();
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomerById(long id);	
}
