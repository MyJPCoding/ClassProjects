package com.john.dojo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.john.dojo.models.Dojo;
import com.john.dojo.services.DojoService;
import com.john.dojo.services.NinjaService;

@Controller
public class MainController {
	
private final DojoService dojoServ;
	
	private final NinjaService ninjaServ;
	
	public MainController(NinjaService ninjaServ, DojoService dojoServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}

}
