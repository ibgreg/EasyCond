package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Pessoa;

public interface PessoaDAOInterf {

	public void atualizar(Pessoa pessoa);

	public void excluir(Pessoa pessoa);
	
	public void salvar(Pessoa pessoa);
	
	public Pessoa carregar(Integer id);
	
	public List<Pessoa> listar(char tipoPessoa);
}
