package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Apartamento;
import br.com.easycond.rn.ApartamentoRN;

@ManagedBean(name="apartamentoBean")
@RequestScoped
public class ApartamentoBean {

	private Apartamento apartamento = new Apartamento();

	private List<Apartamento> listaApartamento;

	@PostConstruct
	public String novo() {

		this.apartamento = new Apartamento();

		return "/restrito/cadastro/imovel/apartamento/form_apartamento";
	}

	public String salvar() {

		ApartamentoRN apartamentoRN = new ApartamentoRN();

		apartamentoRN.salvar(this.apartamento);

		return "/restrito/cadastro/imovel/apartamento/grid_apartamento";
	}

	public String editar() {
		return "/restrito/cadastro/imovel/apartamento/grid_apartamento";
	}

	public String excluir() {
		
		ApartamentoRN apartamentoRN = new ApartamentoRN();
		apartamentoRN.excluir(this.apartamento);
		this.listaApartamento = null;
		return null;
	}

	public List<Apartamento> getListaApartamento() {
		if (this.listaApartamento == null) {
			
			ApartamentoRN apartamentoRN = new ApartamentoRN();
			this.listaApartamento = apartamentoRN.listar();
		}

		return this.listaApartamento;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
}
