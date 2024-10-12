package br.com.alura.adopet.api.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao{
	
	@Autowired
	private AdocaoRepository adocaoRepository;
	@Autowired
	private TutorRepository tutorRepository;
	
	public void validar(SolicitacaoAdocaoDTO dto) {
		Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());		
		
		List<Adocao> adocoes = adocaoRepository.findAll();
		for (Adocao a : adocoes) {
			if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
				throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
			}
		}
		
	}

}
