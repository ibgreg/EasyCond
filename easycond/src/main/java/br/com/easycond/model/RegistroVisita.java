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
@Table(name="registro_visita")
public class RegistroVisita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_ingresso")
	private Integer id;
	
	private Integer idVisitante;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio_visita")
	private Date dataInicioVisita;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_fim_visita")
	private Date dataFimVisita;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInicioVisita() {
		return dataInicioVisita;
	}

	public void setDataInicioVisita(Date dataInicioVisita) {
		this.dataInicioVisita = dataInicioVisita;
	}

	public Date getDataFimVisita() {
		return dataFimVisita;
	}

	public void setDataFimVisita(Date dataFimVisita) {
		this.dataFimVisita = dataFimVisita;
	}	
}
