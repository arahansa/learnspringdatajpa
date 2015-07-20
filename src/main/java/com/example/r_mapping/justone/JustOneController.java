package com.example.r_mapping.justone;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App;

@Controller
public class JustOneController {

	@Autowired JustOneRepository repository;
	
	@RequestMapping("one")
	public String test(Model model){
		JustOne one = new JustOne();
		one.setDateJoin(new Date());
		one.setEnumOne(JustOneEnum.ONE);
		one.setMessage("hello");
		one.setPasswordConfirm("1234");
		repository.save(one);
		
		model.addAttribute("data", repository.findAll()+"<br><img src='/images/justone.png'><br>");
		
		return App.index;
	}
}
