package com.example.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.SampleController;
import com.example.domain.JustOne;
import com.example.domain.JustOneEnum;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleController.class)
@Transactional
public class JustOneRepositoryTest {

	private static final int numRequest = 10;
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
		//먼저 맨끝의 하나를 읽어보겠습니다. 읽어온 것의 메시지가 헬로월드가 맞는지 확인해보고
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
	
	
	@Test
	public void 페이징테스트() throws Exception {
		repository.deleteAll();
		//자 일단 40개 정도 저장을 해봅시다. 
		for (int i = 0; i < 40; i++) {
			JustOne one = new JustOne();
			one.setDateJoin(new Date());
			one.setEnumOne(JustOneEnum.TWO);
			one.setMessage(HELLO_WORLD+i);
			one.setPasswordConfirm(_1234);
			repository.save(one);
		}
		//PageRequest 에 시작페이지와 요청갯수를 넣어주고 repository에 넣어줍니다.
		Pageable pageable = new PageRequest(0, numRequest);
		Page<JustOne> ones =  repository.findAll(pageable);
		
		// 페이지 객체에서 받은 것에서 getContent 하시면 리스트가 뿅 나옵니다~_~
		//메시지를 잘 뽑아오는 지 테스트해보고~
		List<JustOne> onesList = ones.getContent();
		for (int i = 0; i < numRequest; i++) {
			assertEquals(onesList.get(i).getMessage(), HELLO_WORLD+i);
		}
		assertEquals(onesList.size(), numRequest);
		
		//역순으로 하고 싶으시다면?! 소트를 써봅시다.
		// 0개부터 39개까지 헬로월드 메시지를 넣었는데, id 역순으로 출력해서
		// 39부터 30까지 가져와보도록 하겠습니다. pagerequest끝에 sort객체를 넣어주면 됩니다.
		Sort sort = new Sort(Direction.DESC, "id");
		pageable = new PageRequest(0, 10, sort);
		ones =  repository.findAll(pageable);
		onesList = ones.getContent();
		for (int i = 39, j = 0; i >= 30 ; i--,j++) {
			assertEquals(onesList.get(j).getMessage(), HELLO_WORLD+i);
		}
	}
	
	@Test
	public void 특정메시지로_가져오기() throws Exception {
		JustOne one = repository.findByMessage(HELLO_WORLD);
		assertNotNull(one);
		assertEquals(one.getMessage(), HELLO_WORLD);
	}
	
	@Test
	public void 날짜이전_특정메시지로찾기() throws Exception {
		repository.deleteAll();
		/**주의 * 자바 날짜는 자바8, joda time 같은 걸로 해주는게 더 좋다고 합니다.
		 * 여기선 그냥 간단하게 java date 로 이미 가버렸습니다;; 삐질  */
		//먼저 데이터를 삽입하고
		Calendar calendar;	
		for(int i=0;i<10;i++){
			calendar = new GregorianCalendar(2010+i,1,1,13,24,56);
			JustOne one = new JustOne();
			one.setDateJoin(calendar.getTime());
			one.setMessage(i%2==0? HELLO_WORLD: _1234);
			repository.save(one);	
		}
		//기준 데이터를 가져와서 특정날짜이전과 해당 메시지에 해당하는 리스트를 뽑아봅니다.
		calendar = new GregorianCalendar(2015,1,1,13,24,56);
		List<JustOne> getList = 
		repository.findBydateJoinBeforeAndMessage(calendar.getTime(), HELLO_WORLD);
		//그리고 검사
		int year=2010;
		for (JustOne justOne : getList) {	
			calendar.set(year,1,1,13,24,56);
			assertEquals(justOne.getMessage(), HELLO_WORLD);
			assertEquals(justOne.getDateJoin(), calendar.getTime());
			year+=2;
		}
	}
	
	

}
