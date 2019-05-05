package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String welcome() {
		return "dashboard";
	}
	
	@RequestMapping("/basicMission.html")
	public String basicMission() {
		return "basicMission";
	}
	
	@RequestMapping("/advancedMission.html")
	public String advancedMission() {
		return "advancedMission";
	}
	
	@RequestMapping("/basicMissionDetail.html")
	public String basicMissionDetail() {
		return "basicMissionDetail";
	}
	
	@RequestMapping("/changePassword.html")
	public String changePassword() {
		return "changePassword";
	}
	
	@RequestMapping("/forgotPassword.html")
	public String forgotPassword() {
		return "forgotPassword";
	}
	
	@RequestMapping("/home.html")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login.html")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register.html")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/userProfile.html")
	public String userProfile() {
		return "userProfile";
	}
}
