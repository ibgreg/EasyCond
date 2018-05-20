package br.com.easycond.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	public Pessoa() {
		super();
		this.registroEntrada = new ArrayList<RegistroEntrada>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_pessoa")
	private Integer idPessoa;
	
	@Column(name="nome_pessoa", length=50, nullable=false)
	private String nomePessoa;
	
	@Column(name="cpf", length=11, nullable=false)
	private String cpf;
	
	@Column(name="email", length=100, nullable=true)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento", nullable=true)
	private Date dataNascimento;

	@Column(name="tipo_pessoa", nullable=false, updatable=false)	
	/*
	 *  C - Condômino
	 *  F - Funcionário
	 *  V - Visitante
	 */	
	private char tipoPessoa;

	@OneToMany(mappedBy="pessoa", orphanRemoval=true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<RegistroEntrada> registroEntrada;
	
	@OneToMany(mappedBy="pessoa", orphanRemoval=true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<RegistroSaida> registroSaida;
	
	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((nomePessoa == null) ? 0 : nomePessoa.hashCode());
		result = prime * result + tipoPessoa;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		if (nomePessoa == null) {
			if (other.nomePessoa != null)
				return false;
		} else if (!nomePessoa.equals(other.nomePessoa))
			return false;
		if (tipoPessoa != other.tipoPessoa)
			return false;
		return true;
	}	
}
