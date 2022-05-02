package net.java.hms.dao;

import java.util.List;


import net.java.hms.model.Employee;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO extends DAO
{
	
	public List<Employee> getAllEmployee()
	{
		Query<Employee> query = getSession().createQuery("FROM Employee");
		List<Employee> list = query.list();
		return list;
	}
	
	public void save(Employee employee) 
	{
      try 
      {
         begin();
         getSession().save(employee);
         commit();
      } 
      catch (HibernateException e) 
      {
         rollback();
      }
}
	
	
	public void update(Employee employee) 
	{
      try 
      {
         begin();
         getSession().update(employee);
         commit();
      } 
      catch (HibernateException e) 
      {
         rollback();
      }
}
	public Employee getEmployeeById(long id) {
        Query query = getSession().createQuery("FROM Employee WHERE id = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();
    }

	
    public void deleteById(long id){
        Transaction txn = getSession().beginTransaction();
        Query query = getSession().createQuery("delete Employee where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();
        if (result > 0) {
            System.out.println(id + " products was removed");
        }
        txn.commit();
    }
    
    
}
