package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.easycond.daointerf.EspacoFisicoDAOInterf;
import br.com.easycond.model.EspacoFisico;

public class EspacoFisicoDAO implements EspacoFisicoDAOInterf {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(EspacoFisico espacoFisico) {
		this.session.save(espacoFisico);
	}

	@Override
	public void atualizar(EspacoFisico espacoFisico) {
		this.session.update(espacoFisico);
	}

	@Override
	public void excluir(EspacoFisico espacoFisico) {
		this.session.delete(espacoFisico);
	}

	@Override
	public EspacoFisico carregar(Integer id) {
		return (EspacoFisico) this.session.get(EspacoFisico.class, id);
	}

	@Override
	public List<EspacoFisico> listar() {
		return this.session.createCriteria(EspacoFisico.class).list();
	}

	@Override
	public EspacoFisico carregarItemCombo(Integer id) {
		String sqlQuery = "select ef from EspacoFisico ef where ef.id = :id";
		Query query = session.createQuery(sqlQuery);
		query.setInteger("id", id);
		
		return (EspacoFisico) query.uniqueResult();
	}
	
	

}
