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
@Table(name="registro_entrada")
public class RegistroEntrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_reg_ent")
	private Integer id;
	
	private Integer idCondomino;
	
	//private Integer idImovel;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;

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

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
}
