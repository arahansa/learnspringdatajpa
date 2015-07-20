package com.example.mapping.secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App;

@Controller
public class SecondaryController {

	@Autowired
	SecondaryRepository repository;

	@RequestMapping("/secondary")
	public String secondary(Model model)
	{
		Secondarymaster master = new Secondarymaster();
		master.setSub1("hello");
		master.setSub2("world");
		repository.save(master);
		model.addAttribute("data", "테이블이 두개로 되어있다 <br>"+repository.findAll()+
				"<br><img src='/images/secondary.png'><br>"+
				"<br><img src='/images/secondary2.png'><br>"+
				"<img src='/images/secondary3.png'><br>"
				);
		return App.index;
	}

}
