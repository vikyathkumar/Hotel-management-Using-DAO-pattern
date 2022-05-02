package net.java.hms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.java.hms.dao.EmployeeDAO;
import net.java.hms.dao.MenuDAO;
import net.java.hms.model.Employee;
import net.java.hms.model.Menu;
import net.java.hms.service.MenuService;

@Controller
public class MenuController 
{
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuDAO menuDAO;
	
	// Display List of Food
	@GetMapping("/menu")
	public String viewMenuPage(Model model)
	{
		model.addAttribute("listMenu", menuService.getAllMenu());
		return "menu";
	}
	
	
	@GetMapping("/showNewMenuForm")
    public String showNewMenuForm(Model model) {
        // create model attribute to bind form data
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        return "new_menu";
    }
	
	@PostMapping("/saveMenu")
    public String saveEmployee(@ModelAttribute("menu") Menu menu) {
        // save Menu to database
	  
	  if(menu.getId()==0) {
		  menuService.saveMenu(menu);
	  }
	  else {
		  menuService.updateMenu(menu);
	  }

        return "redirect:/menu";
    }
  @GetMapping("/showFormForMenuUpdate/{id}")
    public String showFormForMenuUpdate(@PathVariable(value = "id") long id, Model model) {

        // get menu from the service
        Menu menu = menuDAO.getMenuById(id);
//        employeeDAO.update(employee);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("menu", menu);
        return "update_menu";
    }
	@GetMapping("/deleteMenu/{id}")
    public String deleteMenu(@PathVariable(value = "id") long id) {

        // call delete Menu method 
        this.menuService.deleteMenuById(id);
        return "redirect:/menu";
    }
}