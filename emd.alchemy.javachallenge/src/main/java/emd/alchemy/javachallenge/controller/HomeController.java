package emd.alchemy.javachallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import emd.alchemy.javachallenge.model.Message;
import emd.alchemy.javachallenge.repo.IMessageRepo;
import emd.alchemy.javachallenge.repo.IUserRepo;



@Controller
public class HomeController {
	
	@Autowired
	private IMessageRepo messageRepo;
	//@Autowired private IUserRepo userRepo;
	
	@GetMapping("/")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("msgs", messageRepo.findAll());
		//model.addAttribute("users", userRepo.findAll());
		return "userhome";
	}
	
	@PostMapping("/messages")
	public String saveMessage(Message message) {
		messageRepo.save(message);
		return "redirect:/home";
	}
}
