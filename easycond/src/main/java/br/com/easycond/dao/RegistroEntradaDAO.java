package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.RegistroEntradaDAOInterf;
import br.com.easycond.model.RegistroEntrada;

public class RegistroEntradaDAO implements RegistroEntradaDAOInterf {

	Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(RegistroEntrada registroEntrada) {
		this.session.save(registroEntrada);
	}

	@Override
	public void atualizar(RegistroEntrada registroEntrada) {
		this.session.update(registroEntrada);

	}

	@Override
	public void excluir(RegistroEntrada registroEntrada) {
		this.session.delete(registroEntrada);
	}

	@Override
	public RegistroEntrada carregar(Integer id) {
		return (RegistroEntrada) this.session.get(RegistroEntrada.class, id);
	}

	@Override
	public List<RegistroEntrada> listar() {
		return this.session.createCriteria(RegistroEntrada.class).list();
	}
}
