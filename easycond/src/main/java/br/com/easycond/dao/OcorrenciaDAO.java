package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.easycond.daointerf.OcorrenciaDAOInterf;
import br.com.easycond.model.Ocorrencia;

public class OcorrenciaDAO implements OcorrenciaDAOInterf {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Ocorrencia ocorrencia) {
		this.session.save(ocorrencia);
	}

	@Override
	public void atualizar(Ocorrencia ocorrencia) {
		this.session.update(ocorrencia);
	}

	@Override
	public void excluir(Ocorrencia ocorrencia) {
		this.session.delete(ocorrencia);
	}

	@Override
	public Ocorrencia carregar(Integer id) {
		return (Ocorrencia) this.session.get(Ocorrencia.class, id);
	}

	@Override
	public List<Ocorrencia> listar() {
		return this.session.createCriteria(Ocorrencia.class).list();
	}

	@Override
	public List<Ocorrencia> obterOcorrenciaPorUsuario(Integer idUsuario) {
		String sqlQuery = "select oc from Ocorrencia oc where oc.usuarioOcorrencia = :idUsuario "
				+ "order by oc.dataOcorrencia desc";
		Query query = session.createQuery(sqlQuery);
		query.setInteger("idUsuario", idUsuario);
		
		return query.list();
	}
	
}
