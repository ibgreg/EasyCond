package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Bloco;

public interface BlocoDAOInterf {

	public void salvar(Bloco bloco);

	public void atualizar(Bloco bloco);

	public void excluir(Bloco bloco);

	public Bloco carregar(Integer id);

	public List<Bloco> listar();
	
}
