package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Condomino;

public interface CondominoDAOInterf {

	public void atualizar(Condomino condomino);

	public void excluir(Condomino condomino);
	
	public void salvar(Condomino condomino);
	
	public Condomino carregar(Integer id);
	
	public List<Condomino> listar();
	
}
