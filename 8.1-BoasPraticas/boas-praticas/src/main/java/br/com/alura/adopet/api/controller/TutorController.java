package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.AtualizacaoTutorDto;
import br.com.alura.adopet.api.dto.CadastroTutorDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {
	
    @Autowired
    private TutorService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroTutorDto dto) {
        try {
            service.cadastrar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizacaoTutorDto dto) {
        try {
            service.atualizar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

//    @Autowired
//    private TutorRepository repository;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<String> cadastrar(@RequestBody @Valid Tutor tutor) {
//        boolean telefoneJaCadastrado = repository.existsByTelefone(tutor.getTelefone());
//        boolean emailJaCadastrado = repository.existsByEmail(tutor.getEmail());
//
//        if (telefoneJaCadastrado || emailJaCadastrado) {
//            return ResponseEntity.badRequest().body("Dados já cadastrados para outro tutor!");
//        } else {
//            repository.save(tutor);
//            return ResponseEntity.ok().build();
//        }
//    }
//
//    @PutMapping
//    @Transactional
//    public ResponseEntity<String> atualizar(@RequestBody @Valid Tutor tutor) {
//        repository.save(tutor);
//        return ResponseEntity.ok().build();
//    }

}
