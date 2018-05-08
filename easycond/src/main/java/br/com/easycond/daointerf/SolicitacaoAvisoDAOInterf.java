package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.SolicitacaoAviso;

public interface SolicitacaoAvisoDAOInterf {

	public void atualizar(SolicitacaoAviso solicitacaoAviso);

	public void excluir(SolicitacaoAviso solicitacaoAviso);
	
	public void salvar(SolicitacaoAviso solicitacaoAviso);
	
	public SolicitacaoAviso carregar(Integer id);
	
	public List<SolicitacaoAviso> listar();
	
}
