package com.example.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardArticleRepository extends JpaRepository<BoardArticle, Long> {

	@Modifying(clearAutomatically=true)
	@Query("update BoardArticle t set t.numRead = t.numRead + 1 where t.id = ?1")
	public int plusNumRead(Long id);
}
