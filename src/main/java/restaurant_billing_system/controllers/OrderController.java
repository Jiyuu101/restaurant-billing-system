package restaurant_billing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import restaurant_billing_system.persistance.OrderRepository;

@Controller
public class OrderController {
@Autowired
OrderRepository orderRepo;


}
