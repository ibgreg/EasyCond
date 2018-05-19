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
	
	
}
