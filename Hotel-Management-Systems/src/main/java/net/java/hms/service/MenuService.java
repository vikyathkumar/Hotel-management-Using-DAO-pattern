package net.java.hms.service;

import java.util.List;

import net.java.hms.model.Menu;

public interface MenuService 
{
	
	List<Menu> getAllMenu();
	void saveMenu(Menu menu);
	void updateMenu(Menu menu);
	void deleteMenuById(long id);
}
