package br.com.alura.adopet.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.adopet.api.dto.AbrigoDto;
import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.service.AbrigoService;
import br.com.alura.adopet.api.service.PetService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {
	
    @Autowired
    private AbrigoService abrigoService;

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<AbrigoDto>> listar() {
        List<AbrigoDto> abrigos = abrigoService.listar();
        return ResponseEntity.ok(abrigos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroAbrigoDto dto) {
        try {
            abrigoService.cadatrar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<PetDto>> listarPets(@PathVariable String idOuNome) {
        try {
            List<PetDto> petsDoAbrigo = abrigoService.listarPetsDoAbrigo(idOuNome);
            return ResponseEntity.ok(petsDoAbrigo);
        } catch (ValidacaoException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idOuNome}/pets")
    @Transactional
    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid CadastroPetDto dto) {
        try {
            Abrigo abrigo = abrigoService.carregarAbrigo(idOuNome);
            petService.cadastrarPet(abrigo, dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.notFound().build();
        }
    }

//    @Autowired
//    private AbrigoRepository repository;
//
//    @GetMapping
//    public ResponseEntity<List<Abrigo>> listar() {
//        return ResponseEntity.ok(repository.findAll());
//    }
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<String> cadastrar(@RequestBody @Valid Abrigo abrigo) {
//        boolean nomeJaCadastrado = repository.existsByNome(abrigo.getNome());
//        boolean telefoneJaCadastrado = repository.existsByTelefone(abrigo.getTelefone());
//        boolean emailJaCadastrado = repository.existsByEmail(abrigo.getEmail());
//
//        if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
//            return ResponseEntity.badRequest().body("Dados já cadastrados para outro abrigo!");
//        } else {
//            repository.save(abrigo);
//            return ResponseEntity.ok().build();
//        }
//    }
//
//    @GetMapping("/{idOuNome}/pets")
//    public ResponseEntity<List<Pet>> listarPets(@PathVariable String idOuNome) {
//        try {
//            Long id = Long.parseLong(idOuNome);
//            List<Pet> pets = repository.getReferenceById(id).getPets();
//            return ResponseEntity.ok(pets);
//        } catch (EntityNotFoundException enfe) {
//            return ResponseEntity.notFound().build();
//        } catch (NumberFormatException e) {
//            try {
//                List<Pet> pets = repository.findByNome(idOuNome).getPets();
//                return ResponseEntity.ok(pets);
//            } catch (EntityNotFoundException enfe) {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }
//
//    @PostMapping("/{idOuNome}/pets")
//    @Transactional
//    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid Pet pet) {
//        try {
//            Long id = Long.parseLong(idOuNome);
//            Abrigo abrigo = repository.getReferenceById(id);
//            pet.setAbrigo(abrigo);
//            pet.setAdotado(false);
//            abrigo.getPets().add(pet);
//            repository.save(abrigo);
//            return ResponseEntity.ok().build();
//        } catch (EntityNotFoundException enfe) {
//            return ResponseEntity.notFound().build();
//        } catch (NumberFormatException nfe) {
//            try {
//                Abrigo abrigo = repository.findByNome(idOuNome);
//                pet.setAbrigo(abrigo);
//                pet.setAdotado(false);
//                abrigo.getPets().add(pet);
//                repository.save(abrigo);
//                return ResponseEntity.ok().build();
//            } catch (EntityNotFoundException enfe) {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }

}
