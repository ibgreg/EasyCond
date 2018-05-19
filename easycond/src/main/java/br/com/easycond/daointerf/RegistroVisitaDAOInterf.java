package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.RegistroVisita;

public interface RegistroVisitaDAOInterf {

	public void salvar(RegistroVisita registroVisita);

	public void atualizar(RegistroVisita registroVisita);

	public void excluir(RegistroVisita registroVisita);

	public RegistroVisita carregar(Integer id);

	public List<RegistroVisita> listar();
	
}
