package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.CondominoDAOInterf;
import br.com.easycond.model.Condomino;

public class CondominoDAO implements CondominoDAOInterf{

	private Session session;
	
	public void setSession(Session session) {
		
		this.session = session;
	}
	
	@Override
	public void excluir(Condomino condomino) {
		
		this.session.delete(condomino);
	}
	
	@Override
	public void atualizar(Condomino condomino) {
		
		this.session.update(condomino);
	}
	
	@Override
	public void salvar(Condomino condomino) {
		
		this.session.save(condomino);
	}
	
	@Override
	public Condomino carregar(Integer id) {
		
		return (Condomino) this.session.get(Condomino.class, id);
	}
	
	@Override
	public List<Condomino> listar(){
		
		return this.session.createCriteria(Condomino.class).list();
	}
}
