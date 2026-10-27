package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exceptions.SpecialtyNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialtyServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private SpecialtyService specialtyService;

    @Test
    void testCreateSpecialty() {
        Specialty specialty = new Specialty(null, "Cirugia", "Consultorio 1", 8, 17);
        Specialty saved = new Specialty(1, "Cirugia", "Consultorio 1", 8, 17);
        when(specialtyRepository.save(specialty)).thenReturn(saved);

        Specialty result = specialtyService.create(specialty);

        assertNotNull(result.getId());
        assertEquals("Cirugia", result.getName());
        assertEquals("Consultorio 1", result.getOffice());
        verify(specialtyRepository).save(specialty);
    }

    @Test
    void testUpdateSpecialty() {
        Specialty specialty = new Specialty(1, "Cardiologia", "Consultorio 2", 9, 18);
        when(specialtyRepository.save(specialty)).thenReturn(specialty);

        Specialty result = specialtyService.update(specialty);

        assertEquals(1, result.getId());
        assertEquals("Cardiologia", result.getName());
        assertEquals("Consultorio 2", result.getOffice());
        assertEquals(9, result.getHOpen());
        assertEquals(18, result.getHClose());
        verify(specialtyRepository).save(specialty);
    }

    @Test
    void testFindSpecialtyById() throws SpecialtyNotFoundException {
        Specialty specialty = new Specialty(1, "Radiologia", "Consultorio 3", 8, 16);
        when(specialtyRepository.findById(1)).thenReturn(Optional.of(specialty));

        Specialty result = specialtyService.findById(1);

        assertEquals(1, result.getId());
        assertEquals("Radiologia", result.getName());
        verify(specialtyRepository).findById(1);
    }
}
