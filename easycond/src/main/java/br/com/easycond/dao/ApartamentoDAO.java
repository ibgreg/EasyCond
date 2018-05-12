package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.ApartamentoDAOInterf;
import br.com.easycond.model.Apartamento;

public class ApartamentoDAO implements ApartamentoDAOInterf {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Apartamento apartamento) {
		this.session.save(apartamento);
	}

	@Override
	public void atualizar(Apartamento apartamento) {
		this.session.update(apartamento);

	}

	@Override
	public void excluir(Apartamento apartamento) {
		this.session.delete(apartamento);
	}

	@Override
	public Apartamento carregar(Integer id) {
		return (Apartamento) this.session.get(Apartamento.class, id);
	}

	@Override
	public List<Apartamento> listar() {
		return this.session.createCriteria(Apartamento.class).list();
	}
	
	
}
