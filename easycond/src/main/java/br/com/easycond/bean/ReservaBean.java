package br.com.easycond.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import br.com.easycond.model.EspacoFisico;
import br.com.easycond.model.Reserva;
import br.com.easycond.rn.EspacoFisicoRN;
import br.com.easycond.rn.ReservaRN;

@ManagedBean(name = "reservaBean")
@RequestScoped
public class ReservaBean {
	
	private Reserva reserva = new Reserva();
	private EspacoFisico espacoFisico = new EspacoFisico();
	
	private List<Reserva> lista;
	private List<EspacoFisico> listaEspacoFisico;
	
	private Integer opcaoSelecionada;
	
	@PostConstruct
	public String novo() {
		this.reserva = new Reserva();
		return "/restrito/reserva/cadastrar";
	}
	
	public String salvar() {
		
		this.espacoFisico = new EspacoFisicoRN().carregar(opcaoSelecionada);
		
		ReservaRN reservaRN = new ReservaRN();
		
		if (!reservaRN.verificaReservaExistente(espacoFisico.getId(), reserva.getDataInicio(), reserva.getDataFim())) {
			if (espacoFisico != null) {
				reserva.setEspacoFisico(espacoFisico);			
				reservaRN.salvar(this.reserva);
			}
			
			return "/restrito/reserva/lista";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao reservar", "O espaco selecionado já está reservado nesse periodo!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);			
			
			return "";
		}
		
		
	}
	
	public String editar() {
		opcaoSelecionada = reserva.getEspacoFisico().getId();
 		return "/restrito/reserva/cadastrar";
	}
	
	public String excluir() {
		ReservaRN reservaRN = new ReservaRN();
		reservaRN.excluir(this.reserva);
		this.lista = null;
		return null;
	}
	
	public Reserva getReserva() {
		return reserva;
	}
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public EspacoFisico getEspacoFisico() {
		return espacoFisico;
	}

	public void setEspacoFisico(EspacoFisico espacoFisico) {
		this.espacoFisico = espacoFisico;
	}

	public List<Reserva> getLista() {
		if (this.lista == null) {
			ReservaRN reservaRN = new ReservaRN();
			this.lista = reservaRN.listar();
		}
		return this.lista;
	}

	public List<EspacoFisico> getListaEspacoFisico() {
		if (this.listaEspacoFisico == null) {
			EspacoFisicoRN espacoFisicoRN = new EspacoFisicoRN();
			this.listaEspacoFisico = espacoFisicoRN.listar();
		}
		
		return this.listaEspacoFisico;
	}

	public void setListaEspacoFisico(List<EspacoFisico> listaEspacoFisico) {
		this.listaEspacoFisico = listaEspacoFisico;
	}

	public Integer getOpcaoSelecionada() {
		return opcaoSelecionada;
	}

	public void setOpcaoSelecionada(Integer opcaoSelecionada) {
		this.opcaoSelecionada = opcaoSelecionada;
	}

}
