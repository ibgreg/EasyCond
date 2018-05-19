package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.RegistroVisitaDAOInterf;
import br.com.easycond.model.RegistroVisita;

public class RegistroVisitaDAO implements RegistroVisitaDAOInterf {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(RegistroVisita registroVisita) {
		this.session.save(registroVisita);
	}

	@Override
	public void atualizar(RegistroVisita registroVisita) {
		this.session.update(registroVisita);

	}

	@Override
	public void excluir(RegistroVisita registroVisita) {
		this.session.delete(registroVisita);
	}

	@Override
	public RegistroVisita carregar(Integer id) {
		return (RegistroVisita) this.session.get(RegistroVisita.class, id);
	}

	@Override
	public List<RegistroVisita> listar() {
		return this.session.createCriteria(RegistroVisita.class).list();
	}

}
