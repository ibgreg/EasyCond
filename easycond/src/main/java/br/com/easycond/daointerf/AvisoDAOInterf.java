package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Aviso;

public interface AvisoDAOInterf {

	public void salvar(Aviso aviso);
	
	public void atualizar(Aviso aviso);
	
	public void excluir(Aviso aviso);
	
	public Aviso carregar(Integer id);
	
	public List<Aviso> listar();
	
	public List<Aviso> carregarAvisoPorOrdemId();
}
