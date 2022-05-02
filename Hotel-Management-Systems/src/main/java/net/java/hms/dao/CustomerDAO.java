package net.java.hms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import net.java.hms.model.Customer;
import net.java.hms.model.Employee;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO  extends DAO
{
	public List<Customer> getAllCustomer()
	{
		Query<Customer> query = getSession().createQuery("FROM Customer");
		List<Customer> list = query.list();
		return list;
	}
	
	public void save(Customer customer) 
	{
      try 
      {
         begin();
         getSession().save(customer);
         commit();
      } 
      catch (HibernateException e) 
      {
         rollback();
      }
	}
	
	public void update(Customer customer) 
	{
      try 
      {
         begin();
         getSession().update(customer);
         commit();
      } 
      catch (HibernateException e) 
      {
         rollback();
      }
}
	
	public Customer getCustomerById(long id) {
        Query query = getSession().createQuery("FROM Customer WHERE id = :id");
        query.setParameter("id", id);
        return (Customer) query.uniqueResult();
    }
	
    public void deleteById(long id){
        Transaction txn = getSession().beginTransaction();
        Query query = getSession().createQuery("delete Customer where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();
        if (result > 0) {
            System.out.println(id + " products was removed");
        }
        txn.commit();
    }
}
