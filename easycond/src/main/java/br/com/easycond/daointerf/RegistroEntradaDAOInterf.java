package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.RegistroEntrada;

public interface RegistroEntradaDAOInterf {

	public void atualizar(RegistroEntrada registroEntrada);

	public void excluir(RegistroEntrada registroEntrada);
	
	public void salvar(RegistroEntrada registroEntrada);
	
	public RegistroEntrada carregar(Integer id);
	
	public List<RegistroEntrada> listar();
	
}
