package com.capstone.percs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.percs.entities.Business;
import com.capstone.percs.entities.Promotion;
import com.capstone.percs.entities.PunchCard;
import com.capstone.percs.entities.User;
import com.capstone.percs.repository.BusinessRepo;
import com.capstone.percs.repository.PromotionRepo;
import com.capstone.percs.repository.PunchCardRepo;
import com.capstone.percs.repository.UserRepo;

@Controller
@RequestMapping(path = "percs") // This means URL's start with /percs (after Application path ie: localhost:8080) 
public class MainController {

	@Autowired // This means to get the bean called userRepo Which is auto-generated by Spring,
	// we will use it to handle the data
	private UserRepo userRepo;
	
	@Autowired
	private PunchCardRepo pcardRepo;

	@Autowired
	private BusinessRepo busRepo;
	
	@Autowired
	private PromotionRepo promoRepo;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "registerLogin";
	}
	
	@RequestMapping("/request-card")
	public String registerCard() {
		return "test";
	}
	
//	@PostMapping(path = "/add") // Map ONLY POST Requests
////	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
//	public String addNewUser(@RequestParam String userName, @RequestParam String email, @RequestParam String pass) {
//		User n = new User();
//		n.setUsername(userName);
//		n.setPassword(pass);
//		n.setEmail(email);
//		userRepo.save(n);
//
//		return "test";
//
//	}
	
	@PostMapping(path = "/card")
	public String userGetsNewPunchCard(@ModelAttribute("user") User user, @RequestParam String username, @RequestParam String busName, ModelMap model) {
		model.addAttribute("username", user.getUsername());
		model.getAttribute("username");

		User n = userRepo.findByUsername(username);
		Business bus = busRepo.findByBusName(busName);
		Promotion promo = promoRepo.findByBusId(bus.getId());
		PunchCard pcard = pcardRepo.findByUserId(n.getId());
		
		// This only builds a new punch card if the user does not have one already.
		if(pcard == null) {
		PunchCard pc = new PunchCard();
		pc.setUser(n);
		pc.setPromoId(promo.getId());
		pc.setPunch(promo.getStartImg());
		pc.setBusId(bus.getId());
		pcardRepo.save(pc);
		} else {
			return "test";
			
		}
		return "home";
		
	}

	
	
	
	
	
	
	
	
	/*
	 * ANYTHING BELOW THIS COMMENT IS TEST OR INCOMPLETE CODE!!!
	 */
	
	// the value = "/test" is how the action is called from the form but also will change the url. 
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String getData(@ModelAttribute("user") User user, ModelMap model) {
		model.addAttribute("username", user.getUsername());
		User u = userRepo.findByUsername((String) model.getAttribute("username"));
		System.out.println(u);
		model.addAttribute("email", u.getEmail().toString());

//		model.addAttribute("username", user.getUsername());
//		model.addAttribute("password", user.getPassword());
//		User user1 = userRepo.findByUsername(userName);

		return "test";
	}


//	@PostMapping(path="/add") // Map ONLY POST Requests
////	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
//	 public @ResponseBody String addNewUser (@RequestParam String userName, @RequestParam String email, @RequestParam String pass) {
////		System.out.println(userRepo.count());
//		User n = new User();
//		n.setId(1);
//	    n.setUsername(userName);
//	    n.setPassword(pass);
//	    n.setEmail(email);
////	    userRepo.save(n);
//	    return "Saved";
//	    
//	}
	
	
	

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepo.findAll();

	}

//	@GetMapping(path="/single")
//	public @ResponseBody List<User> getUser(long userId) {
//		// This returns a JSON or XML with the users
//		User user = new User();
//		user = userRepo.findById(userId).get(0);
//		System.out.println(user.getUsername());
//		return userRepo.findById(userId);
//	}
	@PostMapping(path = "/single")
	public @ResponseBody List<User> getUser(long userId, String userName) {
		// This returns a JSON or XML with the users
		// Could pass in a user as a param if needed.
//		User user = new User();
		User user = userRepo.findById(userId).get(0);
		User user1 = userRepo.findByUsername(userName);
		System.out.println(user.getUsername());
		System.out.println(user1.getId());
		return userRepo.findById(userId);
	}

}
