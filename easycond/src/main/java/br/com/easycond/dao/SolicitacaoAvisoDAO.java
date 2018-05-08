package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.SolicitacaoAvisoDAOInterf;
import br.com.easycond.model.SolicitacaoAviso;

public class SolicitacaoAvisoDAO implements SolicitacaoAvisoDAOInterf {

	private Session session;

	public void setSession(Session session) {

		this.session = session;
	}

	@Override
	public void excluir(SolicitacaoAviso solicitacaoAviso) {

		this.session.delete(solicitacaoAviso);
	}

	@Override
	public void atualizar(SolicitacaoAviso solicitacaoAviso) {

		this.session.update(solicitacaoAviso);
	}

	@Override
	public void salvar(SolicitacaoAviso solicitacaoAviso) {

		this.session.save(solicitacaoAviso);
	}

	@Override
	public SolicitacaoAviso carregar(Integer id) {

		return (SolicitacaoAviso) this.session.get(SolicitacaoAviso.class, id);
	}

	@Override
	public List<SolicitacaoAviso> listar() {

		return this.session.createCriteria(SolicitacaoAviso.class).list();
	}

}
