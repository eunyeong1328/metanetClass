package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		
	}
	
	@GetMapping("/member")
	public void doMember() {
		
	}

	@GetMapping("/admin")
	public void doAdamin() {
		
	}
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		model.addAttribute("msg","Access Denied");
	}



}
