package br.com.easycond.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="bloco")
public class Bloco {

	@Id
	@GeneratedValue
	@Column(name="id_bloco")
	private Integer id;
	
	@Column(name = "identificacao_bloco", length=10, nullable = false)
	private String identificacaoBloco;

	
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="bloco_apartamento",
			joinColumns = {@JoinColumn(name="id_bloco")},
			inverseJoinColumns = {@JoinColumn(name="id_apartamento")}
			)
	private List<Apartamento> apartamento;*/
	
	@OneToMany(mappedBy="bloco", orphanRemoval=true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Imovel> bloco;
	
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
/*
	public List<Apartamento> getApartamento() {
		return apartamento;
	}

	public void setApartamento(List<Apartamento> apartamento) {
		this.apartamento = apartamento;
	}
*/
	public List<Imovel> getBloco() {
		return bloco;
	}

	public void setBloco(List<Imovel> bloco) {
		this.bloco = bloco;
	}	
	
	
	
}
