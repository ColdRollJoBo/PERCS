package com.capstone.percs.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.percs.entities.Business;
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

	@Autowired // This means to get the bean called pcardRepo Which is auto-generated by Spring, we will use it to handle the data
	private PunchCardRepo pcardRepo;

	@Autowired
	private PromotionRepo promoRepo;

	@Autowired
	private BusinessRepo busRepo;

	@Autowired
	private UserRepo userRepo;

	// TODO: Refactor code so that we can use the methods below for multiple
	// businesses.

	@RequestMapping(value = "/topdog")
	public String getPunchcard(@ModelAttribute("punchcard") PunchCard pcard, ModelMap model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		model.addAttribute("username", user.getUsername());

		// Finding the business and then finding their promotion.
		long busId = busRepo.findByBusName("JoesTopDog").getId();
		Promotion busPromo = promoRepo.findByBusId(busId);

		Business bus = busRepo.findByBusName("JoesTopDog");
		session.setAttribute("business", bus);

		// If a card does not exist in the pcardRepo with a userID then a new card is
		// created. Else it just
		// displays the current amount of punches.
		if (pcardRepo.findByUserId(user.getId()) == null) {
			// When a user selects the business for the first time a new card is set at zero
			// punches.
			String newCardImage = busPromo.getStartImg();
			pcard.setUser(user);
			pcard.setBusId(busId);
			pcard.setPunch(newCardImage);
			pcard.setPromoId(busPromo.getId());
			pcardRepo.save(pcard);
			model.addAttribute("punchcard", pcard.getPunch());
		} else {
			// This is building the EL Tag as well as setting the value to the Punchcard
			// Class/Bean (I Think)
			model.addAttribute("punchcard", pcardRepo.findByUserId(user.getId()).getPunch());
		}


		// TEST CODE
		model.addAttribute("redeem", "disabled");
		System.out.println(model.getAttribute("punchcard"));
		System.out.println(model.getAttribute("redeem"));

		if (model.getAttribute("punchcard").equals("/img/punchcards/JoesTopDog/TD-Punch-7.png")) {
			model.replace("redeem", "enable");
		}

		session.setAttribute("redeem", model.getAttribute("redeem"));
		// END OF TEST CODE

		System.out.println(model.getAttribute("redeem"));
		return "biz-joestopdog";
	}

	@RequestMapping(value = "/punch")
	public String addPunchToCard(@ModelAttribute("punchcard") PunchCard pcard, @RequestParam String punchPassword,
			ModelMap model, HttpSession session) {

		System.out.println(session.getAttribute("redeem"));

		User user = (User) session.getAttribute("user");
		model.addAttribute("username", user.getUsername());
		// Getting the session that was created when the getPunchcard method was
		// invoked. (Method above)
		Business bus = (Business) session.getAttribute("business");

		long busId = busRepo.findByBusName("JoesTopDog").getId();

		Promotion busPromo = promoRepo.findByBusId(busId);

		// Finding the Users punch-card.
		pcard = pcardRepo.findByUserId(user.getId());

		String currentPunch = pcard.getPunch();

		model.addAttribute("punchPassword", punchPassword);
		String authCode = model.getAttribute("punchPassword").toString();
		System.out.println(authCode);

		if (currentPunch != null && bus.getPunchPassword().equals(authCode)) {

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

			case "/img/punchcards/JoesTopDog/TD-Punch-3.png":
				String punch4 = busPromo.getpImg4();
				pcard.setPunch(punch4);
				break;

			case "/img/punchcards/JoesTopDog/TD-Punch-4.png":
				String punch5 = busPromo.getpImg5();
				pcard.setPunch(punch5);
				break;

			case "/img/punchcards/JoesTopDog/TD-Punch-5.png":
				String punch6 = busPromo.getpImg6();
				pcard.setPunch(punch6);
				break;

			case "/img/punchcards/JoesTopDog/TD-Punch-6.png":
				String punch7 = busPromo.getpImg7();
				pcard.setPunch(punch7);
				break;

			default:
				break;
			}
		}

		model.addAttribute("punchcard", pcard.getPunch());
		pcardRepo.save(pcard);

		return "biz-joestopdog";

	}

	@RequestMapping(value = "/reset-punch")
	public String ResetPunchCard(@ModelAttribute("punchcard") PunchCard pcard, ModelMap model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		model.addAttribute("username", user.getUsername());

		// Finding the business and then finding their promotion.
		long busId = busRepo.findByBusName("JoesTopDog").getId();
		Promotion busPromo = promoRepo.findByBusId(busId);
		
		
		
		
		PunchCard p = pcardRepo.findByUserId(user.getId());
		p.setPunch(busPromo.getStartImg());
		model.addAttribute("punchcard", p.getPunch());
		pcardRepo.save(p);
		System.out.println(pcard);
		System.out.println(p);
		
		System.out.println("HERE!!!");

		return "biz-joestopdog";
	}

}
