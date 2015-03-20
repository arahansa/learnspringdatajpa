package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.JustOne;


public interface JustOneRepository extends JpaRepository<JustOne, Long>{
	public JustOne findByMessage(String message);
	public List<JustOne> findBydateJoinBeforeAndMessage(Date date, String message);
}
