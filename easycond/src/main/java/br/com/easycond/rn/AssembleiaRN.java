package br.com.easycond.rn;

import java.util.Date;
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
	
	public Assembleia carregarAssembleia() {
		return this.assembleiaDAO.carregarAssembleia();
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
	
	public boolean verificaAssembleiaExistente(Integer id, Date dataInicio, Date dataFim) {
		Assembleia assembleiaExistente = this.assembleiaDAO.verificaAssembleiaExistente(dataInicio, dataFim);
		
		if (assembleiaExistente != null && id == null) {
			return true;
		} else {
			return false;
		}
	}
}
