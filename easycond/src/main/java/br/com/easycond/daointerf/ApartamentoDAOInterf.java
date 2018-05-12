package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Apartamento;

public interface ApartamentoDAOInterf {

	public void salvar(Apartamento apartamento);

	public void atualizar(Apartamento apartamento);

	public void excluir(Apartamento apartamento);

	public Apartamento carregar(Integer id);

	public List<Apartamento> listar();
	
}
