package br.com.easycond.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloco")
public class Bloco {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "identificacao_bloco", length=10, nullable = false)
	private String identificacaoBloco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
