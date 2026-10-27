package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exceptions.SpecialtyNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SpecialtyServiceDatabaseTest {

    @Autowired
    private SpecialtyService specialtyService;

    @Test
    void testCreateSpecialty() throws SpecialtyNotFoundException {
        Specialty specialty = new Specialty(null, "Cirugia", "Consultorio 1", 8, 17);

        Specialty created = specialtyService.create(specialty);
        Specialty found = specialtyService.findById(created.getId());

        assertNotNull(created.getId());
        assertEquals("Cirugia", found.getName());
        assertEquals("Consultorio 1", found.getOffice());
    }

    @Test
    void testUpdateSpecialty() throws SpecialtyNotFoundException {
        Specialty created = specialtyService.create(
                new Specialty(null, "Cirugia", "Consultorio 1", 8, 17));
        created.setName("Cardiologia");
        created.setOffice("Consultorio 2");

        Specialty updated = specialtyService.update(created);
        Specialty found = specialtyService.findById(updated.getId());

        assertEquals("Cardiologia", found.getName());
        assertEquals("Consultorio 2", found.getOffice());
    }

    @Test
    void testFindSpecialtyById() throws SpecialtyNotFoundException {
        Specialty created = specialtyService.create(
                new Specialty(null, "Radiologia", "Consultorio 3", 8, 16));

        Specialty found = specialtyService.findById(created.getId());

        assertEquals(created.getId(), found.getId());
        assertEquals("Radiologia", found.getName());
    }
}
