package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.easycond.daointerf.ImovelDAOInterf;
import br.com.easycond.model.Imovel;

public class ImovelDAO implements ImovelDAOInterf {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Imovel imovel) {
		this.session.save(imovel);
	}

	@Override
	public void atualizar(Imovel imovel) {
		this.session.update(imovel);

	}

	@Override
	public void excluir(Imovel imovel) {
		this.session.delete(imovel);
	}

	@Override
	public Imovel carregar(Integer id) {
		return (Imovel) this.session.get(Imovel.class, id);
	}

	@Override
	public List<Imovel> listar() {
		return this.session.createCriteria(Imovel.class).list();
	}
	
	@Override
	public List<Imovel> listar(char tipoImovel) {
		return this.session.createCriteria(Imovel.class).
				add(Restrictions.eq("tipoImovel", tipoImovel)).list();
	}

	@Override
	public List<Imovel> listarDistinctAp(char tipoImovel) {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Imovel.class).
				add(Restrictions.eq("tipoImovel", tipoImovel)).
				add(Restrictions.in("numImovel", 
								     session.createCriteria(Imovel.class).
								     setProjection(Projections.distinct(Projections.property("numImovel"))).list()))
							.list();
	}

	@Override
	public List<Imovel> listarImoveisDesocupados() {
		// TODO Auto-generated method stub
		
		return this.session.createCriteria(Imovel.class).
				add(Restrictions.isNull("ocupante")).list();
	}

	@Override
	public List<Imovel> listarImoveisDesocupadosMaisODoCarinha(Integer id) {
		// TODO Auto-generated method stub
		List<Imovel> listaImovel = this.session.createCriteria(Imovel.class).
				add(Restrictions.isNull("ocupante")).list();
		
		listaImovel.add(this.carregar(id));
		
		return listaImovel;
	}
}
