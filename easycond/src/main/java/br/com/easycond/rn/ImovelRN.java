package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.ImovelDAOInterf;
import br.com.easycond.model.Bloco;
import br.com.easycond.model.Imovel;
import br.com.easycond.util.DAOFactory;

public class ImovelRN {

	private ImovelDAOInterf imovelDAO;

	public ImovelRN() {

		this.imovelDAO = DAOFactory.criarImovelDAO();
	}

	public Imovel carregar(Integer id) {

		return this.imovelDAO.carregar(id);
	}

	public List<Imovel> listar() {

		return this.imovelDAO.listar();
	}
	
	public List<Imovel> listarDistinctAp(char tipoImovel) {

		return this.imovelDAO.listarDistinctAp(tipoImovel);
	}
	
	public List<Imovel> listar(char tipoImovel) {

		return this.imovelDAO.listar(tipoImovel);
	}
	
	public List<Imovel> listarImoveisDesocupados() {

		return this.imovelDAO.listarImoveisDesocupados();
	}
	
	public List<Imovel> listarImoveisDesocupadosMaisODoCarinha(Integer id){
		
		return this.imovelDAO.listarImoveisDesocupadosMaisODoCarinha(id);
	}

	public void salvar(Imovel imovel) {

		Integer id = imovel.getId();

		BlocoRN blocoRN = new BlocoRN();
		
		//Bloco bloco;
		
		List<Bloco> blocos = blocoRN.listar();
		
		if (id == null || id == 0) {
			
			for(Bloco bl : blocos) {
				
				imovel.setBloco(bl);
				
				this.imovelDAO.salvar(imovel);
			}			
			
		} else {
			
			this.imovelDAO.atualizar(imovel);
		}
	}

	public void excluir(Imovel imovel) {

		this.imovelDAO.excluir(imovel);
	}
	
}
