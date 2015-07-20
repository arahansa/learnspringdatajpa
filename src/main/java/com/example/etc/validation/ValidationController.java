package com.example.etc.validation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.App;

@Controller
public class ValidationController {

	@RequestMapping(value="/validation", method=RequestMethod.POST)
	public String validation(Model model,@Valid DressOrder dressOrder, BindingResult result)
	{
		System.out.println(dressOrder);
		if (result.hasErrors()) {
			System.out.println("검증에러");
			return App.index;
		}
		
		return App.index;
	}
}
