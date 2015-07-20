package com.example.r_mapping.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.App;

@Controller
public class OnetoManyController {
	@Autowired UniversityRepository repository;
	@RequestMapping("/onetomany")
	public String onetomanyinit(Model model) {
		//객체선언
		University university = new University();
		university.setId(1L);
		university.setName("arahansa");
		//students 설정후 저장
		List<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 15; i++){
			students.add(new Student("arahan"+i, "010-"+i, university));
		}
		university.setStudents(students);
		repository.save(university);
		//완료
		model.addAttribute("data", repository.getOne(1L).toStringPlusStudents()
				+"<br><img src='/images/onetomany.png'><br>"
				+"<br><img src='/images/onetomany2.png'><br>"
				+"<br><img src='/images/onetomany3.png'><br>"
				);
		return App.index;
	}
	
	@RequestMapping("/university")
	@ResponseBody
	public String university() {
		University getUniversity = repository.getOne(1L);
		return getUniversity.toString();
	}
	
	@RequestMapping("/univandstudents")
	@ResponseBody
	public String univandstudents() {
		University getUniversity = repository.getOne(1L);
		return getUniversity.toStringPlusStudents();
	}
	
}
