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
	
	public List<Pessoa> listar(char tipoPessoa){
		
		return this.pessoaDAO.listar(tipoPessoa);
	}
	
	public String salvar(Pessoa pessoa) {
		
		Integer id = pessoa.getIdPessoa();
		
		if(verificaCPFIgual(pessoa.getCpf()))
			return "Já existe outra pessoa com o CPF " + pessoa.getCpf() + " cadastrado.";
		
		if(id == null || id == 0) 			
			this.pessoaDAO.salvar(pessoa);		
		else 		
			this.pessoaDAO.atualizar(pessoa);
		
		return null;
	}
	
	public void excluir(Pessoa pessoa) {
		
		this.pessoaDAO.excluir(pessoa);
	}
	
	// Validações de regra de negócio
	private boolean verificaCPFIgual(String cpf) {
		
		List<Pessoa> arrayPessoa;
		
		arrayPessoa = this.pessoaDAO.listar();
		
		for(Pessoa p : arrayPessoa) 			
			if(cpf.equals(p.getCpf()))
				return true;		
		
		return false;
	}
}
