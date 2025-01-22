package com.cleartax.training_superheroes.servicestest;

import com.cleartax.training_superheroes.dto.Superhero;
import com.cleartax.training_superheroes.repository.SuperheroRepository;
import com.cleartax.training_superheroes.services.SuperheroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SuperheroServiceTest {

    @Mock
    private SuperheroRepository superheroRepository;

    @InjectMocks
    private SuperheroService superheroService;

    @Test
    void addSuperhero_Success() {
        Superhero superhero = new Superhero();
        when(superheroRepository.save(any())).thenReturn(superhero);

        Superhero result = superheroService.addSuperhero(superhero);

        verify(superheroRepository).save(superhero);
        assertEquals(superhero, result);
    }

    @Test
    void deleteSuperhero_Success() {
        String id = "1";
        doNothing().when(superheroRepository).deleteById(id);

        superheroService.deleteSuperhero(id);

        verify(superheroRepository).deleteById(id);
    }

    @Test
    void updateSuperhero_Success() {
        String id = "1";
        Superhero existing = new Superhero();
        Superhero updated = new Superhero();
        updated.setName("Batman");

        when(superheroRepository.findById(id)).thenReturn(Optional.of(existing));
        when(superheroRepository.save(any())).thenReturn(updated);

        Superhero result = superheroService.updateSuperhero(id, updated);

        verify(superheroRepository).findById(id);
        verify(superheroRepository).save(existing);
        assertEquals(updated, result);
    }

    @Test
    void getSuperhero_Success() {
        String id = "1";
        Superhero superhero = new Superhero();
        when(superheroRepository.findById(id)).thenReturn(Optional.of(superhero));

        Superhero result = superheroService.getSuperhero(id);

        verify(superheroRepository).findById(id);
        assertEquals(superhero, result);
    }

    @Test
    void getAllSuperhero_Success() {
        List<Superhero> superheroes = List.of(new Superhero());
        when(superheroRepository.findAll()).thenReturn(superheroes);

        List<Superhero> result = superheroService.getAllSuperhero();

        verify(superheroRepository).findAll();
        assertEquals(superheroes, result);
    }
}
