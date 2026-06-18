package com.sts.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sts.demo.dto.SignupFormDto;
import com.sts.demo.service.AppUserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	private AppUserService appUserService;

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping("/signup")
	public String signupForm(Model model) {
		model.addAttribute("signupForm", new SignupFormDto());
		return "auth/signup";
	}

	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("signupForm") SignupFormDto signupForm, BindingResult bindingResult) {
		if (!signupForm.getPassword().equals(signupForm.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword", "match", "Passwords do not match");
		}
		if (appUserService.existsByEmail(signupForm.getEmail().trim().toLowerCase())) {
			bindingResult.rejectValue("email", "exists", "Email is already registered");
		}
		if (bindingResult.hasErrors()) {
			return "auth/signup";
		}

		appUserService.register(signupForm);
		return "redirect:/login?registered";
	}
}
