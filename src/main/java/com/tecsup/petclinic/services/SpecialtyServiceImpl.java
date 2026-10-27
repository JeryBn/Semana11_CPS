
package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public List<Specialty> findByOffice(String office) {
        return specialtyRepository.findByOffice(office);
    }

    @Override
    public List<Specialty> findByName(String name) {
        return specialtyRepository.findByName(name);
    }

    @Override
    public void deleteSpecialty(Integer id) {
        specialtyRepository.deleteById(id);
    }
}
