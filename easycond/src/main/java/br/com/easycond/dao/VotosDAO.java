package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.easycond.daointerf.VotosDAOInterf;
import br.com.easycond.model.Votos;

public class VotosDAO implements VotosDAOInterf {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Votos votos) {
		this.session.save(votos);
	}

	@Override
	public void atualizar(Votos votos) {
		this.session.update(votos);
	}

	@Override
	public Votos carregar(Integer id) {
		return (Votos) this.session.get(Votos.class, id);
	}

	@Override
	public List<Votos> listar() {
		return this.session.createCriteria(Votos.class).list();
	}

	@Override
	public List<Votos> listarVotosContra(Integer id) {
		String sqlQuery = "select v from Votos v where v.opcao = 'C' and v.idEnquete = :idEnquete";
		Query query = session.createQuery(sqlQuery);
		query.setInteger("idEnquete", id);
		
		List<Votos> listaVotos = query.list();
		return listaVotos;
	}

	@Override
	public List<Votos> listarVotosFavor(Integer id) {
		String sqlQuery = "select v from Votos v where v.opcao = 'F' and v.idEnquete = :idEnquete";
		Query query = session.createQuery(sqlQuery);
		query.setInteger("idEnquete", id);
		
		List<Votos> listaVotos = query.list();
		return listaVotos;
	}
	
	

}
