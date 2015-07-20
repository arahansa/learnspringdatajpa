package com.example.mapping.secondary;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.App;
import com.example.mapping.secondary.SecondaryRepository;
import com.example.mapping.secondary.Secondarymaster;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=App.class)
@Transactional
public class SecondarymasterTest {

	@Autowired SecondaryRepository repository;
	
	@Before
	public void setup(){
		Secondarymaster master = new Secondarymaster();
		master.setSub1("hello");
		master.setSub2("world");
		
		repository.save(master);
	}
	
	@Test
	public void test()
	{
		Secondarymaster getMasters =repository.findBySub2("world");
		System.out.println("lazy loading?");
		System.out.println("master :"+getMasters.getSub2());
		
	}

}
