package com.example.onetoone;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.SampleController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleController.class)
@Transactional
public class MemberRepositoryTest {

	@Autowired MemberRepository repository;
	
	@Test
	public void test() {
		Member member = new Member();
		member.setName("arahansa");
		
		MemberDetail memberDetail = new MemberDetail();
		memberDetail.setAddress("incheon");
		
		member.setMemberDetail(memberDetail);
		
		repository.save(member);
		assertEquals(repository.count(), 1);
	}

}
