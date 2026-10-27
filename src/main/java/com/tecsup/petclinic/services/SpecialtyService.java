package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exceptions.SpecialtyNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public List<Specialty> findByOffice(String office) {
        return specialtyRepository.findByOffice(office);
    }

    public List<Specialty> findByName(String name) {
        return specialtyRepository.findByName(name);
    }

    public void deleteSpecialty(Integer id) {
        specialtyRepository.deleteById(id);
    }

    public Specialty create(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Specialty update(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Specialty findById(Integer id) throws SpecialtyNotFoundException {
        return specialtyRepository.findById(id)
                .orElseThrow(() -> new SpecialtyNotFoundException("Specialty not found: " + id));
    }
}

