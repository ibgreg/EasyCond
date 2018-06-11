package br.com.easycond.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_imovel")
	private Integer id;

	@Column(name = "num_imovel", nullable = false)
	private Integer numImovel;
	
	@Column(name="tipo_imovel", updatable=false)
	private char tipoImovel;

	@ManyToOne
	private Bloco bloco;
	
	@OneToOne
	private Pessoa ocupante;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumImovel() {
		return numImovel;
	}

	public void setNumImovel(Integer numImovel) {
		this.numImovel = numImovel;
	}

	public char getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(char tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}	
	
	public Pessoa getOcupante() {
		return ocupante;
	}

	public void setOcupante(Pessoa ocupante) {
		this.ocupante = ocupante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloco == null) ? 0 : bloco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numImovel == null) ? 0 : numImovel.hashCode());
		result = prime * result + tipoImovel;
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
		Imovel other = (Imovel) obj;
		if (bloco == null) {
			if (other.bloco != null)
				return false;
		} else if (!bloco.equals(other.bloco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numImovel == null) {
			if (other.numImovel != null)
				return false;
		} else if (!numImovel.equals(other.numImovel))
			return false;
		if (tipoImovel != other.tipoImovel)
			return false;
		return true;
	}	
	
	
}
