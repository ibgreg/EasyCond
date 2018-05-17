package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.RegistroEntrada;
import br.com.easycond.rn.RegistroEntradaRN;

@ManagedBean(name="registroEntradaBean")
@RequestScoped
public class RegistroEntradaBean {

	private RegistroEntrada registroEntrada = new RegistroEntrada();

	private List<RegistroEntrada> listaRegistroEntrada;

	@PostConstruct
	public String novo() {

		this.registroEntrada = new RegistroEntrada();

		return "/restrito/cadastro/imovel/registroEntrada/form_registro_entrada";
	}

	public String salvar() {

		RegistroEntradaRN registroEntradaRN = new RegistroEntradaRN();

		registroEntradaRN.salvar(this.registroEntrada);

		return "/restrito/cadastro/imovel/registroEntrada/grid_registro_entrada";
	}

	public String editar() {
		return "/restrito/cadastro/imovel/registroEntrada/grid_registro_entrada";
	}

	public String excluir() {
		
		RegistroEntradaRN registroEntradaRN = new RegistroEntradaRN();
		registroEntradaRN.excluir(this.registroEntrada);
		this.listaRegistroEntrada = null;
		return null;
	}

	public List<RegistroEntrada> getListaRegistroEntrada() {
		if (this.listaRegistroEntrada == null) {
			
			RegistroEntradaRN registroEntradaRN = new RegistroEntradaRN();
			this.listaRegistroEntrada = registroEntradaRN.listar();
		}

		return this.listaRegistroEntrada;
	}

	public RegistroEntrada getRegistroEntrada() {
		return registroEntrada;
	}

	public void setRegistroEntrada(RegistroEntrada registroEntrada) {
		this.registroEntrada = registroEntrada;
	}
	
}
