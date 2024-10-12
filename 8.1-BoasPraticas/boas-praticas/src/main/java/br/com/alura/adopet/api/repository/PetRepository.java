package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
	List<Pet> findAllAdotadoFalse();
	
	List<Pet> findByAbrigo(Abrigo abrigo);

}
