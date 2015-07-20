package com.example.r_mapping.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App;

@Controller
public class ManyToManyController {
	
	@Autowired BookRepository repoBook;
	@Autowired CategoryRepository repoCate;
	
	@RequestMapping("/manytomany")
	public String manytoMany(Model model){
		Book book  = new Book("MB's Cost");
		Book book1 = new Book("Queen. Park");
		Book book2 = new Book("Revenge of Yoo");
		Book book3 = new Book("Hitman");
		
		Category category = new Category();
		category.setName("Politics");
		category.getBooks().add(book);
		category.getBooks().add(book1);
		category.getBooks().add(book2);
		category.getBooks().add(book3);
		
		repoBook.save(book);
		repoBook.save(book1);
		repoBook.save(book2);
		repoBook.save(book3);
		repoCate.save(category);
		model.addAttribute("data", repoCate.getOne(1L)+"<br><img src='/images/manytomany.png'>"
				+"<br><img src='/images/manytomany2.png'>"
				+"<br><img src='/images/manytomany3.png'>"
				);
		return App.index;
	}

}
