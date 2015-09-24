package sistel.cidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sistel.estado.Estado;

@Entity
public class Cidade {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String ibge;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="estado_id")
	private Estado estado;

	
	public Cidade(Long id, String nome, String ibge, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.ibge = ibge;
		this.estado = estado;
	}

	
	public Cidade() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
