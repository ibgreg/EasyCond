package br.com.easycond.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.easycond.daointerf.FuncionarioDAOInterf;
import br.com.easycond.model.Funcionario;

public class FuncionarioDAO implements FuncionarioDAOInterf{

	private Session session;
	
	public void setSession(Session session) {
		
		this.session = session;
	}
	
	@Override
	public void excluir(Funcionario funcionario) {
		
		this.session.delete(funcionario);
	}
	
	@Override
	public void atualizar(Funcionario funcionario) {
		
		this.session.update(funcionario);
	}
	
	@Override
	public void salvar(Funcionario funcionario) {
		
		this.session.save(funcionario);
	}
	
	@Override
	public Funcionario carregar(Integer id) {
		
		return (Funcionario) this.session.get(Funcionario.class, id);
	}
	
	@Override
	public List<Funcionario> listar(){
		
		return this.session.createCriteria(Funcionario.class).list();
	}
}
