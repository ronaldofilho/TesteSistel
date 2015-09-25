package sistel.cadClientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class CadClientes {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String apelido;
	private String documento;
	private Date datanascimento;	
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;

	
	public CadClientes(Long id, String nome, String apelido, String documento,
			String datanascimento, String cidade, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.documento = documento;
		this.setDatanascimento(datanascimento);
		this.cidade = cidade;
		this.estado = estado;
	}

	public CadClientes(Long id, String nome, String apelido, String documento,
			Date datanascimento, String rua, String bairro, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.documento = documento;
		this.datanascimento = datanascimento;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}




	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CadClientes() {
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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {		
		try {
			this.datanascimento = new SimpleDateFormat("dd/MM/yyyy").parse(datanascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	
}
