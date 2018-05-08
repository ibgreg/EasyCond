package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Condomino;
import br.com.easycond.rn.CondominoRN;

@ManagedBean(name="condominoBean")
@RequestScoped
public class CondominoBean {

	private Condomino condomino = new Condomino();
	
	private List<Condomino> listaCondomino;
	
	@PostConstruct
	public String novo() {
		
		this.condomino = new Condomino();
		
		return "/restrito/cadastro/condomino/grid_condomino";
	}
	
	public void salvar() {
		
		CondominoRN condominoRN = new CondominoRN();
		
		condominoRN.salvar(this.condomino);		
		
		//return "restrito/home";
	}	
	
	public List<Condomino> getListaCondomino() {
		if (this.listaCondomino == null) {
			CondominoRN condominoRN = new CondominoRN();
			this.listaCondomino = condominoRN.listar();
		}
		
		return this.listaCondomino;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
	
	
}
