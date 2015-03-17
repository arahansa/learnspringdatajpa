package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.JustOne;

@Repository
public interface JustOneRepository extends JpaRepository<JustOne, Long>{

}
