package com.cleartax.training_superheroes.controllers;


import com.cleartax.training_superheroes.dto.Superhero;
import com.cleartax.training_superheroes.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/get/{id}")
    public Superhero getSuperhero(@PathVariable String id) {

        return superheroService.getSuperhero(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSuperhero(@PathVariable String id) {

         superheroService.deleteSuperhero(id);

    }

    @GetMapping("/all")
    public List<Superhero> getAllSuperhero() {

        return superheroService.getAllSuperhero();
    }


    @PutMapping("/update")
    public Superhero updateSuperhero(@RequestParam String id, @RequestBody Superhero superhero) {

        return superheroService.updateSuperhero(id, superhero);
    }

    @PostMapping("/add")
    public void addSuperhero(@RequestBody Superhero superhero) {

        superheroService.addSuperhero(superhero);
    }

}
