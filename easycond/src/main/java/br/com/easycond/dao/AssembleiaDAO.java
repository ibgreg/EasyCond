package br.com.easycond.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.easycond.daointerf.AssembleiaDAOInterf;
import br.com.easycond.model.Assembleia;

public class AssembleiaDAO implements AssembleiaDAOInterf {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Assembleia assembleia) {
		this.session.save(assembleia);
	}

	@Override
	public void atualizar(Assembleia assembleia) {
		this.session.merge(assembleia);
	}

	@Override
	public void excluir(Assembleia assembleia) {
		this.session.delete(assembleia);
	}

	@Override
	public Assembleia carregar(Integer id) {
		return (Assembleia) this.session.get(Assembleia.class, id);
	}

	@Override
	public List<Assembleia> listar() {
		return this.session.createCriteria(Assembleia.class).list();
	}
	
	@Override
	public Assembleia carregarAssembleia() {
		String sqlQuery = "select a from Assembleia a inner join a.enquete e where sysdate() between a.dataInicio and a.dataFim";
		Query query = session.createQuery(sqlQuery);
		
		return (Assembleia) query.uniqueResult();
	}

	@Override
	public Assembleia verificaAssembleiaExistente(Date dataInicio, Date dataFim) {
		String sqlQuery = "select a from Assembleia a inner join a.enquete e where (:dataInicio >= a.dataInicio and :dataFim <= a.dataFim) "
				+ "or (:dataInicio between a.dataInicio and a.dataFim) "
				+ "or (:dataFim between a.dataInicio and a.dataFim)";
		Query query = session.createQuery(sqlQuery);
		query.setDate("dataInicio", dataInicio);
		query.setDate("dataFim", dataFim);
		
		return (Assembleia) query.uniqueResult();

	}

}
