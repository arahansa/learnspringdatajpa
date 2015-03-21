package com.example.manytomany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.SampleController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleController.class)
@ActiveProfiles("test")
public class BookRepositoryTest {
	@Autowired BookRepository repoBook;
	@Autowired CategoryRepository repoCate;
	
	@Test
	public void testName() throws Exception {
		Book book  = new Book("MB의 비용");
		Book book1 = new Book("기획된");
		Book book2 = new Book("잡놈들");
		Book book3 = new Book("소탕하라");
		
		Category category = new Category();
		category.setName("정치비평에세이");
		category.getBooks().add(book);
		category.getBooks().add(book1);
		category.getBooks().add(book2);
		category.getBooks().add(book3);
		
		repoBook.save(book);
		repoBook.save(book1);
		repoBook.save(book2);
		repoBook.save(book3);
		repoCate.save(category);
	}

	

}
