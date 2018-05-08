package br.com.easycond.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="condomino")
public class Condomino implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_condomino")
	private Integer idCondomino;	
	
	@OneToOne
	@JoinColumn (name="id_pessoa")
	private Pessoa pessoa = new Pessoa();

	public Integer getIdCondomino() {
		return idCondomino;
	}


	public void setIdCondomino(Integer idCondomino) {
		this.idCondomino = idCondomino;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
}
