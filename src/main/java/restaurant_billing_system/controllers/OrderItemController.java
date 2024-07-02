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
import restaurant_billing_system.models.OrderItem;
import restaurant_billing_system.persistance.OrderItemRepository;

@Controller
public class OrderItemController {
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@RequestMapping("orderitems")
	public String displayAll(ModelMap map) {
		List<OrderItem> orderItems=orderItemRepo.getAll();
		
		map.addAttribute("orderItems",orderItems);
		return "user_order";
	}
	
	@GetMapping("addorderitem")
	public ModelAndView addOrderItem() {
		
		return new ModelAndView("add_user_order","orderItem",new OrderItem());
		
	}
	
	@PostMapping("addorderitem")
	public String addOrderItem(@ModelAttribute("orderItem")@Validated OrderItem orderItem,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "add_user_order";
		}else {
		int rs=orderItemRepo.add(orderItem);
		if(rs==0) {
			map.addAttribute("error_msg", "SQL Insert Error : ");
			return "add_user_order";
		}else {
			return "redirect:/orderitems";
			
		}
	}
	}
	
	@GetMapping("editorderitem/{id}")
	public ModelAndView editOrderItem(@PathVariable int id) {
		OrderItem orderItem=orderItemRepo.getById(id);
		return new ModelAndView("edit_user_order","orderItem",orderItem);
	}
	
	@PostMapping("editorderitem")
	public String editOrderItem(@ModelAttribute("orderItem")@Validated OrderItem orderItem,BindingResult bResult,ModelMap map) {
		
		if(bResult.hasErrors()) {
			return "edit_user_order";
		}
		int rs=orderItemRepo.edit(orderItem);
		if(rs==0) {
			map.addAttribute("error_msg","In Updating,Database something wrong");
			return "edit_user_order";
		}else {
			return "redirect:/orderitems";
		}
	}
	
	@GetMapping("deleteorderitem/{id}")
	public String deleteOrderItem(@PathVariable int id) {
		orderItemRepo.delete(id);
		return "redirect:/orderitems";
	}
}
