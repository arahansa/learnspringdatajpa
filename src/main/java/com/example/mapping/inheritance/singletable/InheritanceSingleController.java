package com.example.mapping.inheritance.singletable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App;

@Controller
public class InheritanceSingleController {
	
	@Autowired AnimalRepository repoAnimal;
	
	@RequestMapping("/inheritanceSingle")
	public String animal(Model model){
		Bird bird = new Bird();
		bird.setName("파랑새");
		bird.setNameNest("희망봉");
		repoAnimal.save(bird);
		
		Lion lion = new Lion();
		lion.setName("심바");
		lion.setNameFood("품바");
		repoAnimal.save(lion);
		model.addAttribute("data", repoAnimal.findAll()
				+"<br><img src='/images/inheritancesingle.png'>"
				+"<br><img src='/images/inheritancesingle2.png'>"
				+"<br><img src='/images/inheritancesingle3.png'>"
				);
		return App.index;
	}

}
