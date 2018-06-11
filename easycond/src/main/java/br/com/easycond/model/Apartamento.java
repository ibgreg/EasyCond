package br.com.easycond.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="apartamento")
public class Apartamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_apartamento")
	private Integer id;
	
	@Column(name = "num_apartamento", nullable = false)
	private Integer numApartamento;
/*
	@ManyToMany(mappedBy = "apartamento")
	private List<Bloco> bloco;
	*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumApartamento() {
		return numApartamento;
	}

	public void setNumApartamento(Integer numApartamento) {
		this.numApartamento = numApartamento;
	}
/*
	public List<Bloco> getBloco() {
		return bloco;
	}

	public void setBloco(List<Bloco> bloco) {
		this.bloco = bloco;
	}
*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numApartamento == null) ? 0 : numApartamento.hashCode());
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
		Apartamento other = (Apartamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numApartamento == null) {
			if (other.numApartamento != null)
				return false;
		} else if (!numApartamento.equals(other.numApartamento))
			return false;
		return true;
	}
	
	
	
}
