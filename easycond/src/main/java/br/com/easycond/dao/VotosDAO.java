package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.VotosDAOInterf;
import br.com.easycond.model.Votos;

public class VotosDAO implements VotosDAOInterf {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Votos votos) {
		this.session.save(votos);
	}

	@Override
	public void atualizar(Votos votos) {
		this.session.update(votos);
	}

	@Override
	public Votos carregar(Integer id) {
		return (Votos) this.session.get(Votos.class, id);
	}

	@Override
	public List<Votos> listar() {
		return this.session.createCriteria(Votos.class).list();
	}

}
