package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.PessoaDAOInterf;
import br.com.easycond.model.Pessoa;
import br.com.easycond.util.DAOFactory;

public class PessoaRN {

	private PessoaDAOInterf pessoaDAO;
	
	public PessoaRN() {
		
		this.pessoaDAO = DAOFactory.criarPessoaDAO();
	}
	
	public Pessoa carregar(Integer id) {
		
		return this.pessoaDAO.carregar(id);
	}
	
	public List<Pessoa> listar(){
		
		return this.pessoaDAO.listar();
	}
	
	public void salvar(Pessoa pessoa) {
		
		Integer id = pessoa.getIdPessoa();
		
		if(id == null || id == 0) 			
			this.pessoaDAO.salvar(pessoa);		
		else 		
			this.pessoaDAO.atualizar(pessoa);
	}
	
	public void excluir(Pessoa pessoa) {
		
		this.pessoaDAO.excluir(pessoa);
	}
}
