package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String welcome() {
		return "home";
	}
	
	@RequestMapping("/basicMission")
	public String basicMission() {
		return "basicMission";
	}
	
	@RequestMapping("/advancedMission")
	public String advancedMission() {
		return "advancedMission";
	}
	
	@RequestMapping("/basicMissionDetail")
	public String basicMissionDetail() {
		return "basicMissionDetail";
	}
	
	@RequestMapping("/changePassword")
	public String changePassword() {
		return "changePassword";
	}
	
	@RequestMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgotPassword";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/userProfile")
	public String userProfile() {
		return "userProfile";
	}
}
