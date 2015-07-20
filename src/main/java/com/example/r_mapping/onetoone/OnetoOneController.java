package com.example.r_mapping.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.App;

@Controller
public class OnetoOneController {
	@Autowired MemberRepository repository;	
	
	@RequestMapping("onetoone")
	public String member(Model model){
		Member member = new Member();
		member.setName("arahansa");	
		MemberDetail memberDetail = new MemberDetail();
		memberDetail.setAddress("incheon");
		member.setMemberDetail(memberDetail);
		repository.save(member);
		model.addAttribute("data", member.toString()
				+"<br><img src='/images/onetoone.png'>"
				+"<br><img src='/images/onetoone2.png'>"
				+"<br><img src='/images/onetoone3.png'>"
				);
		return App.index;
	}
}
