package br.com.easycond.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_ocorrencia")
	private Integer idOcorrencia;
	
	@Column(name = "descricao_ocorrencia", length = 200, nullable = false)
	private String descricaoOcorrencia;
	
	@Column(name = "tipo_ocorrencia", nullable = false)
	private Character tipoOcorrencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ocorrencia",  nullable = false)
	private Date dataOcorrencia;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuarioOcorrencia;

	public Integer getIdOcorrencia() {
		return idOcorrencia;
	}

	public void setIdOcorrencia(Integer idOcorrencia) {
		this.idOcorrencia = idOcorrencia;
	}

	public String getDescricaoOcorrencia() {
		return descricaoOcorrencia;
	}

	public void setDescricaoOcorrencia(String descricaoOcorrencia) {
		this.descricaoOcorrencia = descricaoOcorrencia;
	}

	public Character getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(Character tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public Usuario getUsuarioOcorrencia() {
		return usuarioOcorrencia;
	}

	public void setUsuarioOcorrencia(Usuario usuarioOcorrencia) {
		this.usuarioOcorrencia = usuarioOcorrencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOcorrencia == null) ? 0 : dataOcorrencia.hashCode());
		result = prime * result + ((descricaoOcorrencia == null) ? 0 : descricaoOcorrencia.hashCode());
		result = prime * result + ((idOcorrencia == null) ? 0 : idOcorrencia.hashCode());
		result = prime * result + ((tipoOcorrencia == null) ? 0 : tipoOcorrencia.hashCode());
		result = prime * result + ((usuarioOcorrencia == null) ? 0 : usuarioOcorrencia.hashCode());
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
		Ocorrencia other = (Ocorrencia) obj;
		if (dataOcorrencia == null) {
			if (other.dataOcorrencia != null)
				return false;
		} else if (!dataOcorrencia.equals(other.dataOcorrencia))
			return false;
		if (descricaoOcorrencia == null) {
			if (other.descricaoOcorrencia != null)
				return false;
		} else if (!descricaoOcorrencia.equals(other.descricaoOcorrencia))
			return false;
		if (idOcorrencia == null) {
			if (other.idOcorrencia != null)
				return false;
		} else if (!idOcorrencia.equals(other.idOcorrencia))
			return false;
		if (tipoOcorrencia == null) {
			if (other.tipoOcorrencia != null)
				return false;
		} else if (!tipoOcorrencia.equals(other.tipoOcorrencia))
			return false;
		if (usuarioOcorrencia == null) {
			if (other.usuarioOcorrencia != null)
				return false;
		} else if (!usuarioOcorrencia.equals(other.usuarioOcorrencia))
			return false;
		return true;
	}

}
