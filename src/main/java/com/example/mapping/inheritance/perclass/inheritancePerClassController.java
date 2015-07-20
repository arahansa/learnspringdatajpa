package com.example.mapping.inheritance.perclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.App;

@Controller
public class inheritancePerClassController {

	
	@Autowired ProjectRepository repoPro;
	
	@RequestMapping("/inheritancePerClass")
	public String inheritance(Model model)
	{
		
		Module module = new Module();
		module.setProjectName("inheritance project");
		module.setModuleName("inheritance module");
		
		PrivateProject privateProject = new PrivateProject();
		privateProject.setProjectManager("arahansa");
		privateProject.setProjectName("inheritance project");
		
		
		repoPro.save(module);
		repoPro.save(privateProject);
		model.addAttribute("data", repoPro.findAll());
		return App.index;
	}
	
}
