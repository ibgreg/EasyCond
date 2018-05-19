package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Pessoa;
import br.com.easycond.model.RegistroVisita;
import br.com.easycond.rn.PessoaRN;
import br.com.easycond.rn.RegistroVisitaRN;

@ManagedBean(name="registroVisitaBean")
@RequestScoped
public class RegistroVisitaBean {

	private RegistroVisita registroVisita = new RegistroVisita();

	private List<RegistroVisita> listaRegistroVisita;

	private List<Pessoa> listaVisitante;
	
	@PostConstruct
	public String novo() {

		this.registroVisita = new RegistroVisita();

		return "/restrito/registro/registro_visita/form_registro_visita";
	}

	public String salvar() {

		RegistroVisitaRN registroVisitaRN = new RegistroVisitaRN();

		registroVisitaRN.salvar(this.registroVisita);

		return "/restrito/registro/registro_visita/grid_registro_visita";
	}

	public String editar() {
		return "/restrito/registro/registro_visita/form_registro_visita";
	}

	public String excluir() {
		
		RegistroVisitaRN registroVisitaRN = new RegistroVisitaRN();
		registroVisitaRN.excluir(this.registroVisita);
		this.listaRegistroVisita = null;
		return null;
	}

	public List<RegistroVisita> getListaRegistroVisita() {
		if (this.listaRegistroVisita == null) {
			
			RegistroVisitaRN registroVisitaRN = new RegistroVisitaRN();
			this.listaRegistroVisita = registroVisitaRN.listar();
		}

		return this.listaRegistroVisita;
	}

	public RegistroVisita getRegistroVisita() {
		return registroVisita;
	}

	public void setRegistroVisita(RegistroVisita registroVisita) {
		this.registroVisita = registroVisita;
	}

	public List<Pessoa> getListaVisitantes() {
		
		if(this.listaVisitante == null) {
			
			PessoaRN pessoaRN = new PessoaRN();			
			this.listaVisitante = pessoaRN.listar('V');
		}
		
		return this.listaVisitante;
	}

	public void setVisitantes(List<Pessoa> visitantes) {
		this.listaVisitante = visitantes;
	}

	public void setListaRegistroVisita(List<RegistroVisita> listaRegistroVisita) {
		this.listaRegistroVisita = listaRegistroVisita;
	}	
	
}
