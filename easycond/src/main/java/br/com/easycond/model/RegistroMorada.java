package br.com.easycond.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="registro_morada")
public class RegistroMorada implements Serializable{

	public RegistroMorada() {
		super();
		this.pessoa = new Pessoa();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_ingresso")
	private Integer id;
	
	//private Integer idImovel;
	
	//@SuppressWarnings("deprecation")
	@ManyToOne
	//@JoinColumn(name="pessoa", nullable=false)
	//@ForeignKey(name="id_condomino")
	private Pessoa pessoa;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_ingresso", nullable=false)
	private Date dataIngresso;

	@Temporal(TemporalType.DATE)
	@Column(name="data_egresso")
	private Date dataEgresso;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public Date getDataEgresso() {
		return dataEgresso;
	}

	public void setDataEgresso(Date dataEgresso) {
		this.dataEgresso = dataEgresso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEgresso == null) ? 0 : dataEgresso.hashCode());
		result = prime * result + ((dataIngresso == null) ? 0 : dataIngresso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		RegistroMorada other = (RegistroMorada) obj;
		if (dataEgresso == null) {
			if (other.dataEgresso != null)
				return false;
		} else if (!dataEgresso.equals(other.dataEgresso))
			return false;
		if (dataIngresso == null) {
			if (other.dataIngresso != null)
				return false;
		} else if (!dataIngresso.equals(other.dataIngresso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}	
}
