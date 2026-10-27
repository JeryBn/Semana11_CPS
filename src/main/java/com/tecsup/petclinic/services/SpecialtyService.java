
package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import java.util.List;

public interface SpecialtyService {

    // Buscar especialidades por consultorio
    List<Specialty> findByOffice(String office);

    // Buscar especialidades por nombre
    List<Specialty> findByName(String name);

    // Eliminar especialidad por ID
    void deleteSpecialty(Integer id);

}
