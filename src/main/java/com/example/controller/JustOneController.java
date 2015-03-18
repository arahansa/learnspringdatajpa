package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.JustOne;
import com.example.domain.JustOneEnum;
import com.example.repository.JustOneRepository;

@Controller
public class JustOneController {

	@Autowired JustOneRepository repository;
	
	@RequestMapping("one")
	String test(){
		JustOne one = new JustOne();
		one.setDateJoin(new Date());
		one.setEnumOne(JustOneEnum.ONE);
		one.setMessage("hello");
		one.setPasswordConfirm("1234");
		repository.save(one);
		return "test/test";
	}
}
