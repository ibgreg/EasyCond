package br.com.easycond.daointerf;

import java.util.List;

import org.hibernate.criterion.Criterion;

import br.com.easycond.model.RegistroMorada;

public interface RegistroMoradaDAOInterf {

	public void atualizar(RegistroMorada registroMorada);

	public void excluir(RegistroMorada registroMorada);
	
	public void salvar(RegistroMorada registroMorada);
	
	public RegistroMorada carregar(Integer id);
	
	public List<RegistroMorada> listar();
	
	public List<RegistroMorada> listar(Criterion criterion);
	
}
