package com.example.mapping.compoundkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.App;
import com.example.common.BoardArticle;
import com.example.common.BoardArticleRepository;

@Controller
public class CompoundKeyController {

	@Autowired PeopleManagementRepository repository;
	
	
	@RequestMapping("/compoundkey")
	public String compound(Model model){
		
		model.addAttribute("data", repository.findAll());
		return App.index;
	}
	
	@RequestMapping(value="/compoundkey", method=RequestMethod.POST)
	public String compoundkey(PeopleManagement management, Model model)
	{	
		System.out.println("흠 :"+management);
		repository.save(management);
		model.addAttribute("data", repository.findAll());
		return App.index;
	}
}
