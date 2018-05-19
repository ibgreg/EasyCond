package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.RegistroSaidaDAOInterf;
import br.com.easycond.model.RegistroSaida;

public class RegistroSaidaDAO implements RegistroSaidaDAOInterf {

	Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(RegistroSaida registroSaida) {
		this.session.save(registroSaida);
	}

	@Override
	public void atualizar(RegistroSaida registroSaida) {
		this.session.update(registroSaida);

	}

	@Override
	public void excluir(RegistroSaida registroSaida) {
		this.session.delete(registroSaida);
	}

	@Override
	public RegistroSaida carregar(Integer id) {
		return (RegistroSaida) this.session.get(RegistroSaida.class, id);
	}

	@Override
	public List<RegistroSaida> listar() {
		return this.session.createCriteria(RegistroSaida.class).list();
	}
}
