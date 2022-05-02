package net.java.hms.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.hms.model.Customer;
import net.java.hms.model.Employee;
import net.java.hms.service.CustomerService;
import net.java.hms.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService
{
//	@Autowired
//	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	public List<Customer> getAllCustomer() 
	{
		return customerDAO.getAllCustomer();
	}


	@Override
	public void saveCustomer(Customer customer)
	{
		this.customerDAO.save(customer);
		
	}
	
	@Override
	 public void updateCustomer(Customer customer) 
	{
		customerDAO.update(customer);
	}

	@Override
    public void deleteCustomerById(long id) 
	{
        customerDAO.deleteById(id);
    }

}
