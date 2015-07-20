package com.example.query.jpql;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.catalina.util.SessionConfig;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App;
import com.example.common.BoardArticle;
import com.example.common.BoardArticleRepository;

@Controller
public class JPQLController {

	private static final String JPQL = "from BoardArticle";

	@Autowired
	EntityManager em;
	
	@Autowired
	SessionFactory sessionFactory; 
	
	@Autowired BoardArticleRepository repository;
	
	@RequestMapping("/jpql")
	public String jpql(Model model){
		BoardArticle article = new BoardArticle("arahansa", "hello world", "content");
		repository.save(article);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(JPQL);
		List<BoardArticle> listArticles = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		model.addAttribute("data", listArticles);
		
		return App.index;
	}
	
	
}
