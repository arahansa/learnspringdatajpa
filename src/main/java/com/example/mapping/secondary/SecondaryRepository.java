package com.example.mapping.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryRepository extends JpaRepository<Secondarymaster, Long>{
	Secondarymaster findBySub2(String sub2);
}	
