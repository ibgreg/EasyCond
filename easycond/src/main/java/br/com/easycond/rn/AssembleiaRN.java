package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.AssembleiaDAOInterf;
import br.com.easycond.model.Assembleia;
import br.com.easycond.util.DAOFactory;

public class AssembleiaRN {

	private AssembleiaDAOInterf assembleiaDAO;
	
	public AssembleiaRN() {
		this.assembleiaDAO = DAOFactory.criarAssembleiaDAO();
	}
	
	public Assembleia carregar(Integer id) {
		return this.assembleiaDAO.carregar(id);
	}
	
	public List<Assembleia> listar() {
		return this.assembleiaDAO.listar();
	}
	
	public void salvar(Assembleia assembleia) {
		Integer id = assembleia.getId();
		
		if (id == null || id == 0) {
			this.assembleiaDAO.salvar(assembleia);
		} else {
			this.assembleiaDAO.atualizar(assembleia);
		}
	}
	
	public void excluir(Assembleia assembleia) {
		this.assembleiaDAO.excluir(assembleia);
	}
}
