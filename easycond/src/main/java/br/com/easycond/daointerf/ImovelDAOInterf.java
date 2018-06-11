package br.com.easycond.daointerf;

import java.util.List;

import org.hibernate.criterion.Criterion;

import br.com.easycond.model.Imovel;

public interface ImovelDAOInterf {

	public void salvar(Imovel imovel);

	public void atualizar(Imovel imovel);

	public void excluir(Imovel imovel);

	public Imovel carregar(Integer id);

	public List<Imovel> listar();
	
	public List<Imovel> listar(char tipoImovel);
	
	public List<Imovel> listarDistinctAp(char tipoImovel);
	
	public List<Imovel> listarImoveisDesocupados();
	
	public List<Imovel> listarImoveisDesocupadosMaisODoCarinha(Integer id);
}
