package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.CasaDAOInterf;
import br.com.easycond.model.Casa;

public class CasaDAO implements CasaDAOInterf {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Casa casa) {
		this.session.save(casa);
	}

	@Override
	public void atualizar(Casa casa) {
		this.session.update(casa);

	}

	@Override
	public void excluir(Casa casa) {
		this.session.delete(casa);
	}

	@Override
	public Casa carregar(Integer id) {
		return (Casa) this.session.get(Casa.class, id);
	}

	@Override
	public List<Casa> listar() {
		return this.session.createCriteria(Casa.class).list();
	}
	
}
