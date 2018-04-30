package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.AvisoDAOInterf;
import br.com.easycond.model.Aviso;

public class AvisoDAO implements AvisoDAOInterf {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Aviso aviso) {
		this.session.save(aviso);
	}

	@Override
	public void atualizar(Aviso aviso) {
		this.session.update(aviso);

	}

	@Override
	public void excluir(Aviso aviso) {
		this.session.delete(aviso);
	}

	@Override
	public Aviso carregar(Integer id) {
		return (Aviso) this.session.get(Aviso.class, id);
	}

	@Override
	public List<Aviso> listar() {
		return this.session.createCriteria(Aviso.class).list();
	}

}
