package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.FuncionarioDAOInterf;
import br.com.easycond.model.Funcionario;
import br.com.easycond.model.Pessoa;
import br.com.easycond.util.DAOFactory;

public class FuncionarioRN {

	private FuncionarioDAOInterf funcionarioDAO;
	private PessoaRN pessoaRN;
	
	public FuncionarioRN() {
		
		this.funcionarioDAO = DAOFactory.criarFuncionarioDAO();
	}
	
	public Funcionario carregar(Integer id) {
		
		return this.funcionarioDAO.carregar(id);
	}
	
	public List<Funcionario> listar(){
		
		return this.funcionarioDAO.listar();
	}
	
	public String salvar(Funcionario funcionario, Pessoa pessoa) {
		
		Integer id = funcionario.getIdFuncionario();
		
		if(id == null || id == 0) 			
			this.funcionarioDAO.salvar(funcionario);		
		else 		
			this.funcionarioDAO.atualizar(funcionario);
		
		pessoaRN = new PessoaRN();
		
		return pessoaRN.salvar(pessoa);		
	}
	
	public void excluir(Funcionario funcionario, Pessoa pessoa) {
		
		this.funcionarioDAO.excluir(funcionario);
	}
}
