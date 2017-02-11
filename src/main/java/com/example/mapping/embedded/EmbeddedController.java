package com.example.mapping.embedded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App;

@Controller
public class EmbeddedController {
	
	@Autowired
	HumanBodyRepository repository;
	
	@RequestMapping("/embedded")
	public String embedded(Model model)
	{
		Leg leg = new Leg();
		leg.setKneePowerLeft(100);
		leg.setKneePowerRight(200);

		Leg leg2 = new Leg();
		leg2.setKneePowerLeft(1001);
		leg2.setKneePowerRight(2002);
		
		
		HumanBody body = new HumanBody();
		body.setLeg1(leg);
		body.setLeg2(leg2);
		body.setOwnerName("arhanasa");
		repository.save(body);
		model.addAttribute("data", repository.findAll());
		
		return App.index;
	}

}
