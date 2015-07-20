package com.example.mapping.inheritance.singletable;

import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long>{

}
