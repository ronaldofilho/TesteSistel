package sistel.estado;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estado {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String cod;
	
	
	public Estado() {
		super();
	}
	public Estado(Long id, String nome, String cod) {
		super();
		this.id = id;
		this.nome = nome;
		this.cod = cod;
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
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	
}
