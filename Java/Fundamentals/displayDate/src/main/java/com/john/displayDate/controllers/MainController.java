package com.john.displayDate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		DateFormat dateoption = new SimpleDateFormat("EEEE, 'the' d 'of' MMMMM, yyyy");
		Date date = new Date();
		model.addAttribute("date", dateoption.format(date));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		DateFormat timeoption = new SimpleDateFormat("HH:MM a");
		Date time = new Date();
		model.addAttribute("time", timeoption.format(time));
		return "time.jsp";
	}

}
