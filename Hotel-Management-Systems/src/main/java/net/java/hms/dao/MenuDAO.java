package net.java.hms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import net.java.hms.model.Employee;
import net.java.hms.model.Menu;

@Component
public class MenuDAO extends DAO
{
	public List<Menu> getAllMenu()
	{
		Query<Menu> query = getSession().createQuery("FROM Menu");
		List<Menu> list = query.list();
		return list;
	}
	
	public void save(Menu menu) 
	{
      try 
      {
         begin();
         getSession().save(menu);
         commit();
      } 
      catch (HibernateException e) 
      {
         rollback();
      }
	}
	
	public void update(Menu menu) 
	{
      try 
      {
         begin();
         getSession().update(menu);
         commit();
      } 
      catch (HibernateException e) 
      {
         rollback();
      }
}
	
	public Menu getMenuById(long id) {
        Query query = getSession().createQuery("FROM Menu WHERE id = :id");
        query.setParameter("id", id);
        return (Menu) query.uniqueResult();
    }
	
    public void deleteById(long id){
        Transaction txn = getSession().beginTransaction();
        Query query = getSession().createQuery("delete Menu where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();
        if (result > 0) {
            System.out.println(id + " products was removed");
        }
        txn.commit();
    }
}
