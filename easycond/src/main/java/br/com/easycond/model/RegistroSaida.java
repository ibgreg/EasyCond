package br.com.easycond.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="egresso_condomino")
public class RegistroSaida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_ingresso")
	private Integer id;
	
	private Integer idCondomino;
	
	//private Integer idImovel;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_ingresso")
	private Date dataSaida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCondomino() {
		return idCondomino;
	}

	public void setIdCondomino(Integer idCondomino) {
		this.idCondomino = idCondomino;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSaida == null) ? 0 : dataSaida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idCondomino == null) ? 0 : idCondomino.hashCode());
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
		RegistroSaida other = (RegistroSaida) obj;
		if (dataSaida == null) {
			if (other.dataSaida != null)
				return false;
		} else if (!dataSaida.equals(other.dataSaida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCondomino == null) {
			if (other.idCondomino != null)
				return false;
		} else if (!idCondomino.equals(other.idCondomino))
			return false;
		return true;
	}
}
