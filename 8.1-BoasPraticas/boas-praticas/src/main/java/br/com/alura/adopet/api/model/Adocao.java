package br.com.alura.adopet.api.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adocoes")
public class Adocao {

	public Adocao() {
	}

	public Adocao(Tutor tutor, Pet pet, String motivo) {
		this.tutor = tutor;
		this.pet = pet;
		this.motivo = motivo;
		this.status = StatusAdocao.AGUARDANDO_AVALIACAO;
		this.data = LocalDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime data;

	// Padrão Eager - carrega a entidade Pai e seus relacionamentos, mesmo sem ser
	// necessário
	@ManyToOne(fetch = FetchType.LAZY) // muitas adoções com um tutor / um tutor com várias adoções
	// @JsonBackReference("tutor_adocoes") - necessário quanto se devolvia Entidade
	// @JoinColumn(name = "tutor_id") - nome atributo_id
	private Tutor tutor;

	// Padrão Eager - carrega a entidade Pai e seus relacionamentos, mesmo sem ser
	// necessário
	@OneToOne(fetch = FetchType.LAZY) // um adoção tem um pet / um pet vinculado a uma adoção
	// @JoinColumn(name = "pet_id") - nome atributo_id
	// @JsonManagedReference("adocao_pets") - necessário quanto se devolvia Entidade
	private Pet pet;

	private String motivo;

	@Enumerated(EnumType.STRING)
	private StatusAdocao status;

	@Column(name = "justificativa_status")
	private String justificativaStatus;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Adocao adocao = (Adocao) o;
		return Objects.equals(id, adocao.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public Pet getPet() {
		return pet;
	}

	public String getMotivo() {
		return motivo;
	}

	public StatusAdocao getStatus() {
		return status;
	}

	public String getJustificativaStatus() {
		return justificativaStatus;
	}

	public void marcarComoAprovado() {		
		this.status = StatusAdocao.APROVADO;
	}

	public void marcarComoReprovado(String justificativa) {
		this.status = StatusAdocao.REPROVADO;
		this.justificativaStatus = justificativa;
	}

}
