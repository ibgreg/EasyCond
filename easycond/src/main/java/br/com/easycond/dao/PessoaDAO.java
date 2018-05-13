package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.PessoaDAOInterf;
import br.com.easycond.model.Aviso;
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
		return (Pessoa) this.session.get(Aviso.class, id);
	}

	@Override
	public List<Pessoa> listar() {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Aviso.class).list();
	}	
}