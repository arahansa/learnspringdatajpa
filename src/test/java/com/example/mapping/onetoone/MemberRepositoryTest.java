package com.example.mapping.onetoone;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.App;
import com.example.r_mapping.onetoone.Member;
import com.example.r_mapping.onetoone.MemberDetail;
import com.example.r_mapping.onetoone.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=App.class)
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
