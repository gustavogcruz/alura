package br.com.alura.adopet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.adopet.api.dto.AprovacaoAdocaoDTO;
import br.com.alura.adopet.api.dto.ReprovacaoAdocaoDTO;
import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.service.AdocaoService;
import jakarta.validation.Valid;

// Realiza controle de entradas e saídas

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

	@Autowired // injeção de dependência.
	private AdocaoService adocaoService;

    @PostMapping 
    @Transactional //usar DTO ao invés de uma Entity
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoAdocaoDTO dto) {
    	try {
    		this.adocaoService.solicitar(dto);
    		return ResponseEntity.ok("Adoção realizada com sucesso!");
    	} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}    	
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovacaoAdocaoDTO dto) {
    	this.adocaoService.aprovar(dto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovacaoAdocaoDTO dto) {
    	this.adocaoService.reprovar(dto);

        return ResponseEntity.ok().build();
    }

}
