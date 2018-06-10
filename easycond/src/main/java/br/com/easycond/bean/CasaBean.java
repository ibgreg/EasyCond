package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Imovel;
import br.com.easycond.rn.ImovelRN;

@ManagedBean(name = "casaBean")
@RequestScoped
public class CasaBean {

	private static final char TIPO_IMOVEL = 'C';
	
	private Imovel imovel = new Imovel();

	private List<Imovel> listaImovel;

	@PostConstruct
	public String novo() {

		this.imovel = new Imovel();

		return "/restrito/cadastro/imovel/casa/form_casa";
	}

	public String salvar() {

		this.imovel.setTipoImovel(TIPO_IMOVEL);
		
		ImovelRN imovelRN = new ImovelRN();

		imovelRN.salvar(this.imovel);

		return "/restrito/cadastro/imovel/casa/grid_casa";
	}

	public String editar() {
		return "/restrito/cadastro/imovel/casa/form_casa";
	}

	public String excluir() {
		
		ImovelRN imovelRN = new ImovelRN();
		imovelRN.excluir(this.imovel);
		this.listaImovel = null;
		return null;
	}

	public List<Imovel> getListaImovel() {
		if (this.listaImovel == null) {
			ImovelRN imovelRN = new ImovelRN();
			this.listaImovel = imovelRN.listar(TIPO_IMOVEL);
		}

		return this.listaImovel;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
}
