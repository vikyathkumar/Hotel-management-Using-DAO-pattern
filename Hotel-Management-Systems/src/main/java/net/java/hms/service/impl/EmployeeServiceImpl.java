package net.java.hms.service.impl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.hms.dao.EmployeeDAO;
import net.java.hms.model.Employee;
//import net.java.hms.repository.EmployeeRepository;
import net.java.hms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
//	@Autowired
//	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getAllEmployees() 
	{
		return employeeDAO.getAllEmployee();
	}


	@Override
	public void saveEmployee(Employee employee)
	{
		this.employeeDAO.save(employee);
		
	}


	@Override
	 public void updateEmployee(Employee employee) 
	{
		employeeDAO.update(employee);
	}


	@Override
    public void deleteEmployeeById(long id) 
	{
        employeeDAO.deleteById(id);
    }
	
}
