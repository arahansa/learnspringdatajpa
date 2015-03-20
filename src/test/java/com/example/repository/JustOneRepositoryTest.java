package com.example.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.SampleController;
import com.example.domain.JustOne;
import com.example.domain.JustOneEnum;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleController.class)
@Transactional
public class JustOneRepositoryTest {

	private static final String _1234 = "1234";
	private static final String HELLO_WORLD = "hello world";
	
	@Autowired JustOneRepository repository;
	
	@Before
	public void setUp() throws Exception {
		//Justone객체를 하나 만들고 save 로 저장합니다. 
		//asserteq 에서  총 개수가 1이란 것을 확인해봅니다.
		JustOne one = new JustOne();
		one.setDateJoin(new Date());
		one.setEnumOne(JustOneEnum.TWO);
		one.setMessage(HELLO_WORLD);
		one.setPasswordConfirm(_1234);
		repository.save(one);
		assertEquals(repository.count(), 1);
	}
	
	@Test
	public void 읽고난뒤수정() throws Exception {
		//먼저 하나를 읽어보겠습니다. 읽어온 것의 메시지가 헬로월드가 맞는지 확인해보고
		List<JustOne> ones = repository.findAll();
		JustOne one = ones.get(ones.size()-1);
		assertEquals(one.getMessage(), HELLO_WORLD);
		//메시지를 수정한 뒤에 저장후, 다시 받아와서 문자열이 변했는지를 확인해봅니다.
		one.setMessage("ni3hao3");
		repository.save(one);
		JustOne getOne = repository.getOne(one.getId());
		assertEquals(getOne.getMessage(), one.getMessage());
	}
	
	
	@Test
	public void 삭제() throws Exception {
		//repository.deleteAll 로 모두 지우고서 count를 0 확인해봅니다.
		repository.deleteAll();
		assertEquals(repository.count(), 0);
	}
	
	

}
