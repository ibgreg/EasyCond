package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.easycond.daointerf.PessoaDAOInterf;
import br.com.easycond.model.Pessoa;

public class PessoaDAO implements PessoaDAOInterf {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}	
	
	@Override
	public void atualizar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.session.update(pessoa);
	}

	@Override
	public void excluir(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.session.delete(pessoa);
	}

	@Override
	public void salvar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.session.save(pessoa);
	}

	@Override
	public Pessoa carregar(Integer id) {
		// TODO Auto-generated method stub
		return (Pessoa) this.session.get(Pessoa.class, id);
	}

	@Override
	public List<Pessoa> listar(char tipoPessoa) {
		// TODO Auto-generated method stub
		
		return this.session.createCriteria(Pessoa.class)
				.add(Restrictions.eq("tipoPessoa", tipoPessoa)).list();
	}	
}
