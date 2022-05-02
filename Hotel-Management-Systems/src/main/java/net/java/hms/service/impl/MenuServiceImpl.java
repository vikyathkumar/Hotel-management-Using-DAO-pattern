package net.java.hms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.hms.dao.CustomerDAO;
import net.java.hms.model.Customer;
import net.java.hms.model.Employee;
import net.java.hms.model.Menu;
import net.java.hms.dao.MenuDAO;
import net.java.hms.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService
{
//	@Autowired
//	private MenuRepository menuRepository;
	
	@Autowired
	private MenuDAO menuDAO;
	
	
	@Override
	public List<Menu> getAllMenu() 
	{
		return menuDAO.getAllMenu();
	}


	@Override
	public void saveMenu(Menu menu)
	{
		this.menuDAO.save(menu);
		
	}
	
	@Override
	 public void updateMenu(Menu menu) 
	{
		menuDAO.update(menu);
	}

	@Override
    public void deleteMenuById(long id) 
	{
        menuDAO.deleteById(id);
    }




}
