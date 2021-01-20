package com.john.Language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.john.Language.models.Lang;
import com.john.Language.services.LangService;


@Controller
public class LangController {
	
	private final LangService langService;
	
	public LangController(LangService langService) {
        this.langService = langService;
   }
    
    @RequestMapping("/languages")
   public String index(@ModelAttribute("language") Lang language, Model model) {
        List<Lang> languages = langService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/lang.jsp";
    }
    
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Lang language, BindingResult result) {
        if (result.hasErrors()) {
            return "/language/error.jsp";
        } else {
            langService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}")
    public String showLanguage(@PathVariable("id") Long id, Model model) {
    	Lang language = langService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "/languages/show.jsp";
    }
    
    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
    	Lang language = langService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/edit/{id}", method=RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
        langService.updateLanguage(id, name, creator, currentVersion);
        return "redirect:/languages";
    }
    
    @RequestMapping(value="/languages/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        langService.deleteLanguage(id);
        return "redirect:/languages";
    }
	
}
