package br.com.easycond.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enquete_assembleia")
public class Enquete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_enquete")
	private Integer id;
	
	@Column(name = "pergunta_enquete", length = 200, nullable = false)
	private String pergunta;
	
	@OneToOne(mappedBy = "enquete")
	private Assembleia assembleia;
	
	@OneToMany(mappedBy = "idEnquete", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "id_votos")
	private List<Votos> votos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Assembleia getAssembleia() {
		return assembleia;
	}

	public void setAssembleia(Assembleia assembleia) {
		this.assembleia = assembleia;
	}

	public List<Votos> getVotos() {
		return votos;
	}

	public void setVotos(List<Votos> votos) {
		this.votos = votos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assembleia == null) ? 0 : assembleia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pergunta == null) ? 0 : pergunta.hashCode());
		result = prime * result + ((votos == null) ? 0 : votos.hashCode());
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
		Enquete other = (Enquete) obj;
		if (assembleia == null) {
			if (other.assembleia != null)
				return false;
		} else if (!assembleia.equals(other.assembleia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		if (votos == null) {
			if (other.votos != null)
				return false;
		} else if (!votos.equals(other.votos))
			return false;
		return true;
	}

}
