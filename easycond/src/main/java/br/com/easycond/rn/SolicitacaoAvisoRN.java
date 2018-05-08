package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.SolicitacaoAvisoDAOInterf;
import br.com.easycond.model.SolicitacaoAviso;
import br.com.easycond.util.DAOFactory;

public class SolicitacaoAvisoRN {

	private SolicitacaoAvisoDAOInterf solicitacaoAvisoDAO;

	public SolicitacaoAvisoRN() {
		
		this.solicitacaoAvisoDAO = DAOFactory.criarSolicitacaoAvisoDAO();
	}

	public SolicitacaoAviso carregar(Integer id) {

		return this.solicitacaoAvisoDAO.carregar(id);
	}

	public List<SolicitacaoAviso> listar() {

		return this.solicitacaoAvisoDAO.listar();
	}

	public void salvar(SolicitacaoAviso solicitacaoAviso) {

		Integer id = solicitacaoAviso.getIdSolicitacaoAviso();

		if (id == null || id == 0) {
			
			solicitacaoAviso.setStatus("Em análise");
			this.solicitacaoAvisoDAO.salvar(solicitacaoAviso);			
		}
		else
			this.solicitacaoAvisoDAO.atualizar(solicitacaoAviso);
	}

	public void excluir(SolicitacaoAviso solicitacaoAviso) {

		this.solicitacaoAvisoDAO.excluir(solicitacaoAviso);
	}
}
