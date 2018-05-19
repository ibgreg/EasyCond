package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.RegistroSaida;

public interface RegistroSaidaDAOInterf {

	public void atualizar(RegistroSaida registroSaida);

	public void excluir(RegistroSaida registroSaida);
	
	public void salvar(RegistroSaida registroSaida);
	
	public RegistroSaida carregar(Integer id);
	
	public List<RegistroSaida> listar();
	
}
