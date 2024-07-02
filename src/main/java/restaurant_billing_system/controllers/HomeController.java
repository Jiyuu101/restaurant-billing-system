package restaurant_billing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant_billing_system.models.Login;
import restaurant_billing_system.persistance.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepo;
	
    @RequestMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login", "loginBean", new Login());
    }
}
