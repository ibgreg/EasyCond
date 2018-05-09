package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.SolicitacaoAviso;
import br.com.easycond.rn.AvisoRN;
import br.com.easycond.rn.SolicitacaoAvisoRN;

@ManagedBean(name = "solicitacaoAvisoBean")
@RequestScoped
public class SolicitacaoAvisoBean {

	private SolicitacaoAviso solicitacaoAviso = new SolicitacaoAviso();

	private List<SolicitacaoAviso> listaSolicitacaoAviso;

	@PostConstruct
	public String novo() {

		this.solicitacaoAviso = new SolicitacaoAviso();

		return "/public/solicitacao/aviso/form_solicitacao_aviso";
	}

	public String salvar() {

		SolicitacaoAvisoRN solicitacaoAvisoRN = new SolicitacaoAvisoRN();

		solicitacaoAvisoRN.salvar(this.solicitacaoAviso);

		return "/public/solicitacao/aviso/grid_solicitacao_aviso";
	}

	public String editar() {
		return "/public/solicitacao/aviso/grid_solicitacao_aviso";
	}

	public String excluir() {
		
		SolicitacaoAvisoRN solicitacaoAvisoRN = new SolicitacaoAvisoRN();
		solicitacaoAvisoRN.excluir(this.solicitacaoAviso);
		this.listaSolicitacaoAviso = null;
		return null;
	}

	public List<SolicitacaoAviso> getListaSolicitacaoAviso() {
		if (this.listaSolicitacaoAviso == null) {
			SolicitacaoAvisoRN solicitacaoAvisoRN = new SolicitacaoAvisoRN();
			this.listaSolicitacaoAviso = solicitacaoAvisoRN.listar();
		}

		return this.listaSolicitacaoAviso;
	}

	public SolicitacaoAviso getSolicitacaoAviso() {
		return solicitacaoAviso;
	}

	public void setSolicitacaoAviso(SolicitacaoAviso solicitacaoAviso) {
		this.solicitacaoAviso = solicitacaoAviso;
	}
}
