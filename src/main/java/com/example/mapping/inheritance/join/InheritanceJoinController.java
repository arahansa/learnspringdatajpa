package com.example.mapping.inheritance.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App;


@Controller
public class InheritanceJoinController {
	@Autowired BaseBallPlayerRepository repository;
	
	@RequestMapping("/inheritanceJoin")
	public String inheri(Model model){
		HanWhaPlayer hanWhaPlayer = new HanWhaPlayer();
		hanWhaPlayer.setEaglesPower(400);
		hanWhaPlayer.setName("김태균");
		
		SkPlayer skPlayer = new SkPlayer();
		skPlayer.setIncheonPower(200);
		skPlayer.setName("최정");
		
		repository.save(hanWhaPlayer);
		repository.save(skPlayer);
		model.addAttribute("data", repository.findAll());
		return App.index;
	}

}
