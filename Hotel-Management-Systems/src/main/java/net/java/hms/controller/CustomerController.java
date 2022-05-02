package net.java.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.java.hms.dao.CustomerDAO;
import net.java.hms.dao.EmployeeDAO;
import net.java.hms.model.Customer;
import net.java.hms.model.Employee;
import net.java.hms.service.CustomerService;


@Controller
public class CustomerController
{
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/home")
	public String HomePage(Model model)
	{
		return "home";
	}
	
	@GetMapping("/customer")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listCustomer", customerService.getAllCustomer());
		return "customer";
	}
	
	@GetMapping("/showNewCustomerForm")
    public String showNewcustomerForm(Model model) {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }
	
	@PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // save customer to database
	  
	  if(customer.getId()==0) {
		  customerService.saveCustomer(customer);
	  }
	  else {
		  System.out.print(customer.getFirstName());
		  customerService.updateCustomer(customer);
	  }

        return "redirect:/customer";
    }
	
	 @GetMapping("/showFormForCustomerUpdate/{id}")
	    public String showFormForCustomerUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get customer from the service
	        Customer customer = customerDAO.getCustomerById(id);
//	        employeeDAO.update(customer);

	        // set customer as a model attribute to pre-populate the form
	        model.addAttribute("customer", customer);
	        return "update_customer";
	    }
	  
	  @GetMapping("/deleteCustomer/{id}")
	    public String deleteCustomer(@PathVariable(value = "id") long id) {

	        // call delete customer method 
	        this.customerService.deleteCustomerById(id);
	        return "redirect:/customer";
	    }
}
