package br.com.alura.adopet.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.adopet.api.dto.DadosDetalhesPetDTO;
import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.service.PetService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetController {

	private PetService petService;

	@Autowired
	private PetRepository repository;

	@GetMapping("/disponiveis")
	public ResponseEntity<List<PetDto>> listarTodosDisponiveis() {

		List<PetDto> pets = petService.buscarPetsDisponivel();
		return ResponseEntity.ok(pets);
	}
}
