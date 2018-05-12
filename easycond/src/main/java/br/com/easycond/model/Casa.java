package br.com.easycond.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="casa")
public class Casa implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "num_casa", nullable = false)
	private Integer numCasa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(Integer numCasa) {
		this.numCasa = numCasa;
	}
	
	
}
