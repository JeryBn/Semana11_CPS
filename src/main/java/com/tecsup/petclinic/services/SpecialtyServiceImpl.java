package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exceptions.InvalidScheduleException;
import com.tecsup.petclinic.exceptions.SpecialtyNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository repository;

    @Override
    public Specialty findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new SpecialtyNotFoundException("Especialidad no encontrada: " + id));
    }

    @Override
    public Specialty create(Specialty specialty) {
        int opening = specialty.getHOpen();
        int closing = specialty.getHClose();

        if (opening < 0 || opening > 23 || closing < 0 || closing > 23) {
            throw new InvalidScheduleException("Las horas deben estar entre 0 y 23");
        }
        if (opening >= closing) {
            throw new InvalidScheduleException("La apertura debe ser anterior al cierre");
        }
        return repository.save(specialty);
    }
}
