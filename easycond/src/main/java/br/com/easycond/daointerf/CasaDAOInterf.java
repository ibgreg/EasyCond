package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Casa;

public interface CasaDAOInterf {

	public void salvar(Casa casa);

	public void atualizar(Casa casa);

	public void excluir(Casa casa);

	public Casa carregar(Integer id);

	public List<Casa> listar();

}
