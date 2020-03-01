package com.capstone.percs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.percs.entities.Promotion;
import com.capstone.percs.entities.PunchCard;
import com.capstone.percs.entities.User;
import com.capstone.percs.repository.BusinessRepo;
import com.capstone.percs.repository.PromotionRepo;
import com.capstone.percs.repository.PunchCardRepo;
import com.capstone.percs.repository.UserRepo;

@Controller
@RequestMapping(path = "percs") // This means URL's start with /demo (after Application path)
public class PunchCardController {

	@Autowired // This means to get the bean called pcardRepo Which is auto-generated by Spring,
	// we will use it to handle the data
	private PunchCardRepo pcardRepo;

	@Autowired
	private PromotionRepo promoRepo;

	@Autowired
	private BusinessRepo busRepo;
	
	@Autowired
	private UserRepo userRepo;
	

	@RequestMapping(value = "/topdog")
	public String getPunchcard(@ModelAttribute("punchcard") PunchCard pcard, ModelMap model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		
		// Finding the business and then finding their promotion.
		long busId = busRepo.findByBusName("JoesTopDog").getId();
		Promotion busPromo = promoRepo.findByBusId(busId);
		
		// TODO: find the user based on the session or pass it along as a parameter for
		// now.
//		pcard = pcardRepo.findByUserId(user.getId());
//		pcard = pcardRepo.findByUserId(1);
		
		if (pcardRepo.findByUserId(user.getId()) == null) {
			System.out.println("HERE!!!");
			System.out.println(user.getId());
			
		}
		
		if (pcard.getPunch() == null) {
			// When a user selects the business for the first time a new card is set at zero
			// punches.
			String newCardImage = busPromo.getStartImg();
			pcard.setPunch(newCardImage);
			// TODO Set the user id in punch card table by using the session user id.
			pcardRepo.save(pcard);
			ModelMap currentPunch = model.addAttribute("punchcard", pcard.getPunch());
		} else {
			// This is building the EL Tag as well as setting the value to the Punchcard Class/Bean (I Think)
			ModelMap currentPunch = model.addAttribute("punchcard", pcard.getPunch());
		}
		
		return "punchcard";
	}
	
	@RequestMapping(value = "/punch")
	public String addPunchToCard(@ModelAttribute("punchcard") PunchCard pcard, ModelMap model) {
		// TODO: pass the business name somehow so this can be used for multiple businesses.
		// Finding the business and then finding their promotion.
		long busId = busRepo.findByBusName("JoesTopDog").getId();
		
		Promotion busPromo = promoRepo.findByBusId(busId);

		// Finding the Users punch-card.
		pcard = pcardRepo.findByUserId(1);

		String currentPunch = pcard.getPunch();
		System.out.println(currentPunch);
		System.out.println(busPromo);

		if (currentPunch != null) {

			switch (currentPunch) {
			case "/img/punchcards/JoesTopDog/TD-Punch-0.png":
				String punch1 = busPromo.getpImg1();
				pcard.setPunch(punch1);
				break;

			case "/img/punchcards/JoesTopDog/TD-Punch-1.png":
				String punch2 = busPromo.getpImg2();
				pcard.setPunch(punch2);
				break;

			case "/img/punchcards/JoesTopDog/TD-Punch-2.png":
				String punch3 = busPromo.getpImg3();
				pcard.setPunch(punch3);
				break;

			default:
				break;
			}
		}

		model.addAttribute("punchcard", pcard.getPunch());
		pcardRepo.save(pcard);

		return "punchcard";

	}
}
