package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Bloco;
import br.com.easycond.rn.BlocoRN;

@ManagedBean(name="blocoBean")
@RequestScoped
public class BlocoBean {


	private Bloco bloco = new Bloco();

	private List<Bloco> listaBloco;

	@PostConstruct
	public String novo() {

		this.bloco = new Bloco();

		return "/restrito/cadastro/imovel/bloco/form_bloco";
	}

	public String salvar() {

		BlocoRN blocoRN = new BlocoRN();

		blocoRN.salvar(this.bloco);

		return "/restrito/cadastro/imovel/bloco/grid_bloco";
	}

	public String editar() {
		return "/restrito/cadastro/imovel/bloco/form_bloco";
	}

	public String excluir() {
		
		BlocoRN blocoRN = new BlocoRN();
		blocoRN.excluir(this.bloco);
		this.listaBloco = null;
		return null;
	}

	public List<Bloco> getListaBloco() {
		if (this.listaBloco == null) {
			
			BlocoRN blocoRN = new BlocoRN();
			this.listaBloco = blocoRN.listar();
		}

		return this.listaBloco;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
}
