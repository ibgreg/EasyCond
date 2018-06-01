package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import br.com.easycond.daointerf.RegistroMoradaDAOInterf;
import br.com.easycond.model.RegistroMorada;

public class RegistroMoradaDAO implements RegistroMoradaDAOInterf {

	Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(RegistroMorada registroMorada) {
		this.session.save(registroMorada);
	}

	@Override
	public void atualizar(RegistroMorada registroMorada) {
		this.session.update(registroMorada);

	}

	@Override
	public void excluir(RegistroMorada registroMorada) {
		this.session.delete(registroMorada);
	}

	@Override
	public RegistroMorada carregar(Integer id) {
		return (RegistroMorada) this.session.get(RegistroMorada.class, id);
	}

	@Override
	public List<RegistroMorada> listar() {
		return this.session.createCriteria(RegistroMorada.class).list();
	}
	
	@Override
	public List<RegistroMorada> listar(Criterion criterion) {
		return this.session.createCriteria(RegistroMorada.class)
				.add(criterion).list();
	}
}
