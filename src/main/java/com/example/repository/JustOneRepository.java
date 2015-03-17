package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.JustOne;


public interface JustOneRepository extends JpaRepository<JustOne, Long>{

}
