package com.john.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.john.dojo.models.Dojo;
import com.john.dojo.models.Ninja;
import com.john.dojo.services.DojoService;
import com.john.dojo.services.NinjaService;

@Controller
public class NinjaController {
	
	private final DojoService dojoServ;
	
	private final NinjaService ninjaServ;
	
	public NinjaController(NinjaService ninjaServ, DojoService dojoServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	
	@RequestMapping("/ninjas/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninjas/newNinja.jsp";		
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/ninjas/new";
		} else {
			ninjaServ.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}

}
