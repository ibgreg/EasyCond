package br.com.easycond.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="solicitacao_aviso")
public class SolicitacaoAviso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_solicitacao_aviso")
	private Integer idSolicitacaoAviso;
	
	@Column(name = "titulo_solicitacao_aviso", length = 45, nullable = false)
	private String titulo;
	
	@Column(name="descricao_solicitacao_aviso", nullable=false, length=200)
	private String descricao;
	
	@Column(name="status_solicitacao_aviso", nullable=false, length=20)
	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name="data_solicitacao", nullable=false)
	private Date dataSolicitacao;
	
	public Integer getIdSolicitacaoAviso() {
		return idSolicitacaoAviso;
	}

	public void setIdSolicitacaoAviso(Integer idSolicitacaoAviso) {
		this.idSolicitacaoAviso = idSolicitacaoAviso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSolicitacao == null) ? 0 : dataSolicitacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idSolicitacaoAviso == null) ? 0 : idSolicitacaoAviso.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		SolicitacaoAviso other = (SolicitacaoAviso) obj;
		if (dataSolicitacao == null) {
			if (other.dataSolicitacao != null)
				return false;
		} else if (!dataSolicitacao.equals(other.dataSolicitacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idSolicitacaoAviso == null) {
			if (other.idSolicitacaoAviso != null)
				return false;
		} else if (!idSolicitacaoAviso.equals(other.idSolicitacaoAviso))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}	
}
