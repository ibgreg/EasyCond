package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.AssembleiaDAOInterf;
import br.com.easycond.model.Assembleia;

public class AssembleiaDAO implements AssembleiaDAOInterf {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Assembleia assembleia) {
		this.session.save(assembleia);
	}

	@Override
	public void atualizar(Assembleia assembleia) {
		this.session.update(assembleia);
	}

	@Override
	public void excluir(Assembleia assembleia) {
		this.session.delete(assembleia);
	}

	@Override
	public Assembleia carregar(Integer id) {
		return (Assembleia) this.session.get(Assembleia.class, id);
	}

	@Override
	public List<Assembleia> listar() {
		return this.session.createCriteria(Assembleia.class).list();
	}

}
