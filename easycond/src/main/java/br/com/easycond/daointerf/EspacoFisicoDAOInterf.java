package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.EspacoFisico;

public interface EspacoFisicoDAOInterf {

	public void salvar(EspacoFisico espacoFisico);
	
	public void atualizar(EspacoFisico espacoFisico);
	
	public void excluir(EspacoFisico espacoFisico);
	
	public EspacoFisico carregar(Integer id);
	
	public List<EspacoFisico> listar();
	
	public EspacoFisico carregarItemCombo(Integer id);
}
