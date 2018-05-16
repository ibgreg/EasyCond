package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.EspacoFisicoDAOInterf;
import br.com.easycond.model.EspacoFisico;
import br.com.easycond.util.DAOFactory;

public class EspacoFisicoRN {
	
	private EspacoFisicoDAOInterf espacoFisicoDAO;
	
	public EspacoFisicoRN() {
		this.espacoFisicoDAO = DAOFactory.criarEspacoFisicoDAO();
	}
	
	public EspacoFisico carregar(Integer id) {
		return this.espacoFisicoDAO.carregar(id);
	}
	
	public List<EspacoFisico> listar() {
		return this.espacoFisicoDAO.listar();
	}
	
	public EspacoFisico carregarItemCombo(Integer id) {
		this.espacoFisicoDAO = DAOFactory.criarEspacoFisicoDAO();
		return this.espacoFisicoDAO.carregarItemCombo(id);
	}
}
