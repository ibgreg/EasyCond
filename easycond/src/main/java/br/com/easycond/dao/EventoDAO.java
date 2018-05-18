package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.EventoDAOInterf;
import br.com.easycond.model.Evento;

public class EventoDAO implements EventoDAOInterf {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Evento evento) {
		this.session.save(evento);
	}

	@Override
	public void atualizar(Evento evento) {
		this.session.update(evento);
	}

	@Override
	public void excluir(Evento evento) {
		this.session.delete(evento);
	}

	@Override
	public Evento carregar(Integer id) {
		return (Evento) this.session.get(Evento.class, id);
	}

	@Override
	public List<Evento> listar() {
		return this.session.createCriteria(Evento.class).list();
	}

}
