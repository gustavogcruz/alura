package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente( Long id, Boolean ativo, String nome, String email, String cpf, String telefone, Endereco endereco) {
	
	public DadosDetalhamentoPaciente(Paciente paciente) {
		this(			
			paciente.getId(),
			paciente.getAtivo(),
			paciente.getNome(),
			paciente.getEmail(),
			paciente.getCpf(),
			paciente.getTelefone(),
			paciente.getEndereco());
	}
}
