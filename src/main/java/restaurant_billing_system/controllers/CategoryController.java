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

import restaurant_billing_system.models.MenuItemType;
import restaurant_billing_system.persistance.MenuItemTypeRepository;

@Controller
public class CategoryController {
	
	@Autowired
	MenuItemTypeRepository menuItemTypeRepo;
	
	@RequestMapping("categories")
	public String displayAll(ModelMap map) {
		List<MenuItemType> menuItemTypes=menuItemTypeRepo.getAll();
		
		map.addAttribute("menuItemTypes",menuItemTypes);
		return "category";
	}
	
	@GetMapping("addcategory")
	public ModelAndView addCategory() {
		
		return new ModelAndView("add_category","menuItemType",new MenuItemType());
		
	}
	
	@PostMapping("addcategory")
	public String addCategory(@ModelAttribute("menuItemType")@Validated MenuItemType menuItemType,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "add_category";
		}else {
		int rs=menuItemTypeRepo.add(menuItemType);
		if(rs==0) {
			map.addAttribute("error_msg", "SQL Insert Error : Duplicate type not allowed.");
			return "add_category";
		}else {
			return "redirect:/categories";
			
		}
	}
	}
	
	@GetMapping("editcategory/{id}")
	public ModelAndView editCategory(@PathVariable int id) {
		MenuItemType menuItemType=menuItemTypeRepo.getById(id);
		return new ModelAndView("edit_category","menuItemType",menuItemType);
	}
	
	@PostMapping("editcategory")
	public String editCategory(@ModelAttribute("menuItemType")@Validated MenuItemType menuItemType,BindingResult bResult,ModelMap map) {
		
		if(bResult.hasErrors()) {
			return "edit_category";
		}
		int rs=menuItemTypeRepo.edit(menuItemType);
		if(rs==0) {
			map.addAttribute("error_msg","In Updating,Database something wrong");
			return "edit_category";
		}else {
			return "redirect:/categories";
		}
	}
	
	@GetMapping("deletecategory/{id}")
	public String deleteCategory(@PathVariable int id) {
		menuItemTypeRepo.delete(id);
		return "redirect:/categories";
	}
	
	
}
