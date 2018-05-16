package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.ReservaDAOInterf;
import br.com.easycond.model.Reserva;

public class ReservaDAO implements ReservaDAOInterf {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Reserva reserva) {
		this.session.save(reserva);
	}

	@Override
	public void atualizar(Reserva reserva) {
		this.session.update(reserva);
	}

	@Override
	public void excluir(Reserva reserva) {
		this.session.delete(reserva);
	}

	@Override
	public Reserva carregar(Integer id) {
		return (Reserva) this.session.get(Reserva.class, id);
	}

	@Override
	public List<Reserva> listar() {
		return this.session.createCriteria(Reserva.class).list();
	}

}
