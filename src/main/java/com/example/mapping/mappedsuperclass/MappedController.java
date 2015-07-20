package com.example.mapping.mappedsuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.App;

@Controller
public class MappedController {
	
	@Autowired MappedSuperRepository repository;
	
	@RequestMapping("/mappedSuperclass")
	
	public String mapped(Model model){
		MappedSupper mappedSupper = new MappedSupper();
		mappedSupper.setName("arahanas");
		repository.save(mappedSupper);
		model.addAttribute("data", repository.findAll()+"<br><img src='/images/mappedsupper.png'><br>"
				+"<br><img src='/images/mappedsupper2.png'>"
				+"<br><img src='/images/mappedsupper3.png'><br>");
		return App.index;
	}

}
