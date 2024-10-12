package br.com.alura.adopet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;

public class PetService {

	@Autowired
	private PetRepository repository;

	public List<PetDto> buscarPetsDisponivel() {

		return repository
				.findAllAdotadoFalse()
				.stream()
				.map(PetDto::new)
				.toList();

	}
	
    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
