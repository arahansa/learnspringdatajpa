package com.example.common;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.App;

@Controller
public class CommonBoardArticleController {

	@Autowired BoardArticleRepository repoBoard;
	@Autowired CommentRepository repoComment;
	@Autowired UserRepository repoUser;
	
	@RequestMapping(value="/commonBoard", method=RequestMethod.GET)
	public String commonBoardGet(Model model){
		model.addAttribute("data", repoBoard.findAll());
		return App.index;
	}
	
	@RequestMapping(value="/commonBoard", method=RequestMethod.POST)
	public String commonBoard(Model model, BoardArticle article, User user)
	{
		System.out.println(user);
		System.out.println(article);
		article.setUser(user);
		
		repoBoard.save(article);
		Hibernate.initialize(article);
		model.addAttribute("data", repoBoard.findAll());
		return App.index;
	}
	
	
	@RequestMapping(value="/commonBoard/{id}", method=RequestMethod.GET)
	public String commonBoardgetId(Model model, @PathVariable Long id)
	{
		BoardArticle findOne = repoBoard.findOne(id);
		model.addAttribute("data", findOne.toStringAll());
		return App.index;
	}
	
	@RequestMapping(value="/commonBoard/{articleid}",  method=RequestMethod.POST)
	public String command(Model model,BoardArticle article, Comment comment,  @PathVariable Long articleid){
		System.out.println(comment);
		comment.setArticle(new BoardArticle(articleid));
		System.out.println(comment);
		repoComment.save(comment);
		
		BoardArticle findOne = repoBoard.findOne(articleid);
		model.addAttribute("data", findOne.toStringAll());
		return App.index;
	}
	
	
	@RequestMapping("/user/{userid}")
	public String userGet (Model model, @PathVariable Long userid)
	{
		model.addAttribute("data", repoUser.findOne(userid));
		return App.index;
	}
	
}
