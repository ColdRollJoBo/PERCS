package com.capstone.percs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.percs.entities.User;
import com.capstone.percs.repository.UserRepo;

@Controller
@RequestMapping(path = "percs") // This means URL's start with /demo (after Application path)
public class LoginController {

	@Autowired // This means to get the bean called userRepo Which is auto-generated by Spring,
	// we will use it to handle the data
	private UserRepo userRepo;

	// This Method takes the user input in user name and then tries to find it in the data base. 
	// it finds that user and then checks the password making sure it matches and then login user. 
	@PostMapping(value = "/login")
	// The ModelAttribute "user" pertains to the class/bean called User.
	public String validateUserCredentials(@ModelAttribute("user") User user, ModelMap model, HttpSession session) {
		
		// This associates the attribute from the input 'name=username' in the jsp and must be the same name as the 
		// attribute in the the class/bean
		ModelMap userLogin = model.addAttribute("username", user.getUsername());
		// This associates the attribute from the input 'name=password' in the jsp and must be the same name as the 
		// attribute in the the class/bean
		ModelMap userPass = model.addAttribute("password", user.getPassword());
		
		String testUserName = userLogin.getAttribute("username").toString();
//		System.out.println(userPass);
		String testUserPassword = userPass.getAttribute("password").toString();
		
		// Getting the full User record here. Finding it by username
		User dbUser = userRepo.findByUsername((String) userLogin.getAttribute("username"));
		session.setAttribute("user", dbUser);
		
		if (testUserName.equals(dbUser.getUsername()) && testUserPassword.equals(dbUser.getPassword())) {
			return "/businesses";

		} else {
			return "/registerLogin";

		}
	}
	
	
	@PostMapping(path = "/registered") // Map ONLY POST Requests
//	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
	public String addNewUser(@ModelAttribute("user") User user, @RequestParam String userName, @RequestParam String email, @RequestParam String pass, HttpSession session) {
		User n = new User();
		n.setUsername(userName);
		n.setPassword(pass);
		n.setEmail(email);
		userRepo.save(n);
		
		session.setAttribute("username", n.getUsername());
		session.setAttribute("user", n);
		
		
		return "businesses";

	}

}
