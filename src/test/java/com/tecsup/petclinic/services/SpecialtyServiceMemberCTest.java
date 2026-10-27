package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exceptions.InvalidScheduleException;
import com.tecsup.petclinic.exceptions.SpecialtyNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpecialtyServiceMemberCTest {
    @Mock
    private SpecialtyRepository repository;

    @InjectMocks
    private SpecialtyService service;

    @Test
    void testFindSpecialtyById_NotFound() {
        // Simulamos que no existe una especialidad con este ID.
        when(repository.findById(99)).thenReturn(Optional.empty());

        assertThrows(SpecialtyNotFoundException.class, () -> service.findById(99));

        verify(repository).findById(99);
    }

    @ParameterizedTest
    @CsvSource({"18, 9", "9, 9"})
    void testCreateSpecialty_InvalidSchedule(int opening, int closing) {
        // Probamos apertura posterior al cierre y horas iguales.
        Specialty specialty = new Specialty();
        specialty.setName("Cirugia");
        specialty.setHOpen(opening);
        specialty.setHClose(closing);

        assertThrows(InvalidScheduleException.class, () -> service.create(specialty));

        verify(repository, never()).save(any(Specialty.class));
    }

    @ParameterizedTest
    @CsvSource({"-1, 18", "24, 25", "0, 24", "-2, -1"})
    void testCreateSpecialty_InvalidHourRange(int opening, int closing) {
        // Cada fila prueba un limite invalido de apertura o cierre.
        Specialty specialty = new Specialty();
        specialty.setName("Cirugia");
        specialty.setHOpen(opening);
        specialty.setHClose(closing);

        assertThrows(InvalidScheduleException.class, () -> service.create(specialty));

        verify(repository, never()).save(any(Specialty.class));
    }
}

