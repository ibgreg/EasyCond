package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Evento;

public interface EventoDAOInterf {
	
	public void salvar(Evento evento);
	
	public void atualizar(Evento evento);
	
	public void excluir(Evento evento);
	
	public Evento carregar(Integer id);
	
	public List<Evento> listar();
	
}
