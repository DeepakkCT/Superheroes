package com.cleartax.training_superheroes.services;

import com.cleartax.training_superheroes.dto.Superhero;
import com.cleartax.training_superheroes.repository.SuperheroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperheroService {

    private  SuperheroRepository superheroRepository;

    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public Superhero addSuperhero(Superhero superhero) {

        return superheroRepository.save(superhero);
    }

    public void deleteSuperhero(String id){
        superheroRepository.deleteById(id);
    }

    public Superhero updateSuperhero(String id, Superhero updatedSuperhero) {
        Superhero existingSuperhero = superheroRepository.findById(id).orElse(null);

        existingSuperhero.setName(updatedSuperhero.getName());
        existingSuperhero.setPower(updatedSuperhero.getPower());
        existingSuperhero.setArchEnemy(updatedSuperhero.getArchEnemy());
        existingSuperhero.setUniverse(updatedSuperhero.getUniverse());

        return superheroRepository.save(existingSuperhero);
    }

    public Superhero getSuperhero(String id) {
        return superheroRepository.findById(id).orElse(null);
    }

    public List<Superhero> getAllSuperhero() {
        return superheroRepository.findAll();
    }
}
