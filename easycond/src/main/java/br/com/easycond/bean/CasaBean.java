package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Casa;
import br.com.easycond.rn.CasaRN;

@ManagedBean(name = "casaBean")
@RequestScoped
public class CasaBean {

	private Casa casa = new Casa();

	private List<Casa> listaCasa;

	@PostConstruct
	public String novo() {

		this.casa = new Casa();

		return "/restrito/cadastro/imovel/casa/form_casa";
	}

	public String salvar() {

		CasaRN casaRN = new CasaRN();

		casaRN.salvar(this.casa);

		return "/restrito/cadastro/imovel/casa/grid_casa";
	}

	public String editar() {
		return "/restrito/cadastro/imovel/casa/form_casa";
	}

	public String excluir() {
		
		CasaRN casaRN = new CasaRN();
		casaRN.excluir(this.casa);
		this.listaCasa = null;
		return null;
	}

	public List<Casa> getListaCasa() {
		if (this.listaCasa == null) {
			CasaRN casaRN = new CasaRN();
			this.listaCasa = casaRN.listar();
		}

		return this.listaCasa;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
}
