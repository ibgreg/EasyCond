package br.com.easycond.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "votos_enquete")
public class Votos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_voto")
	private Integer id;
	
	@Column(name = "opcao_voto", nullable = false)
	private Character opcao;
	
	@Column(name = "comentario_voto", length = 250)
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "id_enquete")
	private Enquete idEnquete;
	
	@Column(name = "nome_usuario", length = 45, nullable = false)
	private String usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getOpcao() {
		return opcao;
	}

	public void setOpcao(Character opcao) {
		this.opcao = opcao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Enquete getIdEnquete() {
		return idEnquete;
	}

	public void setIdEnquete(Enquete idEnquete) {
		this.idEnquete = idEnquete;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEnquete == null) ? 0 : idEnquete.hashCode());
		result = prime * result + ((opcao == null) ? 0 : opcao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Votos other = (Votos) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idEnquete == null) {
			if (other.idEnquete != null)
				return false;
		} else if (!idEnquete.equals(other.idEnquete))
			return false;
		if (opcao == null) {
			if (other.opcao != null)
				return false;
		} else if (!opcao.equals(other.opcao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
