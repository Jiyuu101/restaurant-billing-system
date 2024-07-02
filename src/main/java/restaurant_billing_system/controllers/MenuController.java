package restaurant_billing_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import restaurant_billing_system.models.MenuItem;
import restaurant_billing_system.models.MenuItemType;
import restaurant_billing_system.persistance.MenuItemRepository;
import restaurant_billing_system.persistance.MenuItemTypeRepository;

@Controller
public class MenuController {

	@Autowired
	MenuItemRepository menuItemRepo;
	
	@Autowired
	MenuItemTypeRepository menuItemTypeRepo;
	
	@RequestMapping("menus")
	public String displayAll(ModelMap map) {
		List<MenuItem> menuItems=menuItemRepo.getAll();
		
		map.addAttribute("menuItems",menuItems);
		return "menu";
	}
	
	@GetMapping("addmenu")
	public ModelAndView addMenu(ModelMap map) {
		
		List<MenuItemType> menuItemTypes=menuItemTypeRepo.getAll();
		map.addAttribute("selected_categories",menuItemTypes);
		return new ModelAndView("add_menu","menuItem",new MenuItem());
		
	}
	
	@PostMapping("addmenu")
	public String addMenu(@ModelAttribute("menuItem")@Validated MenuItem menuItem,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			map.addAttribute("selected_categories",menuItemTypeRepo.getAll());
			return "add_menu";
		}else {
		int rs=menuItemRepo.add(menuItem);
		if(rs==0) {
			map.addAttribute("menuItem",menuItem);
			map.addAttribute("error_msg", "SQL Insert Error : ");
			map.addAttribute("selected_categories",menuItemTypeRepo.getAll());
			return "add_menu";
		}else {
			return "redirect:/menus";
			
		}
	}
	}
	
	@GetMapping("editmenu/{id}")
	public ModelAndView editMenu(@PathVariable int id) {
		MenuItem menuItem=menuItemRepo.getById(id);
		return new ModelAndView("edit_menu","menuItem",menuItem);
	}
	
	@PostMapping("editmenu")
	public String editMenu(@ModelAttribute("menuItem")@Validated MenuItem menuItem,BindingResult bResult,ModelMap map) {
		
		if(bResult.hasErrors()) {
			return "edit_menu";
		}
		int rs=menuItemRepo.edit(menuItem);
		if(rs==0) {
			map.addAttribute("error_msg","In Updating,Database something wrong");
			return "edit_menu";
		}else {
			return "redirect:/menus";
		}
	}
	
	@GetMapping("deletemenu/{id}")
	public String deleteMenu(@PathVariable int id) {
		menuItemRepo.delete(id);
		return "redirect:/menus";
	}
}
