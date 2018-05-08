package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Funcionario;

public interface FuncionarioDAOInterf {

	public void atualizar(Funcionario funcionario);

	public void excluir(Funcionario funcionario);
	
	public void salvar(Funcionario funcionario);
	
	public Funcionario carregar(Integer id);
	
	public List<Funcionario> listar();
	
}
