package br.com.alura.adopet.api.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao{
	
	@Autowired
	private AdocaoRepository adocaoRepository;
	
//	@Autowired
//	private PetRepository petRepository;
	
	public void validar(SolicitacaoAdocaoDTO dto) {
		//Consulta otimizada
			boolean petTemAdocaoEmAndamento = adocaoRepository
					.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);
		
			if (petTemAdocaoEmAndamento) {
				throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
			}
		
		
		/* Consulta antiga
		
		Pet pet = petRepository.getReferenceById(dto.idPet());
		
		List<Adocao> adocoes = adocaoRepository.findAll();
		for (Adocao a : adocoes) {
			if (a.getPet() == pet && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
				throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
			}
		}*/
		
	}
}
