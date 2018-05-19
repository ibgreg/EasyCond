package br.com.easycond.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="bloco")
public class Bloco {

	@Id
	@GeneratedValue
	@Column(name="id_bloco")
	private Integer id;
	
	@Column(name = "identificacao_bloco", length=10, nullable = false)
	private String identificacaoBloco;

	
	@ManyToMany(
			targetEntity=Apartamento.class,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE}			
			)
	@JoinTable(
			name="bloco_apartamento",
			joinColumns=@JoinColumn(name="id_bloco"),
			inverseJoinColumns=@JoinColumn(name="id_apartamento")
			)
	private Set<Apartamento> apartamento;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacaoBloco() {
		return identificacaoBloco;
	}

	public void setIdentificacaoBloco(String identificacaoBloco) {
		this.identificacaoBloco = identificacaoBloco;
	}

	public Set<Apartamento> getApartamento() {
		return apartamento;
	}

	public void setApartamento(Set<Apartamento> apartamento) {
		this.apartamento = apartamento;
	}

	
	
}
