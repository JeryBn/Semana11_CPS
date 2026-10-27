package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;

public interface SpecialtyService {
    Specialty findById(Integer id);
    Specialty create(Specialty specialty);
}
