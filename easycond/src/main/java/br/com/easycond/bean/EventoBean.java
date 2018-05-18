package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Evento;
import br.com.easycond.rn.EventoRN;

@ManagedBean(name = "eventoBean")
@RequestScoped
public class EventoBean {

	private Evento evento = new Evento();
	
	private List<Evento> lista;
	
	@PostConstruct
	public String novo() {
		this.evento = new Evento();
		return "/adm/evento/cadastrar";
	}
	
	public String salvar() {
		EventoRN eventoRN = new EventoRN();
		eventoRN.salvar(this.evento);
		
		return "/adm/evento/lista";
	}
	
	public String editar() {
		return "/adm/evento/cadastrar";
	}
	
	public String excluir() {
		EventoRN eventoRN = new EventoRN();
		eventoRN.excluir(this.evento);
		this.lista = null;
		return null;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getLista() {
		if(this.lista == null) {
			EventoRN eventoRN = new EventoRN();
			this.lista = eventoRN.listar();
		}
		
		return this.lista;
	}
	
	
}
