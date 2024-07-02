package restaurant_billing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant_billing_system.models.Login;
import restaurant_billing_system.models.User;
import restaurant_billing_system.persistance.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("homedisplay")
	public String homeDisplay(ModelMap map) {
		
		return "admin_display";
	}

	 @PostMapping("/login")
	    public String checkLogin(@ModelAttribute("loginBean") Login login, ModelMap map) {
	        System.out.println("Attempting login for email: " + login.getEmail());
	        User user = userRepo.getByLogin(login.getEmail(), login.getPassword());
	        if (user != null && user.getEmail() != null) {
	            System.out.println("User found: " + user.getEmail() + ", Role: " + user.getRole_name());
	            map.addAttribute("user", user);
	            if ("admin".equalsIgnoreCase(user.getRole_name())) {
	            	return "redirect:/homedisplay";
	            } else if ("user".equalsIgnoreCase(user.getRole_name())) {
	                return "user_display";
	            }
	        }
	        System.out.println("Invalid email or password");
	        map.addAttribute("error", "Invalid email or password");
	        return "login";
	    }
}
