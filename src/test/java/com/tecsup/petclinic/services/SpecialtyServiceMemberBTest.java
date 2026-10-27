
package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpecialtyServiceMemberBTest {

	@Mock
	private SpecialtyRepository specialtyRepository;

	@InjectMocks
	private SpecialtyService specialtyService;

	private Specialty specialty;

	@BeforeEach
	void setUp() {
		specialty = new Specialty(
				1, "radiology", "Farewell", 8, 18
		);
	}

	@Test
	void testFindByOffice() {
		when(specialtyRepository.findByOffice("Farewell"))
				.thenReturn(List.of(specialty));

		List<Specialty> resultado =
				specialtyService.findByOffice("Farewell");

		assertEquals(1, resultado.size());
		assertEquals("Farewell", resultado.get(0).getOffice());
		assertEquals("radiology", resultado.get(0).getName());

		verify(specialtyRepository).findByOffice("Farewell");
	}

	@Test
	void testFindByName() {
		when(specialtyRepository.findByName("radiology"))
				.thenReturn(List.of(specialty));

		List<Specialty> resultado =
				specialtyService.findByName("radiology");

		assertEquals(1, resultado.size());
		assertEquals("radiology", resultado.get(0).getName());

		verify(specialtyRepository).findByName("radiology");
	}

	@Test
	void testDeleteSpecialty() {
		specialtyService.deleteSpecialty(1);

		verify(specialtyRepository, times(1)).deleteById(1);
	}
}

