package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Imovel;
import br.com.easycond.rn.ImovelRN;

@ManagedBean(name="apartamentoBean")
@RequestScoped
public class ApartamentoBean {

	private final static char TIPO_IMOVEL = 'A';
	
	private Imovel imovel = new Imovel();

	private List<Imovel> listaImovel;

	@PostConstruct
	public String novo() {

		this.imovel = new Imovel();

		return "/restrito/cadastro/imovel/apartamento/form_apartamento";
	}

	public String salvar() {

		ImovelRN imovelRN = new ImovelRN();

		imovel.setTipoImovel(TIPO_IMOVEL);
		
		imovelRN.salvar(this.imovel);

		return "/restrito/cadastro/imovel/apartamento/grid_apartamento";
	}

	public String editar() {
		return "/restrito/cadastro/imovel/apartamento/form_apartamento";
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
