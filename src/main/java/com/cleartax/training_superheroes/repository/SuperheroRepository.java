package com.cleartax.training_superheroes.repository;

import com.cleartax.training_superheroes.dto.Superhero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuperheroRepository extends MongoRepository<Superhero, String> {


}
