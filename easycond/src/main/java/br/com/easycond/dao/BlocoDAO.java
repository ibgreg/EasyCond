package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.BlocoDAOInterf;
import br.com.easycond.model.Bloco;

public class BlocoDAO implements BlocoDAOInterf {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Bloco bloco) {
		this.session.save(bloco);
	}

	@Override
	public void atualizar(Bloco bloco) {
		this.session.update(bloco);

	}

	@Override
	public void excluir(Bloco bloco) {
		this.session.delete(bloco);
	}

	@Override
	public Bloco carregar(Integer id) {
		return (Bloco) this.session.get(Bloco.class, id);
	}

	@Override
	public List<Bloco> listar() {
		return this.session.createCriteria(Bloco.class).list();
	}
}
