package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Votos;

public interface VotosDAOInterf {

	public void salvar(Votos votos);
	
	public void atualizar(Votos votos);
	
	public Votos carregar(Integer id);
	
	public List<Votos> listar();
	
	public List<Votos> listarVotosContra(Integer id);
	
	public List<Votos> listarVotosFavor(Integer id);
	
	public Votos verificaVotoExistente(Integer id, String nomeUsuario);
	
}
